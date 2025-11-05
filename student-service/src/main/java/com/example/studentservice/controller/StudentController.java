package com.example.studentservice.controller;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

  private final StudentRepository repo;
  public StudentController(StudentRepository repo){ this.repo = repo; }

  @PostMapping
  public ResponseEntity<Student> addStudent(@Valid @RequestBody Student s){
    if(repo.existsById(s.getStudentId())){
      return ResponseEntity.badRequest().build();
    }
    Student saved = repo.save(s);
    return ResponseEntity.ok(saved);
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<Student> getStudent(@PathVariable String studentId){
    return repo.findById(studentId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Student> listStudents(){ return repo.findAll(); }
}
