package com.leaveflow.leaveflow.service;

import com.leaveflow.leaveflow.model.Department;


import java.util.List;


public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDeptById(int id);

    Department updateDept(int id, Department dept);

    void deleteDeptById(int id);

    Department createDept(Department dept);

}
