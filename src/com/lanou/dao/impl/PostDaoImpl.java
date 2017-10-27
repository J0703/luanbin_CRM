package com.lanou.dao.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 2017/10/25.
 */
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{
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
        Map<String,Object> map = new HashMap<>();
        map.put("id",depId);
        return find("from Post where department_id=:id", map);
    }

    @Override
    public Post findPostByPostId(String postId) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",postId);
        return findSingle("from Post where postId=:id", map);
    }
}
