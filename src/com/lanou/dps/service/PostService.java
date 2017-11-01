package com.lanou.dps.service;

import com.lanou.dps.domain.Post;
import com.lanou.util.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public interface PostService {
    List<Post> findAllPost();

    void addPost(Post post);

    void update(Post post);

    List<Post> findPostByDepId(String depId);

    Post findPostByPostId(String postId);

    PageBean<Post> findAllDepartmentP(Post post, int pageNum, int pageSize);
}
