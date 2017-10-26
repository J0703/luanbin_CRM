package com.lanou.dao;

import com.lanou.domain.Post;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public interface PostDao {
    List<Post> findAllPost();

    void addPost(Post post);
}
