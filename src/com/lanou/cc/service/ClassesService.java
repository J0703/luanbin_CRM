package com.lanou.cc.service;

import com.lanou.cc.domain.Classes;
import com.lanou.dps.util.PageBean;

/**
 * Created by dllo on 2017/10/30.
 */
public interface ClassesService {
    void addOrUpdateClasses(Classes classes);

    PageBean<Classes> findAll(Classes classes, int pageNum, int pageSize);

    Classes findClassesByClassId(String classId);
}
