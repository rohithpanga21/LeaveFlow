package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.dto.LeaveTypeRequestDto;
import com.leaveflow.leaveflow.dto.LeaveTypeResponseDto;
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
    public ResponseEntity<List<LeaveTypeResponseDto>> getAllLeaveTypes(){
        return ResponseEntity.ok(service.getAllLeaveTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveTypeResponseDto> getLeaveTypeById(@PathVariable int id){
        return ResponseEntity.ok(service.getLeaveTypeById(id));
    }

    @PostMapping
    public ResponseEntity<LeaveTypeResponseDto> createLeaveType(@RequestBody LeaveTypeRequestDto leaveTypeRequestDto) {
        return ResponseEntity.ok(service.createLeaveType(leaveTypeRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveTypeResponseDto> updateLeaveType(@PathVariable int id, @RequestBody LeaveTypeRequestDto leaveTypeRequestDto) {
        return ResponseEntity.ok(service.updateLeaveType(id, leaveTypeRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveType(@PathVariable int id) {
        service.deleteLeaveTypeById(id);
        return ResponseEntity.ok("Leave Type Deleted Successfully");
    }

}
