package com.lanou.dps.dao.impl;

import com.lanou.dps.dao.StaffDao;
import com.lanou.dps.domain.Staff;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/24.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    @Override
    public Staff login(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password",password);
        return findSingle("from Staff where loginName=:name and loginPwd=:password",map);
    }


    @Override
    public List<Staff> findAll() {
        return (List<Staff>) getHibernateTemplate().find("from Staff");
    }

    @Override
    public void add(Staff staff) {
        save(staff);
    }

    @Override
    public Staff findByStaffId(String staffId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", staffId);
        return findSingle("from Staff where staffId=:id", map);
    }

    @Override
    public void editStaff(Staff staff) {
        update(staff);
    }

    @Override
    public List<Staff> findStaffByPostId(String postId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", postId);
        return find("from Staff where post_id=:id", map);
    }

    @Override
    public List<Staff> findStaffByPostIdAndStaffName(String postId, String staffName) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", postId);
        return find("from Staff where post_id=:id and staffName like '%" + staffName + "%'", map);
    }



    @Override
    public List<Staff> findStaffByStaffName(String staffName) {
        return findAll("from Staff where staffName like '%" + staffName + "%'");
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
