package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.LeaveType;
import com.leaveflow.leaveflow.repository.LeaveTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeImpl implements LeaveTypeService {

    private final LeaveTypeRepo leaveTypeRepo;
    public LeaveTypeImpl(LeaveTypeRepo leaveTypeRepo){
        this.leaveTypeRepo=leaveTypeRepo;
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepo.findAll();
    }

    @Override
    public LeaveType getLeaveTypeById(int id) {
        return leaveTypeRepo.findById(id).orElseThrow(()->new RuntimeException("Leave Type not Found"));
    }

    @Override
    public LeaveType createLeaveType(LeaveType leaveType) {
        return leaveTypeRepo.save(leaveType);
    }

    @Override
    public LeaveType updateLeaveType(int id, LeaveType leaveType) {
        LeaveType exisitngLeaveType = leaveTypeRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Leave Type not Found"));

        exisitngLeaveType.setLeaveName(leaveType.getLeaveName());
        exisitngLeaveType.setMaxDays(leaveType.getMaxDays());
        return leaveTypeRepo.save(exisitngLeaveType);
    }

    @Override
    public void deleteLeaveTypeById(int id) {
        leaveTypeRepo.deleteById(id);
    }
}
