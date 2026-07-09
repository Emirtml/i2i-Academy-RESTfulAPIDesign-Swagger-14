# i2i Academy - Enterprise Customer Management RESTful API
## Homework 14: RESTful API Design & Swagger Integration

---

## 📝 Detailed Project Description

The **Customer Management System RESTful API** is an enterprise-grade backend application architected during the i2i Academy software engineering internship program. The core vision of this project is to build a high-performance, secure, scalable, and loosely coupled system capable of managing core customer infrastructures.

In modern software engineering, exposing raw database models directly to external clients introduces severe security risks (such as mass-assignment vulnerabilities) and tight architectural coupling. To eliminate these constraints, this project strictly implements the **DTO (Data Transfer Object)** design pattern. By separating the internal database structures from the external presentation layer, we ensure optimal data encapsulation and system security.

Furthermore, the application integrates with an **Oracle Database**, a dominant relational database management system (RDBMS) in enterprise corporate networks. To isolate the development ecosystem and guarantee the "it works on my machine" consistency across different environments, the Oracle database is containerized and deployed seamlessly inside a **Docker** container. The entire API surface is structuralized and fully exposed via **Swagger UI (OpenAPI 3.0)**, eliminating the need for external testing tools like Postman and providing self-documenting capabilities.

---

## 🏛️ Architectural Blueprint (Layered Architecture)

The application adheres to a strict **Layered Architecture (Multi-Tier Architecture)** paradigm. This enforces the Separation of Concerns (SoC) principle, meaning each software component operates within a single, dedicated boundary of responsibility:

- **Entity Layer (`entity`):** Represents the pure Object-Relational Mapping (ORM) models. These Java classes map directly to the physical relational columns inside the Oracle database schema using Jakarta Persistence (JPA) specifications.
- **DTO Layer (`dto`):** Serves as a data protection shield. Data Transfer Objects establish the strict boundary of data exchange between the client side and the internal backend services, masking internal database specifics.
- **Repository Layer (`repository`):** Powered by **Spring Data JPA**, this layer acts as the data abstraction specialist. It completely encapsulates data-access logic, giving the application out-of-the-box CRUD capabilities without requiring manual, boilerplate SQL syntax.
- **Service Layer (`service`):** Represents the central intelligence engine of the system. All core business logic, mapping routines (converting Entities to DTOs and vice versa), and transaction boundaries are rigidly executed within this domain.
- **Controller Layer (`controller`):** Functions as the system's digital reception desk. It intercepts incoming HTTP REST operations, delegates payload processing downstream to the Service Layer, and delivers standardized, structured HTTP Responses back to the client.

---

## 🛠️ Tech Stack & Development Tools

The development ecosystem leverages the following technologies to maintain production-ready robustness:

- **Java (JDK 17/21):** The foundational, robust, object-oriented programming language driving the core execution.
- **Spring Boot (v3.x):** The premier microservices framework utilized to accelerate production-grade web application deployment, managing embedded Tomcat configurations automatically.
- **Oracle Database 21c (Express Edition):** The primary, highly persistent storage engine managing relational data integrity.
- **Docker:** Utilized for containerization, hosting the Oracle environment inside a lightweight, sandboxed container to maintain structural portability.
- **Spring Data JPA & Hibernate:** The object-relational mapping tool that translates programmatic object structures directly into relational database instructions.
- **Springdoc OpenAPI (Swagger UI v2.5.0):** An automated documentation engine that generates visual, live, interactive UI dashboards for API runtime monitoring.
- **Apache Maven:** The comprehensive build automation and project dependency manager configured via the central `pom.xml` manifest.
- **Git & GitHub:** The distributed version control workflow utilized to publish production source code tracking clear, meaningful English commit histories.

---

## ⚙️ Environment Configuration & Setup

### 1. Initialize the Containerized Oracle Instance
Execute the following container instruction in your native command terminal to fetch and deploy the isolated Oracle Database image:
```bash
docker run -d -p 1533:1521 --name oracle-db [container-registry.oracle.com/database/express:21.3.0-xe](https://container-registry.oracle.com/database/express:21.3.0-xe)
