package com.leaveflow.leaveflow.controller;

import com.leaveflow.leaveflow.dto.LeaveRequestDto;
import com.leaveflow.leaveflow.dto.LeaveResponseDto;
import com.leaveflow.leaveflow.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveRequests")
public class LeaveRequestController {

    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeaveResponseDto> createLeaveRequest(
            @Valid @RequestBody LeaveRequestDto dto) {

        LeaveResponseDto saved = service.createLeaveRequest(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveResponseDto> getLeaveRequestById(
            @PathVariable int id) {

        return ResponseEntity.ok(service.getLeaveRequestById(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaveResponseDto>> getAllLeaveRequests() {

        return ResponseEntity.ok(service.getAllLeaveRequests());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveResponseDto> updateLeaveRequest(
            @PathVariable int id,
            @Valid @RequestBody LeaveRequestDto dto) {

        return ResponseEntity.ok(service.updateLeaveRequest(id, dto));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveResponseDto> approveLeaveRequest(
            @PathVariable int id,
            @RequestParam int approvedById) {

        return ResponseEntity.ok(
                service.approveLeaveRequest(id, approvedById));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveResponseDto> rejectLeaveRequest(
            @PathVariable int id,
            @RequestParam int approvedById) {

        return ResponseEntity.ok(
                service.rejectLeaveRequest(id, approvedById));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveRequest(@PathVariable int id) {

        service.deleteLeaveRequest(id);

        return ResponseEntity.ok("Leave Request Deleted Successfully");
    }
}