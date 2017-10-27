package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;
import com.lanou.service.StaffService;

import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    @Override
    public boolean login(String name, String password) {
        return staffDao.login(name, password);
    }

    @Override
    public List<Staff> findStaff(String department, String post) {
        return staffDao.findStaff(department,post);
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public void addStaff(Staff staff) {
        staffDao.add(staff);
    }

    @Override
    public Staff findByStaffId(String staffId) {
        return staffDao.findByStaffId(staffId);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
