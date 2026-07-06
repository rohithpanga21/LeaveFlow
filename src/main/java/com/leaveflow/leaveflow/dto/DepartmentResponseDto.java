package com.leaveflow.leaveflow.dto;

public class DepartmentResponseDto {

    private Integer deptId;
    private String deptName;

    public DepartmentResponseDto() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}