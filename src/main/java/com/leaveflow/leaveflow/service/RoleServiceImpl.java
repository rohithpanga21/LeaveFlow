package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.RoleRequestDto;
import com.leaveflow.leaveflow.dto.RoleResponseDto;
import com.leaveflow.leaveflow.exception.ResourceNotFoundException;
import com.leaveflow.leaveflow.model.Role;
import com.leaveflow.leaveflow.repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {

        Role role = new Role();

        role.setRoleId(roleRequestDto.getRoleId());
        role.setRoleName(roleRequestDto.getRoleName());

        Role savedRole = roleRepo.save(role);

        return convertToResponseDto(savedRole);
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {

        List<Role> roles = roleRepo.findAll();

        List<RoleResponseDto> response = new ArrayList<>();

        for (Role role : roles) {
            response.add(convertToResponseDto(role));
        }

        return response;
    }

    @Override
    public RoleResponseDto getRoleById(int id) {

        Role role = roleRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role Not Found with ID " + id));

        return convertToResponseDto(role);
    }

    @Override
    public RoleResponseDto updateRole(int id, RoleRequestDto roleRequestDto) {

        Role existingRole = roleRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role Not Found with ID " + id));

        existingRole.setRoleName(roleRequestDto.getRoleName());

        Role updatedRole = roleRepo.save(existingRole);

        return convertToResponseDto(updatedRole);
    }

    @Override
    public void deleteRoleById(int id) {

        Role role = roleRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role Not Found with ID " + id));

        roleRepo.delete(role);
    }

    private RoleResponseDto convertToResponseDto(Role role) {

        RoleResponseDto dto = new RoleResponseDto();

        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());

        return dto;
    }
}