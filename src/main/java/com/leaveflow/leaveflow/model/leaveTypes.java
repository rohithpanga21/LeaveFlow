package com.leaveflow.leaveflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leavetypes")
public class leaveTypes {
    @Id
    @Column(name = "leave_type_id")
    private int leaveId;

    @Column(name = "leave_name")
    private String leaveName;

    @Column(name = "max_days")
    private int maxDays;

    public leaveTypes(){//Empty constructor to create a obj using hibernate and spring Jpa

    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
