package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    List<LeaveType> getAllLeaveTypes();

    LeaveType getLeaveTypeById(int id);

    LeaveType createLeaveType(LeaveType leaveType);

    LeaveType updateLeaveType(int id, LeaveType leaveType);

    void deleteLeaveTypeById(int id);
}
