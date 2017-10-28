package com.lanou.dps.domain;

/**
 * Created by dllo on 2017/10/14.
 */
public class Post {
    private String postId;
    private String postName;

    private Department department;
    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;

    }

    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", department=" + department +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
