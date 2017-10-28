package com.lanou.dps.service;

import com.lanou.cc.domain.CourseType;
import com.lanou.dps.domain.Department;
import com.lanou.dps.util.PageBean;

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

    PageBean<CourseType> findAllDepartmentP(Department department, int pageNum, int pageSize);
}
