package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.DepartmentRequestDto;
import com.leaveflow.leaveflow.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto getDeptById(int id);

    DepartmentResponseDto createDept(DepartmentRequestDto dto);

    DepartmentResponseDto updateDept(int id, DepartmentRequestDto dto);

    void deleteDeptById(int id);
}