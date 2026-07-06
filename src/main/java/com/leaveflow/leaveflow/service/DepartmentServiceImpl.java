package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.dto.DepartmentRequestDto;
import com.leaveflow.leaveflow.dto.DepartmentResponseDto;
import com.leaveflow.leaveflow.exception.ResourceNotFoundException;
import com.leaveflow.leaveflow.model.Department;
import com.leaveflow.leaveflow.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {

        List<Department> departments = departmentRepo.findAll();

        List<DepartmentResponseDto> response = new ArrayList<>();

        for (Department department : departments) {
            response.add(convertToResponseDto(department));
        }

        return response;
    }

    @Override
    public DepartmentResponseDto getDeptById(int id) {

        Department department = departmentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found with ID " + id));

        return convertToResponseDto(department);
    }

    @Override
    public DepartmentResponseDto createDept(DepartmentRequestDto dto) {

        Department department = new Department();

        department.setDeptId(dto.getDeptId());
        department.setDeptName(dto.getDeptName());

        Department savedDepartment = departmentRepo.save(department);

        return convertToResponseDto(savedDepartment);
    }

    @Override
    public DepartmentResponseDto updateDept(int id, DepartmentRequestDto dto) {

        Department existingDepartment = departmentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found with ID " + id));

        existingDepartment.setDeptName(dto.getDeptName());

        Department updatedDepartment = departmentRepo.save(existingDepartment);

        return convertToResponseDto(updatedDepartment);
    }

    @Override
    public void deleteDeptById(int id) {

        Department department = departmentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found with ID " + id));

        departmentRepo.delete(department);
    }

    private DepartmentResponseDto convertToResponseDto(Department department) {

        DepartmentResponseDto dto = new DepartmentResponseDto();

        dto.setDeptId(department.getDeptId());
        dto.setDeptName(department.getDeptName());

        return dto;
    }
}