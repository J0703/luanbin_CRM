package com.lanou.cc.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 2017/10/27.
 */
public class CourseType {
    private String courseTypeId;
    private Double courseCost;
    private Integer total;
    private String courseName;
    private String remark;

    private String totalStart;
    private String totalEnd;

    private String courseCostStart;
    private String courseCostEnd;

    private Set<Classes> classesSet = new HashSet<>();
    public CourseType() {
    }

    public CourseType(Double courseCost, Integer total, String courseName, String remark) {
        this.courseCost = courseCost;
        this.total = total;
        this.courseName = courseName;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseCost=" + courseCost +
                ", total=" + total +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                ", totalStart='" + totalStart + '\'' +
                ", totalEnd='" + totalEnd + '\'' +
                ", courseCostStart='" + courseCostStart + '\'' +
                ", courseCostEnd='" + courseCostEnd + '\'' +
                '}';
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Classes> getClassesSet() {
        return classesSet;
    }

    public void setClassesSet(Set<Classes> classesSet) {
        this.classesSet = classesSet;
    }

    public String getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }

    public String getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    public String getCourseCostStart() {
        return courseCostStart;
    }

    public void setCourseCostStart(String courseCostStart) {
        this.courseCostStart = courseCostStart;
    }

    public String getCourseCostEnd() {
        return courseCostEnd;
    }

    public void setCourseCostEnd(String courseCostEnd) {
        this.courseCostEnd = courseCostEnd;
    }
}
