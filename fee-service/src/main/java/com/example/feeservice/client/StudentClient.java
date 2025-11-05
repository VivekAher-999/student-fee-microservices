package com.example.feeservice.client;

import com.example.feeservice.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "http://localhost:8081", fallback = StudentClientFallback.class)
public interface StudentClient {
    @GetMapping("/api/students/{studentId}")
    StudentDTO getStudentById(@PathVariable("studentId") String studentId);
}
