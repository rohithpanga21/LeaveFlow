package com.leaveflow.leaveflow.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class LeaveTypeRequestDto {

    @Min(value = 1, message = "Leave Type Id must be greater than 0")
    private int leaveTypeId;

    @NotBlank(message = "Leave Type name is required")
    private String leaveTypeName;

    @Min(value = 1, message = "Maximum days must be at least 1")
    private int maxDays;

    public LeaveTypeRequestDto() {
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}