package com.lanou.dps.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 2017/10/28.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

    private String hql;

    private Object[] params;

    private int startIndex;

    private int pageSize;

    public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    public PageHibernateCallback(String hql, int startIndex, int pageSize) {
        this.hql = hql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {

        // 1. 通过hql语句获取query对象
        Query queryObject = session.createQuery(hql);

        if (params != null) {

            // 2. 条件的设置
            for (int i = 0; i < params.length; i++) {

                queryObject.setParameter(i, params[i]);

            }

        }

        // 3.分页
        queryObject.setFirstResult(startIndex);

        queryObject.setMaxResults(pageSize);

        // 4.查询所有
        return queryObject.list();
    }
}
