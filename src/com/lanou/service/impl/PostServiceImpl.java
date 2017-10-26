package com.lanou.service.impl;

import com.lanou.dao.PostDao;
import com.lanou.domain.Post;
import com.lanou.service.PostService;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public class PostServiceImpl implements PostService{
    private PostDao postDao;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAllPost() {
        return postDao.findAllPost();
    }

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }
}
