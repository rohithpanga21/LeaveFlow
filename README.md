# LeaveFlow - Leave Management System

## Project Overview

LeaveFlow is a Leave Management System developed using Spring Boot, Spring Data JPA, MySQL, and Maven.

The system automates employee leave management by allowing employees to apply for leave while managers approve or reject requests.

---

# Tech Stack

Backend
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- Maven

Database
- MySQL

IDE
- IntelliJ IDEA

Version Control
- Git
- GitHub

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

Packages

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

Tables created

1. users
2. department
3. roles
4. leave_types

Relationships

Department

```
Department
   |
   |
Many Users
```

Role

```
Role
   |
   |
Many Users
```

Manager

```
User
 |
 |
Many Employees
```

Each employee has one manager.

---

# Entity Implementation

## Users Entity

Implemented

- @Entity
- @Table
- @Id
- @GeneratedValue
- @Column
- @ManyToOne
- @JoinColumn
- @Enumerated

Fields

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

---

## Department Entity

Contains

- deptId
- deptName

Relationship

One department can have multiple users.

---

## Role Entity

Contains

- roleId
- roleName

Relationship

One role can be assigned to multiple users.

---

# Enums

Implemented

UserStatus

```
ACTIVE
INACTIVE
```

Hibernate stores these values as Strings using

```
@Enumerated(EnumType.STRING)
```

---

# JPA Relationships Learned

ManyToOne

Used in

- Department
- Role
- Manager

Example

```java
@ManyToOne
@JoinColumn(name="dept_id")
private Department department;
```

Meaning

Many users belong to one department.

---

# Database Constraints Used

Primary Key

```
PRIMARY KEY
```

Auto Increment

```
AUTO_INCREMENT
```

Foreign Key

```
FOREIGN KEY
```

Not Null

```
NOT NULL
```

Unique

```
UNIQUE
```

Enum

```
ENUM(...)
```

---

# Progress Completed

✔ Maven Project Setup

✔ Spring Boot Setup

✔ MySQL Connection

✔ Database Created

✔ Entity Package Created

✔ Repository Package Created

✔ Service Package Created

✔ Controller Package Created

✔ Enum Package Created

✔ Department Entity

✔ Role Entity

✔ Users Entity

✔ Relationships Implemented

---

# Next Steps

- Create LeaveType Entity
- Create LeaveRequest Entity
- Create LeaveBalance Entity
- Create Approval Entity
- Create Notification Entity

After Entities

- Repository Layer
- Service Layer
- REST Controllers
- Exception Handling
- JWT Authentication
- Spring Security
- Testing
- Deployment

---

# Concepts Learned

- Spring Boot Project Structure
- Maven
- JPA
- Hibernate
- Entity Mapping
- Primary Keys
- Foreign Keys
- ManyToOne Mapping
- JoinColumn
- Enumerations
- Auto Increment
- MySQL Table Design