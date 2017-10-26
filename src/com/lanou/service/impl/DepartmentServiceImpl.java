package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.dao.impl.DepartmentDaoImpl;
import com.lanou.domain.Department;
import com.lanou.service.DepartmentService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentDao departmentDao;
    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAllDepartment();
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

//    @Override
//    public Department findDepartmentByName(Department department) {
//        return departmentDao.findDepartmentByName(department);
//    }

    @Override
    public Department findById(String department_id) {
        System.out.println(department_id);
        return departmentDao.findById(department_id);
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
