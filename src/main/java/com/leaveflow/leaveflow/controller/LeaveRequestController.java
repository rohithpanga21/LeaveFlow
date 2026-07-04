package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.model.LeaveRequest;
import com.leaveflow.leaveflow.service.LeaveRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/leaveRequests")
public class LeaveRequestController {

    private final LeaveRequestService service;
    public LeaveRequestController(LeaveRequestService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<LeaveRequest> saveLeaveRequest(@RequestBody LeaveRequest leaveRequest){
        LeaveRequest saved = service.saveLeaveRequest(leaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveReqById(@PathVariable int id){
        return ResponseEntity.ok(service.getLeaveRequestById(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests(){
        return ResponseEntity.ok(service.getAllLeaveRequest());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable int id, @RequestBody LeaveRequest leaveRequest) {
        return ResponseEntity.ok(service.updateLeaveRequest(id, leaveRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveRequest(@PathVariable int id){
        service.deleteLeaveRequest(id);
        return ResponseEntity.ok("Leave Request Deleted Successfully");
    }
}
