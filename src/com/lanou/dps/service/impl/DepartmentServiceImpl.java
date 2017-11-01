package com.lanou.dps.service.impl;

import com.lanou.dps.dao.DepartmentDao;
import com.lanou.dps.domain.Department;
import com.lanou.dps.service.DepartmentService;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public class DepartmentServiceImpl implements DepartmentService {

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

    @Override
    public PageBean<Department> findAllDepartmentP(Department department, int pageNum, int pageSize) {
        int totalRecord = departmentDao.getTotalRecord();
        PageBean<Department> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Department> data = departmentDao.find1(pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
