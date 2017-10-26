package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.service.StaffService;

/**
 * Created by dllo on 2017/10/24.
 */
public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao;

    @Override
    public boolean login(String name, String password) {
        return staffDao.login(name, password);
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
