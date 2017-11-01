package com.lanou.dps.service.impl;

import com.lanou.dps.dao.PostDao;
import com.lanou.dps.domain.Post;
import com.lanou.dps.service.PostService;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public class PostServiceImpl implements PostService {
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

    @Override
    public void update(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public List<Post> findPostByDepId(String depId) {
        return postDao.findPostByDepId(depId);
    }

    @Override
    public Post findPostByPostId(String postId) {
        return postDao.findPostByPostId(postId);
    }

    @Override
    public PageBean<Post> findAllDepartmentP(Post post, int pageNum, int pageSize) {
        int totalRecord = postDao.getTotalRecord();
        PageBean<Post> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Post> data = postDao.find1(pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }
}
