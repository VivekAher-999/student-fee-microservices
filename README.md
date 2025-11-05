# 🧮 Student Fee Management Microservices

A simple **Spring Boot 3** microservices project to manage **student details** and **fee collection**, built with:
- **Spring Boot 3**
- **Spring Data JPA (H2 Database)**
- **OpenFeign** for service-to-service communication
- **Resilience4j Circuit Breaker**
- **Springdoc OpenAPI (Swagger UI)**
- **H2 In-memory database**
- **RESTful API architecture**

---

## 🧩 Project Modules

| Service | Port | Description |
|----------|------|--------------|
| 🎓 `student-service` | `8081` | Manages student details |
| 💰 `fee-service` | `8082` | Manages fee receipts and communicates with student-service using Feign |

---

## 🚀 How to Run

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/student-fee-microservices.git
cd student-fee-microservices

Student Service (Port 8081)
| Method | Endpoint                    | Description       |
| ------ | --------------------------- | ----------------- |
| `POST` | `/api/students`             | Add new student   |
| `GET`  | `/api/students/{studentId}` | Get student by ID |
| `GET`  | `/api/students`             | List all students |

Fee Service (Port 8082)
| Method | Endpoint             | Description        |
| ------ | -------------------- | ------------------ |
| `POST` | `/api/receipts`      | Create new receipt |
| `GET`  | `/api/receipts`      | Get all receipts   |
| `GET`  | `/api/receipts/{id}` | Get receipt by ID  |

Swagger API Documentation
Service	Swagger UI	OpenAPI Spec (YAML)
🎓 Student Service	http://localhost:8081/swagger-ui/index.html
	http://localhost:8081/v3/api-docs.yaml

💰 Fee Service	http://localhost:8082/swagger-ui/index.html
	http://localhost:8082/v3/api-docs.yaml

Technologies Used

Java 17

Spring Boot 3.3+

Spring Web

Spring Data JPA (H2)

Spring Cloud OpenFeign

Resilience4j (Circuit Breaker)

Springdoc OpenAPI (Swagger)

Maven

Example Flow

Add Student (to student-service)

{
  "studentId": "S1001",
  "studentName": "Asha Kumar",
  "grade": "5",
  "mobileNumber": "9876543210",
  "schoolName": "Global Public School"
}


Create Receipt (via fee-service)

{
  "studentId": "S1001",
  "amount": 2500,
  "paymentMode": "UPI",
  "remarks": "Tuition Fee - November 2025"
}


View Receipts

GET http://localhost:8082/api/receipts

⚙️ Resilience4j & Feign Client

fee-service calls student-service via Feign Client

If student-service is unavailable, Resilience4j provides fallback response:

@FeignClient(name = "student-service", url = "http://localhost:8081", fallback = StudentClientFallback.class)
public interface StudentClient {
    @GetMapping("/api/students/{studentId}")
    Student getStudentById(@PathVariable String studentId);
}

📚 Author

Vivek Aher
📧 ahervivek256@gmail.com
