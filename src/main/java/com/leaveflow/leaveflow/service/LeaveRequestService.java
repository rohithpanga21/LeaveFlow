package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.LeaveRequestDto;
import com.leaveflow.leaveflow.dto.LeaveResponseDto;

import java.util.List;

public interface LeaveRequestService {

    LeaveResponseDto createLeaveRequest(LeaveRequestDto dto);

    LeaveResponseDto getLeaveRequestById(int id);

    List<LeaveResponseDto> getAllLeaveRequests();

    LeaveResponseDto updateLeaveRequest(int id, LeaveRequestDto dto);

    void deleteLeaveRequest(int id);

    LeaveResponseDto approveLeaveRequest(int leaveId, int approvedById);

    LeaveResponseDto rejectLeaveRequest(int leaveId, int approvedById);
}