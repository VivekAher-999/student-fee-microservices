package com.example.feeservice.client;

import com.example.feeservice.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentClientFallback implements StudentClient {
    @Override
    public StudentDTO getStudentById(String studentId) {
        StudentDTO s = new StudentDTO();
        s.setStudentId(studentId);
        s.setStudentName("Unknown");
        s.setGrade("N/A");
        s.setMobileNumber("N/A");
        s.setSchoolName("N/A");
        return s;
    }
}
