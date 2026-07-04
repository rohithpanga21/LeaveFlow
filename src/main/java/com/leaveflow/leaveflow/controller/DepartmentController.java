package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.model.Department;
import com.leaveflow.leaveflow.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;
    public DepartmentController(DepartmentService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<Department>>getAllDepartments(){
        return ResponseEntity.ok(service.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDeptById(@PathVariable int id){
        return ResponseEntity.ok(service.getDeptById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department department){
        return ResponseEntity.ok(service.updateDept(id,department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable int id){
        service.deleteDeptById(id);
        return ResponseEntity.ok("Department Deleted Successfully");
    }

    @PostMapping
    public ResponseEntity<String> createDept(@RequestBody Department department){
        service.createDept(department);
        return ResponseEntity.ok("New Department Added Successfully");
    }

}
