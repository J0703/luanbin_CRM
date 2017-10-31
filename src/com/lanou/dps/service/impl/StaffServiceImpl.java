package com.lanou.dps.service.impl;

import com.lanou.dps.dao.StaffDao;
import com.lanou.dps.domain.Staff;
import com.lanou.dps.service.StaffService;

import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    @Override
    public Staff login(String name, String password) {
        return staffDao.login(name, password);
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

    @Override
    public void editStaff(Staff staff) {
        staffDao.editStaff(staff);
    }

    @Override
    public List<Staff> findStaffByPostId(String postId) {
        return staffDao.findStaffByPostId(postId);
    }

    @Override
    public List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName) {
        return staffDao.findStaffByPostIdAndStaffName(postId,staffName);
    }


    @Override
    public List<Staff> findStaffByStaffName(String staffName) {
        return staffDao.findStaffByStaffName(staffName);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
