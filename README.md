Perfect! Here’s a **GitHub-friendly version** of your README with badges and a clean one-line description at the top, ready to copy-paste into `README.md`:

```markdown
# InsightSphere – Blog Application Backend 🚀

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

**InsightSphere** is a Java Spring Boot backend for a blog application, providing secure user registration and login with DTO mapping and password hashing. Ready to integrate with frontend applications and extend with JWT-based authentication.

---

## Features

- **User Registration**
  - Unique username and email validation
  - Passwords hashed securely with Spring Security `PasswordEncoder`
  - Returns safe `UserDTO` (no passwords exposed)

- **User Login**
  - Authenticates username and password
  - Unified `InvalidCredentialsException` for security
  - Returns `UserDTO` with safe fields only

- **DTO Mapping**
  - All responses via `mapToDTO()` helper
  - Keeps sensitive data safe

- **Exception Handling**
  - `UserValidationException` for registration issues
  - `InvalidCredentialsException` for login failures

- **Extensible**
  - Placeholder methods for future features (update, delete, get users)
  - Ready for JWT, role-based access control, and blog post CRUD

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (`PasswordEncoder`)
- Maven
- H2 / MySQL (or any SQL database)

---

## Project Structure

```

com.insightsphere.blogapp
│
├─ controller       # REST controllers (to be implemented)
├─ dto              # Data Transfer Objects
│    ├─ UserDTO.java
│    └─ LoginDTO.java
├─ entity           # JPA entities
│    └─ User.java
├─ repository       # Spring Data JPA repositories
│    └─ UserRepository.java
├─ service
│    ├─ UserService.java
│    └─ impl
│         └─ UserServiceImplementation.java
└─ exception        # Custom exceptions
├─ InvalidCredentialsException.java
├─ UserNotFoundException.java
└─ UserValidationException.java

```

---

## Getting Started

1. **Clone the repository**

```bash
git clone https://github.com/Sidhant2104/insightsphere.git
cd insightsphere
````

2. **Configure Database**

* Update `application.properties` with your DB details (H2/MySQL).

3. **Build & Run**

```bash
mvn clean install
mvn spring-boot:run
```

4. **Test API**

* Register: `POST /api/users/register`
* Login: `POST /api/users/login`

**Register Payload**

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "username": "johndoe",
  "email": "john@example.com",
  "password": "securePass123"
}
```

**Login Payload**

```json
{
  "username": "johndoe",
  "password": "securePass123"
}
```

---

## Next Steps / Planned Features

* JWT authentication for stateless login
* Role-based access control
* Blog post CRUD operations
* Unit and integration tests
* Global exception handling with structured JSON responses

---

## Contributors

* **Sidhant Singh (Leo)** – Developer & Maintainer

---

## License

This project is open-source under the MIT License.


