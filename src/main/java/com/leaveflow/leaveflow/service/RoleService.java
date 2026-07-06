package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.RoleRequestDto;
import com.leaveflow.leaveflow.dto.RoleResponseDto;
import com.leaveflow.leaveflow.model.Role;

import java.util.List;

public interface RoleService {
    RoleResponseDto getRoleById(int id);
    RoleResponseDto createRole(RoleRequestDto roleRequestDto);
    void deleteRoleById(int id);
    RoleResponseDto updateRole(int id,RoleRequestDto roleRequestDto);
    List<RoleResponseDto> getAllRoles();
}
