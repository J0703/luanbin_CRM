package com.lanou.base.impl;

import com.lanou.base.BaseDao;
import com.lanou.util.PageHibernateCallback;
import org.hibernate.*;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/20.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {


    private Class<?> beanClass;

    // 在运行的时候，获取到泛型 T的具体类型
    public BaseDaoImpl() {
        ParameterizedType paramType= (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取所有实际参数值--所有。而我们只需要一个
        beanClass = (Class<?>) paramType.getActualTypeArguments()[0];

    }

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

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from " + beanClass.getName() + " c where 1=1 " + condition;
        List<Long> find = (List<Long>) getHibernateTemplate().find(hql, params);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    public List<T> findAll1(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from " + beanClass.getName() + " where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql,params,startIndex,pageSize));
    }

}
