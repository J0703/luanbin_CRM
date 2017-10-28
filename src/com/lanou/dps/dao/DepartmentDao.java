package com.lanou.dps.dao;

import com.lanou.cc.domain.CourseType;
import com.lanou.dps.domain.Department;

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


    int getTotalRecord();

    List<CourseType> find1(int startIndex, int pageSize);
}
