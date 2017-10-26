package com.lanou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/20.
 */
public interface BaseDao<T> {

    /**
     * 通过主键id查询某个对象
     * @param id
     * @param tClass
     * @return
     */
    T findById(Serializable id, Class<T> tClass);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll(String hql);

    /**
     * 根据条件查询, 返回查询到的第一个结果集合
     *
     * @param hql 查询语句
     * @param params 参数列表
     * @return
     */
    List<T> find(String hql, Map<String, Object> params);

    /**
     * 根据条件查询, 返回查询到的第一个结果
     *
     * @param hql 查询语句
     * @param params 参数列表
     * @return
     */
    T findSingle(String hql, Map<String, Object> params);


    void save(T t);


    void update(T t);
}
