package com.lanou.dps.dao;

import com.lanou.dps.domain.Post;

import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
public interface PostDao {
    List<Post> findAllPost();

    void addPost(Post post);

    void updatePost(Post post);

    List<Post> findPostByDepId(String depId);

    Post findPostByPostId(String postId);

    int getTotalRecord();

    List<Post> find1(int startIndex, int pageSize);
}
