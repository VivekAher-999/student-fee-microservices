package com.example.feeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.feeservice.client")
public class ReceiptServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReceiptServiceApplication.class, args);
  }
}
