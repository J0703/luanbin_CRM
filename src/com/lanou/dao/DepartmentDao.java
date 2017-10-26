package com.lanou.dao;

import com.lanou.domain.Department;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public interface DepartmentDao extends BaseDao<Department>{
     void addDepartment(Department department);

     List<Department> findAllDepartment();

     void updateDepartment(Department department);

//     Department findDepartmentByName(Department department);

    Department findById(String department_id);
}
