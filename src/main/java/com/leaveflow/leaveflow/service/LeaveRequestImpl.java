package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.LeaveRequestDto;
import com.leaveflow.leaveflow.dto.LeaveResponseDto;
import com.leaveflow.leaveflow.enums.LeaveStatus;
import com.leaveflow.leaveflow.exception.ResourceNotFoundException;
import com.leaveflow.leaveflow.model.LeaveRequest;
import com.leaveflow.leaveflow.model.LeaveType;
import com.leaveflow.leaveflow.model.User;
import com.leaveflow.leaveflow.repository.LeaveRequestRepo;
import com.leaveflow.leaveflow.repository.LeaveTypeRepo;
import com.leaveflow.leaveflow.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestImpl implements LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepo;
    private final LeaveTypeRepo leaveTypeRepo;
    private final UserRepo userRepo;

    public LeaveRequestImpl(LeaveRequestRepo leaveRequestRepo,
                            LeaveTypeRepo leaveTypeRepo,
                            UserRepo userRepo) {
        this.leaveRequestRepo = leaveRequestRepo;
        this.leaveTypeRepo = leaveTypeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public LeaveResponseDto createLeaveRequest(LeaveRequestDto dto) {

        LeaveType leaveType = leaveTypeRepo.findById(dto.getLeaveTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Leave Type not found"));

        User employee = userRepo.findById(dto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        LeaveRequest leaveRequest = new LeaveRequest();

        leaveRequest.setStartDate(dto.getStartDate());
        leaveRequest.setEndDate(dto.getEndDate());
        leaveRequest.setTotalDays(dto.getTotalDays());
        leaveRequest.setReason(dto.getReason());

        leaveRequest.setLeaveType(leaveType);
        leaveRequest.setEmployee(employee);

        leaveRequest.setAppliedAt(LocalDateTime.now());
        leaveRequest.setLeaveStatus(LeaveStatus.PENDING);

        LeaveRequest saved = leaveRequestRepo.save(leaveRequest);

        return mapToResponseDto(saved);
    }

    @Override
    public LeaveResponseDto getLeaveRequestById(int id) {

        LeaveRequest leaveRequest = leaveRequestRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Request not found with ID " + id));

        return mapToResponseDto(leaveRequest);
    }

    @Override
    public List<LeaveResponseDto> getAllLeaveRequests() {

        return leaveRequestRepo.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveResponseDto updateLeaveRequest(int id, LeaveRequestDto dto) {

        LeaveRequest existing = leaveRequestRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Request not found with ID " + id));

        LeaveType leaveType = leaveTypeRepo.findById(dto.getLeaveTypeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Type not found"));

        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        existing.setTotalDays(dto.getTotalDays());
        existing.setReason(dto.getReason());
        existing.setLeaveType(leaveType);

        LeaveRequest updated = leaveRequestRepo.save(existing);

        return mapToResponseDto(updated);
    }

    @Override
    public void deleteLeaveRequest(int id) {

        LeaveRequest leaveRequest = leaveRequestRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Request not found with ID " + id));

        leaveRequestRepo.delete(leaveRequest);
    }

    @Override
    public LeaveResponseDto approveLeaveRequest(int leaveId, int approvedById) {

        LeaveRequest leaveRequest = leaveRequestRepo.findById(leaveId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Request not found"));

        User manager = userRepo.findById(approvedById)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approver not found"));

        leaveRequest.setLeaveStatus(LeaveStatus.APPROVED);
        leaveRequest.setApprovedAt(LocalDateTime.now());
        leaveRequest.setApprovedBy(manager);

        return mapToResponseDto(leaveRequestRepo.save(leaveRequest));
    }

    @Override
    public LeaveResponseDto rejectLeaveRequest(int leaveId, int approvedById) {

        LeaveRequest leaveRequest = leaveRequestRepo.findById(leaveId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Leave Request not found"));

        User manager = userRepo.findById(approvedById)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Approver not found"));

        leaveRequest.setLeaveStatus(LeaveStatus.REJECTED);
        leaveRequest.setApprovedAt(LocalDateTime.now());
        leaveRequest.setApprovedBy(manager);

        return mapToResponseDto(leaveRequestRepo.save(leaveRequest));
    }

    private LeaveResponseDto mapToResponseDto(LeaveRequest leaveRequest) {

        LeaveResponseDto dto = new LeaveResponseDto();

        dto.setLeaveId(leaveRequest.getLeaveId());
        dto.setStartDate(leaveRequest.getStartDate());
        dto.setEndDate(leaveRequest.getEndDate());
        dto.setTotalDays(leaveRequest.getTotalDays());
        dto.setReason(leaveRequest.getReason());
        dto.setAppliedAt(leaveRequest.getAppliedAt());
        dto.setApprovedAt(leaveRequest.getApprovedAt());
        dto.setLeaveStatus(leaveRequest.getLeaveStatus());

        dto.setLeaveTypeId(leaveRequest.getLeaveType().getLeaveTypeId());
        dto.setLeaveTypeName(leaveRequest.getLeaveType().getLeaveTypeName());

        dto.setEmployeeId(leaveRequest.getEmployee().getUserId());
        dto.setEmployeeName(
                leaveRequest.getEmployee().getFirstName() + " " + leaveRequest.getEmployee().getLastName());

        if (leaveRequest.getApprovedBy() != null) {
            dto.setApprovedById(leaveRequest.getApprovedBy().getUserId());
            dto.setApprovedByName(leaveRequest.getApprovedBy().getLastName());
        }

        return dto;
    }
}