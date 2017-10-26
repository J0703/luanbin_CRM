package com.lanou.domain;

import java.sql.Timestamp;

/**
 * Created by dllo on 2017/10/20.
 */
public class Staff {
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Timestamp onDutyDate;
    private Department department;//所属部门
    private Post Post;//所属职务

    public Staff() {
    }

    public Staff(String staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }

    public Staff(String staffName) {
        this.staffName = staffName;
    }

    public Staff(String staffId, String staffName, Department department, Post Post) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.department = department;
        this.Post = Post;
    }

    public Staff(String staffId, String loginName, String loginPwd, String staffName, String gender, Timestamp onDutyDate, Department department, Post Post) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.department = department;
        this.Post = Post;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate='" + onDutyDate + '\'' +
                ", department=" + department +
                ", Post=" + Post +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Post getPost() {
        return Post;
    }

    public void setPost(Post Post) {
        this.Post = Post;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Timestamp onDutyDate) {
        this.onDutyDate = onDutyDate;
    }
}
