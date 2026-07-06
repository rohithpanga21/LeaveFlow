package com.leaveflow.leaveflow.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RoleRequestDto {

    @NotNull(message = "Role ID is required")
    @Min(value = 1, message = "value should be greater than 0 ")
    private int roleId;

    @NotBlank(message = "Role Name is required")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
    private String roleName;

    public RoleRequestDto(){

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
