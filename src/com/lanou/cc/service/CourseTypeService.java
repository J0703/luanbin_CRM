package com.lanou.cc.service;

import com.lanou.cc.domain.CourseType;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public interface CourseTypeService {
    List<CourseType> find(CourseType courseType);

    CourseType findById(String courseTypeId);

    void saveCourse(CourseType courseType);

    void updateCourse(CourseType courseType);

    List<CourseType> findAll();


    PageBean<CourseType> findAll(CourseType crmCourseType, int pageNum, int pageSize);
}
