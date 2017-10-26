package com.lanou.service;

import com.lanou.domain.Department;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public interface DepartmentService {
    void addDepartment(Department department);

    List<Department> findAllDepartment();

    void updateDepartment(Department department);

//    Department findDepartmentByName(Department department);

    Department findById(String department_id);
}
