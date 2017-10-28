package com.lanou.cc.dao;

import com.lanou.cc.domain.CourseType;

import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public interface CourseTypeDao {

    List<CourseType> findAll();

    List<CourseType> find(String condition, Object[] params);

    CourseType findById(String courseTypeId);

    void saveCourse(CourseType courseType);

    void update(CourseType courseType);

    int getTotalRecord(String condition, Object[] params);

    List<CourseType> find1(String condition, Object[] params, int startIndex, int pageSize);
}
