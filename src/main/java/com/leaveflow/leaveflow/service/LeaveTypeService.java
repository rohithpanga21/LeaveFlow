package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.LeaveTypeRequestDto;
import com.leaveflow.leaveflow.dto.LeaveTypeResponseDto;
import com.leaveflow.leaveflow.model.LeaveType;

import java.util.List;

public interface LeaveTypeService {
    List<LeaveTypeResponseDto> getAllLeaveTypes();

    LeaveTypeResponseDto getLeaveTypeById(int id);

    LeaveTypeResponseDto createLeaveType(LeaveTypeRequestDto leaveTypeRequestDto);

    LeaveTypeResponseDto updateLeaveType(int id, LeaveTypeRequestDto leaveTypeRequestDto);

    void deleteLeaveTypeById(int id);
}
