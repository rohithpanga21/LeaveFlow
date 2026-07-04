package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.Department;
import com.leaveflow.leaveflow.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo){
        this.departmentRepo=departmentRepo;
    }
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDeptById(int id) {
        return departmentRepo.findById(id).orElseThrow(()->new RuntimeException("Department not found"));
    }

    @Override
    public Department updateDept(Department dept) {
        Department existingDept=departmentRepo.findById(dept.getDeptId()).orElse(null);
        if(existingDept != null){
            existingDept.setDeptName(dept.getDeptName());
            return departmentRepo.save(existingDept);
        }
        else {
            throw new RuntimeException("Department not found");
        }
    }

    @Override
    public void deleteDeptById(int id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public Department createDept(Department dept) {
        return departmentRepo.save(dept);
    }
}
