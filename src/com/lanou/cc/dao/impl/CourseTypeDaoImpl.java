package com.lanou.cc.dao.impl;

import com.lanou.cc.dao.CourseTypeDao;
import com.lanou.cc.domain.CourseType;
import com.lanou.dps.util.PageHibernateCallback;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 2017/10/27.
 */
public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {
    @Override
    public List<CourseType> findAll() {
        String hql = "from CourseType";
        return (List<CourseType>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<CourseType> find(String condition, Object[] params) {
        String hql = "from CourseType where 1=1" + condition;
        return (List<CourseType>) getHibernateTemplate().find(hql, params);
    }

    @Override
    public CourseType findById(String courseTypeId) {

        return getHibernateTemplate().get(CourseType.class, courseTypeId);
    }

    @Override
    public void saveCourse(CourseType courseType) {
        getHibernateTemplate().save(courseType);
    }

    @Override
    public void update(CourseType courseType) {
        Session session = currentSession();
        session.merge(courseType);
    }

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from CourseType c where 1=1 " + condition;
        List<Long> find = (List<Long>) getHibernateTemplate().find(hql, params);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<CourseType> find1(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from CourseType where 1=1 " + condition;
        return getHibernateTemplate().execute(new PageHibernateCallback<CourseType>(hql, params, startIndex, pageSize));
    }

}
