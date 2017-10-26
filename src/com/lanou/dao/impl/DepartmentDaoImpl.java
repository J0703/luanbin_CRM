package com.lanou.dao.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.Department;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/25.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
    @Override
    public void addDepartment(Department department) {
       save(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        String hql  = "from Department";
        return findAll(hql);
    }

    @Override
    public void updateDepartment(Department department) {
        update(department);
    }

//    @Override
//    public Department findDepartmentByName(Department department) {
//        Object[] params={department.getDepName()};
//        List<Department> departments = find("from Department where depName=?", params);
//        return departments.get(0);
//
//    }

    @Override
    public Department findById(String department_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",department_id);
        return findSingle("from Department where depId=:id", map);
    }
}
