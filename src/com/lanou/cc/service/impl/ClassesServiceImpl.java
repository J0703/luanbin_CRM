package com.lanou.cc.service.impl;

import com.lanou.cc.dao.ClassesDao;
import com.lanou.cc.domain.Classes;
import com.lanou.cc.service.ClassesService;
import com.lanou.dps.domain.Department;
import com.lanou.dps.util.PageBean;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/30.
 */
public class ClassesServiceImpl implements ClassesService{

    private ClassesDao classesDao;


    @Override
    public void addOrUpdateClasses(Classes classes) {
        if (StringUtils.isBlank(classes.getClassId())){
            classesDao.save(classes);
        } else {
            classesDao.update(classes);
        }
    }

    @Override
    public PageBean<Classes> findAll(Classes classes, int pageNum, int pageSize) {
        int totalRecord = classesDao.getTotalRecord("",null);
        PageBean<Classes> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Classes> data = classesDao.findAll1("",null,pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    @Override
    public Classes findClassesByClassId(String classId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",classId);
        return classesDao.findSingle("from Classes where classId=:id",map);
    }


    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }




}
