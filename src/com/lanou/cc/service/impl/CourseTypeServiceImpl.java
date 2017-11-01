package com.lanou.cc.service.impl;

import com.lanou.cc.dao.CourseTypeDao;
import com.lanou.cc.domain.CourseType;
import com.lanou.cc.service.CourseTypeService;
import com.lanou.util.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public class CourseTypeServiceImpl implements CourseTypeService {

    private CourseTypeDao courseTypeDao;

    @Override
    public List<CourseType> find(CourseType courseType) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramList = new ArrayList<>();
        if (StringUtils.isNotBlank(courseType.getCourseName())) {
            sb.append(" and courseName like ?");
            paramList.add("%" + courseType.getCourseName() + "%");
        }

        if (StringUtils.isNotBlank(courseType.getRemark())) {
            sb.append(" and remark like ?");
            paramList.add("%" + courseType.getRemark() + "%");
        }

        if (StringUtils.isNotBlank(courseType.getTotalStart())) {
            sb.append(" and total >= ?");
            paramList.add(Integer.parseInt(courseType.getTotalStart()));
        }

        if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
            sb.append(" and total <= ?");
            paramList.add(Integer.parseInt(courseType.getTotalEnd()));
        }

        if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
            sb.append(" and courseCost >= ?");
            paramList.add(Double.parseDouble(courseType.getCourseCostStart()));
        }

        if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
            sb.append(" and courseCost <= ?");
            paramList.add(Double.parseDouble(courseType.getCourseCostEnd()));
        }

        String condition = sb.toString();
        Object[] params = paramList.toArray();
        return courseTypeDao.find(condition, params);
    }

    @Override
    public CourseType findById(String courseTypeId) {

        return courseTypeDao.findById(courseTypeId);
    }

    @Override
    public void saveCourse(CourseType courseType) {
        courseTypeDao.saveCourse(courseType);
    }

    @Override
    public void updateCourse(CourseType courseType) {
        courseTypeDao.update(courseType);
    }

    @Override
    public List<CourseType> findAll() {
        return courseTypeDao.findAll();
    }

    @Override
    public PageBean<CourseType> findAll(CourseType courseType, int pageNum, int pageSize) {
        StringBuilder sb = new StringBuilder();
        List<Object> paramList = new ArrayList<>();
        if (StringUtils.isNotBlank(courseType.getCourseName())) {
            sb.append(" and courseName like ?");
            paramList.add("%" + courseType.getCourseName() + "%");
        }

        if (StringUtils.isNotBlank(courseType.getRemark())) {
            sb.append(" and remark like ?");
            paramList.add("%" + courseType.getRemark() + "%");
        }

        if (StringUtils.isNotBlank(courseType.getTotalStart())) {
            sb.append(" and total >= ?");
            paramList.add(Integer.parseInt(courseType.getTotalStart()));
        }

        if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
            sb.append(" and total <= ?");
            paramList.add(Integer.parseInt(courseType.getTotalEnd()));
        }

        if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
            sb.append(" and courseCost >= ?");
            paramList.add(Double.parseDouble(courseType.getCourseCostStart()));
        }

        if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
            sb.append(" and courseCost <= ?");
            paramList.add(Double.parseDouble(courseType.getCourseCostEnd()));
        }

        String condition = sb.toString();
        Object[] params = paramList.toArray();

        int totalRecord = courseTypeDao.getTotalRecord(condition,params);
        PageBean<CourseType> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<CourseType> data = courseTypeDao.find1(condition, params, pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    public CourseTypeDao getCourseTypeDao() {
        return courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }
}
