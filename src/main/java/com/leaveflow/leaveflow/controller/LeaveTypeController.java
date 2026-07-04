package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.model.LeaveType;
import com.leaveflow.leaveflow.service.LeaveTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {

    private final LeaveTypeService service;
    public LeaveTypeController(LeaveTypeService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<LeaveType>> getAllLeaveTypes(){
        return ResponseEntity.ok(service.getAllLeaveTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable int id){
        return ResponseEntity.ok(service.getLeaveTypeById(id));
    }

    @PostMapping
    public ResponseEntity<LeaveType> createLeaveType(@RequestBody LeaveType leaveType) {
        return ResponseEntity.ok(service.createLeaveType(leaveType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveType> updateLeaveType(@PathVariable int id, @RequestBody LeaveType leaveType) {
        return ResponseEntity.ok(service.updateLeaveType(id, leaveType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveType(@PathVariable int id) {
        service.deleteLeaveTypeById(id);
        return ResponseEntity.ok("Leave Type Deleted Successfully");
    }

}
