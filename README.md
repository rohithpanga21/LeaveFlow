# LeaveFlow - Leave Management System

## Project Overview

LeaveFlow is a Leave Management System developed using Spring Boot, Spring Data JPA (Hibernate), MySQL, and Maven.

The system automates employee leave management by allowing employees to apply for leave while managers review, approve, or reject leave requests.

---

# Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* Maven

## Database

* MySQL

## IDE

* IntelliJ IDEA

## Version Control

* Git
* GitHub

---

# Project Architecture

```
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

```
com.leaveflow.leaveflow

├── controller
├── service
├── repository
├── model
├── enums
├── dto
├── exception
├── config
└── LeaveflowApplication
```

---

# Database Design

## Tables

* users
* departments
* roles
* leave_types
* leave_requests

## Relationships

### Department

```
Department
     │
     │
Many Users
```

### Role

```
Role
    │
    │
Many Users
```

### Manager

```
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

* userId
* firstName
* lastName
* email
* password
* phoneNo
* joiningDate
* leaveBalance
* status
* department
* role
* manager

### Relationships

* ManyToOne → Department
* ManyToOne → Role
* ManyToOne → Manager (Self Reference)

---

## Department

### Fields

* deptId
* deptName

Relationship

One department can contain multiple users.

---

## Role

### Fields

* roleId
* roleName

Relationship

One role can be assigned to multiple users.

---

## LeaveType

### Fields

* leaveTypeId
* leaveTypeName
* maxLeaves
* description

Relationship

Referenced by Leave Requests.

---

## LeaveRequest

### Fields

* leaveId
* startDate
* endDate
* reason
* appliedDate
* leaveStatus
* approvedBy
* user
* leaveType

---

# Enums

## UserStatus

```
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

* Department
* Role
* Manager
* LeaveType
* User

Example

```java
@ManyToOne
@JoinColumn(name = "dept_id")
private Department department;
```

---

# Database Constraints

* PRIMARY KEY
* AUTO_INCREMENT
* FOREIGN KEY
* NOT NULL
* UNIQUE
* ENUM

---

# Development Progress

## Day 1 — July 1, 2026

### Project Initialization

Completed

* Created Spring Boot project
* Configured Maven
* Connected MySQL database
* Configured application.properties
* Created project package structure
* Created Entity package
* Created Repository package
* Created Service package
* Created Controller package
* Created Enum package
* Learned Spring Boot layered architecture

---

## Day 2 — July 2, 2026

### Database & Entity Development

Completed

* Designed database schema
* Created Users entity
* Created Department entity
* Created Role entity
* Implemented JPA annotations
* Implemented entity relationships
* Added UserStatus enum
* Generated database tables using Hibernate
* Verified table creation in MySQL

### Concepts Learned

* Entity Mapping
* Hibernate
* JPA
* ManyToOne Mapping
* JoinColumn
* Enum Mapping
* Auto Increment
* Foreign Keys

---

## Day 3 — July 3, 2026

### Repository & Service Development

Completed

* Created User Repository
* Implemented User Service
* Implemented User Service Implementation
* Created LeaveRequest Entity
* Created LeaveRequest Repository
* Implemented LeaveRequest Service
* Implemented LeaveRequest Service Implementation
* Practiced CRUD operations using Spring Data JPA
* Implemented constructor-based dependency injection

### Concepts Learned

* JpaRepository
* Dependency Injection
* Constructor Injection
* CRUD Operations
* Optional
* Service Layer Design

---

## Day 4 — July 4, 2026

### Master Modules Development

Completed

#### Department Module

* Department Repository
* Department Service
* Department Service Implementation
* CRUD operations
* Exception handling using `orElseThrow()`

#### Role Module

* Role Repository
* Role Service
* Role Service Implementation
* CRUD operations

#### LeaveType Module

* LeaveType Repository
* LeaveType Service
* LeaveType Service Implementation
* CRUD operations

#### REST Controllers

Implemented REST Controllers for all modules:

* UserController
* DepartmentController
* RoleController
* LeaveTypeController
* LeaveRequestController

Implemented REST endpoints using:

* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `ResponseEntity`

#### API Testing

Successfully tested CRUD APIs using Postman.

Verified:

* Create operations (POST)
* Retrieve operations (GET)
* Update operations (PUT)
* Delete operations (DELETE)
* Request parameter handling
* Path variable handling
* JSON request and response bodies
* Database persistence with MySQL

#### Git Workflow Practiced

```bash
git status
git add .
git commit -m "Implemented REST Controllers and tested APIs"
git push origin <branch-name>
```

### Concepts Learned

* REST API Development
* REST Controllers
* Request Mapping
* HTTP Methods (GET, POST, PUT, DELETE)
* ResponseEntity
* Path Variables
* Request Body Mapping
* Constructor Injection
* JpaRepository
* Optional
* orElseThrow()
* Service Layer Architecture
* API Testing with Postman
* Git Staging
* Git Commits
* GitHub Push Workflow

---

# Current Progress

## Completed

* Spring Boot Setup
* Maven Configuration
* MySQL Configuration
* Project Structure
* User Module
* Department Module
* Role Module
* LeaveType Module
* LeaveRequest Module
* Entity Layer
* Repository Layer
* Service Layer
* REST Controller Layer
* CRUD APIs
* Postman API Testing

---

# Upcoming Tasks

* Global Exception Handling
* DTO Layer
* Request Validation
* JWT Authentication
* Spring Security
* Swagger/OpenAPI Documentation
* Unit Testing
* Logging
* Deployment

---

# Concepts Learned So Far

* Spring Boot Project Structure
* Maven Build Lifecycle
* Spring Data JPA
* Hibernate ORM
* Entity Mapping
* Repository Layer
* Service Layer
* Controller Layer
* REST API Development
* CRUD Operations
* Constructor-Based Dependency Injection
* `JpaRepository`
* `Optional` API
* `orElseThrow()` Exception Handling
* JPA Relationships (`@ManyToOne`, `@JoinColumn`)
* Enum Mapping with `@Enumerated`
* HTTP Methods (`GET`, `POST`, `PUT`, `DELETE`)
* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `ResponseEntity`
* Request Body Mapping
* Path Variables
* MySQL Database Design
* Primary Keys
* Foreign Keys
* Database Constraints (`NOT NULL`, `UNIQUE`, `AUTO_INCREMENT`)
* Layered Architecture (Controller → Service → Repository)
* API Testing with Postman
* Git Version Control
* GitHub Workflow (`status`, `add`, `commit`, `push`)

---

# Project Status

**Current Phase:** REST API Development Completed

## Modules Completed

* User Module
* Department Module
* Role Module
* LeaveType Module
* LeaveRequest Module

## Layers Completed

* Entity Layer
* Repository Layer
* Service Layer
* Controller Layer

## Testing Status

* CRUD APIs Tested Successfully using Postman
* Database Operations Verified in MySQL

## Next Milestone

* Implement Global Exception Handling
* Add DTOs and Validation
* Integrate Spring Security with JWT Authentication
* Generate Swagger/OpenAPI Documentation
* Write Unit Tests
* Deploy the application
