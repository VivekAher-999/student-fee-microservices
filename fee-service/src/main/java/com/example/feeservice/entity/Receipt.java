package com.example.feeservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

@Entity
public class Receipt {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
  private String receiptNumber;

  @NotNull
  private String studentId;

  private String studentName;
  private String grade;
  private String schoolName;
  private String mobileNumber;

  @NotNull
  private Double amount;

  private String paymentMode;
  private LocalDateTime paymentDate;
  private String remarks;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getReceiptNumber() { return receiptNumber; }
  public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }

  public String getStudentId() { return studentId; }
  public void setStudentId(String studentId) { this.studentId = studentId; }

  public String getStudentName() { return studentName; }
  public void setStudentName(String studentName) { this.studentName = studentName; }

  public String getGrade() { return grade; }
  public void setGrade(String grade) { this.grade = grade; }

  public String getSchoolName() { return schoolName; }
  public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

  public String getMobileNumber() { return mobileNumber; }
  public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

  public Double getAmount() { return amount; }
  public void setAmount(Double amount) { this.amount = amount; }

  public String getPaymentMode() { return paymentMode; }
  public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

  public LocalDateTime getPaymentDate() { return paymentDate; }
  public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

  public String getRemarks() { return remarks; }
  public void setRemarks(String remarks) { this.remarks = remarks; }
}
