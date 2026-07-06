package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.dto.DepartmentRequestDto;
import com.leaveflow.leaveflow.dto.DepartmentResponseDto;
import com.leaveflow.leaveflow.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> createDept(
            @Valid @RequestBody DepartmentRequestDto dto) {

        return new ResponseEntity<>(service.createDept(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {

        return ResponseEntity.ok(service.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getDeptById(@PathVariable int id) {

        return ResponseEntity.ok(service.getDeptById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(
            @PathVariable int id,
            @Valid @RequestBody DepartmentRequestDto dto) {

        return ResponseEntity.ok(service.updateDept(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable int id) {

        service.deleteDeptById(id);

        return ResponseEntity.ok("Department Deleted Successfully");
    }
}