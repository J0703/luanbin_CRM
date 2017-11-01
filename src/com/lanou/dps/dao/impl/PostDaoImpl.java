package com.lanou.dps.dao.impl;

import com.lanou.base.impl.BaseDaoImpl;
import com.lanou.dps.dao.PostDao;
import com.lanou.dps.domain.Post;
import com.lanou.util.PageHibernateCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/25.
 */
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
    @Override
    public List<Post> findAllPost() {
        return findAll("from Post");
    }

    @Override
    public void addPost(Post post) {
        save(post);
    }

    @Override
    public void updatePost(Post post) {
        update(post);
    }

    @Override
    public List<Post> findPostByDepId(String depId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", depId);
        return find("from Post where department_id=:id", map);
    }

    @Override
    public Post findPostByPostId(String postId) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", postId);
        return findSingle("from Post where postId=:id", map);
    }

    @Override
    public int getTotalRecord() {
        String  hql = "select count(d) from Post d where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(hql);

        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Post> find1(int startIndex, int pageSize) {
        String hql = "from Post where 1=1 ";
        return getHibernateTemplate().execute(new PageHibernateCallback<Post>(hql, startIndex, pageSize));
    }
}
