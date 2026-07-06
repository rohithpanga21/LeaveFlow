package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.UserRequestDto;
import com.leaveflow.leaveflow.dto.UserResponseDto;
import com.leaveflow.leaveflow.enums.UserStatus;
import com.leaveflow.leaveflow.exception.ResourceNotFoundException;
import com.leaveflow.leaveflow.model.Department;
import com.leaveflow.leaveflow.model.Role;
import com.leaveflow.leaveflow.model.User;
import com.leaveflow.leaveflow.repository.DepartmentRepo;
import com.leaveflow.leaveflow.repository.RoleRepo;
import com.leaveflow.leaveflow.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final RoleRepo roleRepo;

    public UserServiceImpl(UserRepo userRepo,
                           DepartmentRepo departmentRepo,
                           RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.departmentRepo = departmentRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto dto) {

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNo(dto.getPhoneNo());
        user.setJoiningDate(dto.getJoiningDate());
        user.setStatus(UserStatus.ACTIVE);

        Department department = departmentRepo.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found"));

        Role role = roleRepo.findById(dto.getRoleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role Not Found"));

        user.setDepartment(department);
        user.setRole(role);

        if (dto.getManagerId() != null) {
            User manager = userRepo.findById(dto.getManagerId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Manager Not Found"));

            user.setManager(manager);
        }

        User savedUser = userRepo.save(user);

        return convertToResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {

        List<User> users = userRepo.findAll();

        List<UserResponseDto> response = new ArrayList<>();

        for (User user : users) {
            response.add(convertToResponseDto(user));
        }

        return response;
    }

    @Override
    public UserResponseDto getUserById(int id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found with ID " + id));

        return convertToResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(int id, UserRequestDto dto) {

        User existingUser = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found with ID " + id));

        existingUser.setFirstName(dto.getFirstName());
        existingUser.setLastName(dto.getLastName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPassword(dto.getPassword());
        existingUser.setPhoneNo(dto.getPhoneNo());
        existingUser.setJoiningDate(dto.getJoiningDate());

        Department department = departmentRepo.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found"));

        Role role = roleRepo.findById(dto.getRoleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role Not Found"));

        existingUser.setDepartment(department);
        existingUser.setRole(role);

        if (dto.getManagerId() != null) {

            User manager = userRepo.findById(dto.getManagerId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Manager Not Found"));

            existingUser.setManager(manager);

        } else {

            existingUser.setManager(null);
        }

        User updatedUser = userRepo.save(existingUser);

        return convertToResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found with ID " + id));

        userRepo.delete(user);
    }

    private UserResponseDto convertToResponseDto(User user) {

        UserResponseDto dto = new UserResponseDto();

        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNo(user.getPhoneNo());
        dto.setJoiningDate(user.getJoiningDate());
        dto.setLeaveBalance(user.getLeaveBalance());
        dto.setStatus(user.getStatus());

        if (user.getDepartment() != null) {
            dto.setDepartmentId(user.getDepartment().getDeptId());
            dto.setDepartmentName(user.getDepartment().getDeptName());
        }

        if (user.getRole() != null) {
            dto.setRoleId(user.getRole().getRoleId());
            dto.setRoleName(user.getRole().getRoleName());
        }

        if (user.getManager() != null) {
            dto.setManagerId(user.getManager().getUserId());
            dto.setManagerName(
                    user.getManager().getFirstName() + " " +
                            user.getManager().getLastName());
        }

        return dto;
    }
}