package com.lanou.dao.impl;

import com.lanou.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/20.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = currentSession();

        //通过主键id查询某个对象
//        T t = session.get(tClass,id);

        return null;
    }

    @Override
    public List<T> findAll(String hql) {
        Session session = currentSession();

        Query query = session.createQuery(hql);

        List<T> tList = query.list();

        return tList;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = currentSession();

        Query query = session.createQuery(hql);

        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }

        List<T> tList = query.list();
        return tList;
    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        List<T> tList = find(hql, params);
        if (tList.size() > 0) {
            return tList.get(0);//返回查询结果集的第一个对象
        }
        return null;// 查询结果集为null, 返回NULL
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        Session session = currentSession();
        session.merge(t);
    }

}
