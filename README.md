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

Concepts Learned

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

Concepts Learned

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

* Created Repository
* Designed Service Interface
* Started Service Implementation

#### Git Workflow Practiced

```
git status
git add .
git commit -m "Implemented Department and Role services"
git push origin <branch-name>
```

Concepts Learned

* Constructor Injection
* `JpaRepository`
* `Optional`
* `orElseThrow()`
* Service Layer Architecture
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
* Users Module
* Department Module
* Role Module
* LeaveRequest Module
* Repository Layer
* Service Layer (Users)
* Service Layer (LeaveRequest)
* Service Layer (Department)
* Service Layer (Role)
* LeaveType Repository
* LeaveType Service Interface
* Complete LeaveType Service Implementation

---

# Upcoming Tasks

* Create LeaveType Controller
* Create User Controller
* Create Department Controller
* Create Role Controller
* Create LeaveRequest Controller
* Test APIs using Postman
* Global Exception Handling
* DTO Layer
* Validation
* JWT Authentication
* Spring Security
* Swagger/OpenAPI Documentation
* Unit Testing
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
* CRUD Operations
* Constructor-Based Dependency Injection
* `JpaRepository`
* `Optional` API
* `orElseThrow()` Exception Handling
* JPA Relationships (`@ManyToOne`, `@JoinColumn`)
* Enum Mapping with `@Enumerated`
* MySQL Database Design
* Primary Keys
* Foreign Keys
* Database Constraints (`NOT NULL`, `UNIQUE`, `AUTO_INCREMENT`)
* Layered Architecture (Controller → Service → Repository)
* Git Version Control
* GitHub Workflow (`status`, `add`, `commit`, `push`)

---

# Project Status

**Current Phase:** Backend Development

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

## Next Milestone

* Implement REST Controllers for all modules
* Test CRUD APIs using Postman
* Add Global Exception Handling
* Implement DTOs and Validation
* Integrate Spring Security with JWT Authentication
* Generate Swagger/OpenAPI Documentation
* Write Unit Tests
* Deploy the application
