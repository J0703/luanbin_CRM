package com.lanou.dao.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    @Override
    public boolean login(String name, String password) {

        Object[] params = {name, password};
        List<Staff> users = (List<Staff>) getHibernateTemplate().find("from Staff where loginName=? and loginPwd=?", params);
        return users.size() > 0;
    }

    /**
     * 通过主键id获取对象
     * @param id
     * @return
     */
    public Staff get(Serializable id) {

        Session session = currentSession();

        return (Staff) session.get(Staff.class, id);
    }
}
