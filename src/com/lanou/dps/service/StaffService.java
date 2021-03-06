package com.lanou.dps.service;

import com.lanou.dps.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
public interface StaffService {
    Staff login(String name, String password);
    

    List<Staff> findAll();

    void addStaff(Staff staff);

    Staff findByStaffId(String staffId);

    void editStaff(Staff staff);

    List<Staff> findStaffByPostId(String postId);

    List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName);


    List<Staff> findStaffByStaffName(String staffName);
}
