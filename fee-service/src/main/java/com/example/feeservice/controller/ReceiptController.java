package com.example.feeservice.controller;

import com.example.feeservice.client.StudentClient;
import com.example.feeservice.dto.StudentDTO;
import com.example.feeservice.entity.Receipt;
import com.example.feeservice.repository.ReceiptRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    private final ReceiptRepository repo;
    private final StudentClient studentClient;

    public ReceiptController(ReceiptRepository repo, StudentClient studentClient) {
        this.repo = repo;
        this.studentClient = studentClient;
    }

    @PostMapping
    @CircuitBreaker(name = "studentServiceCB", fallbackMethod = "collectFeeFallback")
    public ResponseEntity<Receipt> collectFee(@Valid @RequestBody Receipt r) {
        StudentDTO student = studentClient.getStudentById(r.getStudentId());
        if (student == null) {
            return ResponseEntity.badRequest().build();
        }

        r.setStudentName(student.getStudentName());
        r.setGrade(student.getGrade());
        r.setMobileNumber(student.getMobileNumber());
        r.setSchoolName(student.getSchoolName());

        if (r.getReceiptNumber() == null || r.getReceiptNumber().isBlank()) {
            String rn = "RCPT-" + LocalDateTime.now().toLocalDate().toString().replaceAll("-", "") + "-" +
                    UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            r.setReceiptNumber(rn);
        }

        if (r.getPaymentDate() == null) r.setPaymentDate(LocalDateTime.now());
        Receipt saved = repo.save(r);
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<Receipt> collectFeeFallback(Receipt r, Throwable t) {
        r.setStudentName("Unknown");
        if (r.getPaymentDate() == null) r.setPaymentDate(LocalDateTime.now());
        if (r.getReceiptNumber() == null || r.getReceiptNumber().isBlank()) {
            r.setReceiptNumber("RCPT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        Receipt saved = repo.save(r);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Receipt> listAll() {
        return repo.findAll();
    }

    @GetMapping("/{receiptNumber}")
    public ResponseEntity<Receipt> getByNumber(@PathVariable String receiptNumber) {
        return repo.findByReceiptNumber(receiptNumber).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
