package com.example.studentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Student {
  @Id
  @Column(nullable = false, unique = true)
  private String studentId;

  @NotBlank
  private String studentName;

  private String grade;
  private String mobileNumber;
  private String schoolName;

  public String getStudentId() { return studentId; }
  public void setStudentId(String studentId) { this.studentId = studentId; }

  public String getStudentName() { return studentName; }
  public void setStudentName(String studentName) { this.studentName = studentName; }

  public String getGrade() { return grade; }
  public void setGrade(String grade) { this.grade = grade; }

  public String getMobileNumber() { return mobileNumber; }
  public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

  public String getSchoolName() { return schoolName; }
  public void setSchoolName(String schoolName) { this.schoolName = schoolName; }
}
