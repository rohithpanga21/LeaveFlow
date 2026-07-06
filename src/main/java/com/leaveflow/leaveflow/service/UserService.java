package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.UserRequestDto;
import com.leaveflow.leaveflow.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto saveUser(UserRequestDto dto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(int id);

    UserResponseDto updateUser(int id, UserRequestDto dto);

    void deleteUser(int id);
}