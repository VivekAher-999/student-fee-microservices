# Student & Fee Microservices (Feign + Circuit Breaker)

This archive contains two Spring Boot microservices:

1. student-service (port 8081) - manages students
2. fee-service (port 8082) - creates receipts and validates student via Feign client with Resilience4j circuit breaker

## Run (Java 17 required)

Build and run each service separately.

### student-service
cd student-service
mvn clean package
java -jar target/student-service-0.0.1-SNAPSHOT.jar
Swagger: http://localhost:8081/swagger-ui.html
H2 Console: http://localhost:8081/h2-console  (JDBC URL: jdbc:h2:mem:studentdb)

### fee-service
cd fee-service
mvn clean package
java -jar target/fee-service-0.0.1-SNAPSHOT.jar
Swagger: http://localhost:8082/swagger-ui.html
H2 Console: http://localhost:8082/h2-console (JDBC URL: jdbc:h2:mem:feedb)

## Notes
- fee-service calls student-service using OpenFeign to fetch student details before saving a receipt.
- Resilience4j circuit breaker + fallback is configured for the Feign client in fee-service (fallback class included).
- The pom files use Spring Boot 3.5.7 and Spring Cloud 2025.0.0 BOM.
