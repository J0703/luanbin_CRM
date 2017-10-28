package com.lanou.cc.action;

import com.lanou.cc.domain.CourseType;
import com.lanou.cc.service.CourseTypeService;
import com.lanou.dps.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 2017/10/27.
 */
@Controller("courseTypeAction")
@Scope("prototype")
public class CourseTypeAction extends ActionSupport implements ModelDriven<CourseType> {

    private CourseType courseType = new CourseType();

    @Resource
    private CourseTypeService courseTypeService;

    private int pageNum = 1;
    private int pageSize = 3;

    //分页
    public String findAll() {
        PageBean<CourseType> all = courseTypeService.findAll(courseType, pageNum, pageSize);
        ActionContext.getContext().put("pageBean", all);
        return SUCCESS;
    }

    //原来的方法
//    public String find() {
//        List<CourseType> courseTypes = courseTypeService.find(courseType);
//        ActionContext.getContext().put("courseTypes", courseTypes);
//        return SUCCESS;
//    }


    public String addOrEditUI() {
        if (StringUtils.isBlank(courseType.getCourseTypeId())) {
            courseTypeService.saveCourse(courseType);
        } else {
            courseTypeService.updateCourse(courseType);
        }
        return SUCCESS;
    }

    @Override
    public CourseType getModel() {
        return courseType;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
