package com.lanou.dps.dao.impl;

import com.lanou.cc.domain.CourseType;
import com.lanou.dps.dao.DepartmentDao;
import com.lanou.dps.domain.Department;
import com.lanou.dps.util.PageHibernateCallback;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/25.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {


    @Override
    public void addDepartment(Department department) {
        save(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        String hql = "from Department";
        return findAll(hql);
    }


    @Override
    public void updateDepartment(Department department) {
        update(department);
    }

//    @Override
//    public Department findDepartmentByName(Department department) {
//        Object[] params={department.getDepName()};
//        List<Department> departments = find("from Department where depName=?", params);
//        return departments.get(0);
//
//    }

    @Override
    public Department findById(String department_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", department_id);
        return findSingle("from Department where depId=:id", map);
    }

    @Override
    public int getTotalRecord() {

         String  hql = "select count(d) from Department d where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(hql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> find1(int startIndex, int pageSize) {
        String hql = "from Department where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<Department>(hql, startIndex, pageSize));
    }


}
