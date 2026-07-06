# LeaveFlow - Leave Management System

## Project Overview

LeaveFlow is a Leave Management System developed using Spring Boot, Spring Data JPA (Hibernate), MySQL, and Maven.

The system automates employee leave management by allowing employees to apply for leave while managers review, approve, or reject leave requests.

---

# Tech Stack

## Backend

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- Maven

## Database

- MySQL

## IDE

- IntelliJ IDEA

## Version Control

- Git
- GitHub

---

# Project Architecture

```text
Controller
      ↓
Service
      ↓
Repository
      ↓
MySQL Database
```

---

# Project Structure

```text
com.leaveflow.leaveflow

├── controller
├── service
├── repository
├── model
├── enums
├── dto
├── exception
├── config
├── validation
└── LeaveflowApplication
```

---

# Database Design

## Tables

- users
- departments
- roles
- leave_types
- leave_requests

## Relationships

### Department

```text
Department
     │
     │
Many Users
```

### Role

```text
Role
    │
    │
Many Users
```

### Manager

```text
User
   │
   │
Many Employees
```

Each employee is assigned to one manager.

---

# Entity Implementation

## Users

### Fields

- userId
- firstName
- lastName
- email
- password
- phoneNo
- joiningDate
- leaveBalance
- status
- department
- role
- manager

### Relationships

- ManyToOne → Department
- ManyToOne → Role
- ManyToOne → Manager (Self Reference)

---

## Department

### Fields

- deptId
- deptName

Relationship

One department can contain multiple users.

---

## Role

### Fields

- roleId
- roleName

Relationship

One role can be assigned to multiple users.

---

## LeaveType

### Fields

- leaveTypeId
- leaveTypeName
- maxLeaves
- description

Relationship

Referenced by Leave Requests.

---

## LeaveRequest

### Fields

- leaveId
- startDate
- endDate
- reason
- appliedDate
- leaveStatus
- approvedBy
- user
- leaveType

---

# Enums

## UserStatus

```java
ACTIVE
INACTIVE
```

Stored using

```java
@Enumerated(EnumType.STRING)
```

---

# JPA Relationships Used

## ManyToOne

Implemented in

- Department
- Role
- Manager
- LeaveType
- User

Example

```java
@ManyToOne
@JoinColumn(name = "dept_id")
private Department department;
```

---

# Database Constraints

- PRIMARY KEY
- AUTO_INCREMENT
- FOREIGN KEY
- NOT NULL
- UNIQUE
- ENUM

---

# Development Progress

## Day 1 — July 1, 2026

### Project Initialization

Completed

- Created Spring Boot project
- Configured Maven
- Connected MySQL database
- Configured application.properties
- Created project package structure
- Created Entity package
- Created Repository package
- Created Service package
- Created Controller package
- Created Enum package
- Learned Spring Boot layered architecture

### Concepts Learned

- Spring Boot Project Structure
- Maven Configuration
- Layered Architecture

---

## Day 2 — July 2, 2026

### Database & Entity Development

Completed

- Designed database schema
- Created Users entity
- Created Department entity
- Created Role entity
- Implemented JPA annotations
- Implemented entity relationships
- Added UserStatus enum
- Generated database tables using Hibernate
- Verified table creation in MySQL

### Concepts Learned

- Entity Mapping
- Hibernate
- JPA
- ManyToOne Mapping
- JoinColumn
- Enum Mapping
- Auto Increment
- Foreign Keys

---

## Day 3 — July 3, 2026

### Repository & Service Development

Completed

- Created User Repository
- Implemented User Service
- Implemented User Service Implementation
- Created LeaveRequest Entity
- Created LeaveRequest Repository
- Implemented LeaveRequest Service
- Implemented LeaveRequest Service Implementation
- Practiced CRUD operations using Spring Data JPA
- Implemented constructor-based dependency injection

### Concepts Learned

- JpaRepository
- Dependency Injection
- Constructor Injection
- CRUD Operations
- Optional
- Service Layer Design

---

## Day 4 — July 4, 2026

### Master Modules Development

Completed

#### Department Module

- Department Repository
- Department Service
- Department Service Implementation
- CRUD Operations

#### Role Module

- Role Repository
- Role Service
- Role Service Implementation
- CRUD Operations

#### LeaveType Module

- LeaveType Repository
- LeaveType Service
- LeaveType Service Implementation
- CRUD Operations

#### REST Controllers

Implemented REST Controllers for all modules:

- UserController
- DepartmentController
- RoleController
- LeaveTypeController
- LeaveRequestController

Implemented REST endpoints using:

- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `ResponseEntity`

#### API Testing

Successfully tested CRUD APIs using Postman.

Verified:

- POST
- GET
- PUT
- DELETE
- JSON Request/Response
- Database persistence

### Concepts Learned

- REST API Development
- REST Controllers
- ResponseEntity
- Path Variables
- Request Body Mapping
- CRUD APIs
- API Testing with Postman

---

## Day 5 — July 5, 2026

### Global Exception Handling

Completed

- Created custom exception classes
- Implemented Global Exception Handler using `@RestControllerAdvice`
- Added centralized exception handling
- Returned meaningful HTTP status codes
- Improved API error responses
- Eliminated duplicate exception handling from controllers

### Exception Handling Implemented

- Resource Not Found Exception
- Validation Exception Handling
- Generic Exception Handling

### Concepts Learned

- `@RestControllerAdvice`
- `@ExceptionHandler`
- Custom Exceptions
- Centralized Exception Handling
- HTTP Status Codes
- API Error Response Design

---

## Day 6 — July 6, 2026

### DTO Layer & Validation

Completed

#### DTO Implementation

Created Request and Response DTOs for all modules.

- UserRequestDto
- UserResponseDto
- DepartmentRequestDto
- DepartmentResponseDto
- RoleRequestDto
- RoleResponseDto
- LeaveTypeRequestDto
- LeaveTypeResponseDto
- LeaveRequestRequestDto
- LeaveRequestResponseDto

#### Service Refactoring

- Refactored all services to use DTOs instead of Entities.
- Implemented manual Entity ↔ DTO mapping.
- Updated CRUD operations to work with DTOs.

#### Controller Refactoring

Updated all REST Controllers to consume Request DTOs and return Response DTOs.

#### Request Validation

Implemented Bean Validation using:

- `@Valid`
- `@NotBlank`
- `@NotNull`
- `@Email`
- `@Size`
- `@Positive`
- `@PastOrPresent`

Added validation annotations to Request DTOs.

Validation errors are handled centrally using the Global Exception Handler.

#### API Testing

Successfully tested:

- Valid requests
- Invalid request validation
- DTO request/response mapping
- CRUD operations
- Validation error responses

### Git Workflow

```bash
git status
git add .
git commit -m "Implemented DTO layer and request validation"
git push origin <branch-name>
```

### Concepts Learned

- DTO Pattern
- Request DTO
- Response DTO
- Entity to DTO Mapping
- DTO to Entity Mapping
- Bean Validation
- Validation Annotations
- `@Valid`
- Clean Architecture
- Separation of Concerns

---

# Current Progress

## Completed

- Spring Boot Setup
- Maven Configuration
- MySQL Configuration
- Project Structure
- User Module
- Department Module
- Role Module
- LeaveType Module
- LeaveRequest Module
- Entity Layer
- Repository Layer
- Service Layer
- Controller Layer
- Global Exception Handling
- DTO Layer
- Request Validation
- CRUD APIs
- Postman API Testing

---

# Upcoming Tasks

- JWT Authentication
- Spring Security
- Swagger/OpenAPI Documentation
- Unit Testing (JUnit & Mockito)
- Logging (SLF4J / Logback)
- Pagination & Sorting
- Deployment

---

# Concepts Learned So Far

- Spring Boot Project Structure
- Maven Build Lifecycle
- Spring Data JPA
- Hibernate ORM
- Entity Mapping
- Repository Layer
- Service Layer
- Controller Layer
- REST API Development
- CRUD Operations
- Constructor-Based Dependency Injection
- JpaRepository
- Optional API
- JPA Relationships
- Enum Mapping
- ResponseEntity
- Path Variables
- Request Body Mapping
- DTO Pattern
- Entity ↔ DTO Mapping
- Bean Validation
- Validation Annotations
- Global Exception Handling
- `@RestControllerAdvice`
- `@ExceptionHandler`
- Custom Exceptions
- Clean Architecture
- Separation of Concerns
- Layered Architecture
- API Testing with Postman
- Git Version Control
- GitHub Workflow

---

# Project Status

**Current Phase:** DTO Layer, Validation & Global Exception Handling Completed

## Modules Completed

- User Module
- Department Module
- Role Module
- LeaveType Module
- LeaveRequest Module

## Layers Completed

- Entity Layer
- Repository Layer
- Service Layer
- Controller Layer
- DTO Layer
- Validation Layer
- Global Exception Handling

## Testing Status

- CRUD APIs Tested Successfully using Postman
- DTO Request/Response Verified
- Validation Tested
- Exception Responses Verified
- Database Operations Verified in MySQL

## Next Milestone

- Implement Spring Security
- Integrate JWT Authentication
- Generate Swagger/OpenAPI Documentation
- Write Unit Tests
- Add Logging
- Deploy the Application