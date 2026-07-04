package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(int id);
    Role createRole(Role role);
    void deleteRoleById(int id);
    Role updateRole(int id,Role role);
    List<Role> getAllRoles();
}
