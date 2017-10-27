package com.lanou.service;

import com.lanou.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
public interface StaffService {
    boolean login(String name, String password);

    List<Staff> findStaff(String department, String post);

    List<Staff> findAll();

    void addStaff(Staff staff);

    Staff findByStaffId(String staffId);
}
