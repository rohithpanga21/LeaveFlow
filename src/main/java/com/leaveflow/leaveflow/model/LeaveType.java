package com.leaveflow.leaveflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavetypes")
public class LeaveType {
    @Id
    @Column(name = "leave_type_id")
    private int leaveTypeId;

    @Column(name = "leave_name")
    private String leaveTypeName;

    @Column(name = "max_days")
    private int maxDays;

    public LeaveType(){//Empty constructor to create a obj using hibernate and spring Jpa

    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveId) {
        this.leaveTypeId = leaveId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveName) {
        this.leaveTypeName = leaveName;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
