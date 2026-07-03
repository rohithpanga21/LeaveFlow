package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest);
    LeaveRequest getLeaveRequestById(int id);
    List<LeaveRequest> getAllLeaveRequest();
    LeaveRequest updateLeaveRequest(int id,LeaveRequest leaveRequest);
    void deleteLeaveRequest(int id);
}
