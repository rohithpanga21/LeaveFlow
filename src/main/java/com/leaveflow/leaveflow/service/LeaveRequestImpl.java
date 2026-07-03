package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.LeaveRequest;
import com.leaveflow.leaveflow.repository.LeaveRequestRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestImpl implements LeaveRequestService {

    private final LeaveRequestRepo leaveRequestRepo;
    public LeaveRequestImpl(LeaveRequestRepo leaveRequestRepo){
        this.leaveRequestRepo=leaveRequestRepo;
    }
    @Override
    public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepo.save(leaveRequest);
    }

    @Override
    public LeaveRequest getLeaveRequestById(int id) {
        return leaveRequestRepo.findById(id).orElse(null);
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequest() {
        return leaveRequestRepo.findAll();
    }

    @Override
    public LeaveRequest updateLeaveRequest(int id, LeaveRequest leaveRequest) {
        LeaveRequest existingLeaveRequest = leaveRequestRepo.findById(id).orElse(null);
        if(existingLeaveRequest != null){
            existingLeaveRequest.setLeaveType(leaveRequest.getLeaveType());
            existingLeaveRequest.setStartDate(leaveRequest.getStartDate());
            existingLeaveRequest.setEndDate(leaveRequest.getEndDate());
            existingLeaveRequest.setReason(leaveRequest.getReason());
            existingLeaveRequest.setLeaveStatus(leaveRequest.getLeaveStatus());
            existingLeaveRequest.setAppliedAt(leaveRequest.getAppliedAt());
            existingLeaveRequest.setApprovedBy(leaveRequest.getApprovedBy());
            return leaveRequestRepo.save(existingLeaveRequest);
        }
        else{
            throw new RuntimeException("Leave Request Not found");
        }
    }

    @Override
    public void deleteLeaveRequest(int id) {
        leaveRequestRepo.deleteById(id);
    }
}
