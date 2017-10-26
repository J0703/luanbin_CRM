package com.lanou.dao.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.Post;

import java.util.List;

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
}
