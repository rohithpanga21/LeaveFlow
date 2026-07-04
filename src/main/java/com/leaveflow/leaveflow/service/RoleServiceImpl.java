package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.Role;
import com.leaveflow.leaveflow.repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    public RoleServiceImpl(RoleRepo roleRepo){
        this.roleRepo=roleRepo;
    }
    @Override
    public Role getRoleById(int id) {
        return roleRepo.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
    }

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void deleteRoleById(int id) {
        roleRepo.deleteById(id);
    }

    @Override
    public Role updateRole(int id,Role role) {
        Role existingRole = roleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        existingRole.setRoleName(role.getRoleName());

        return roleRepo.save(existingRole);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}
