package com.lanou.dps.domain;

import java.util.Set;

/**
 * Created by dllo on 2017/10/14.
 */
public class Department {
    private String depId;
    private String depName;
    private Set<Post> postList;

    public Department() {
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public Department(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPostList() {
        return postList;
    }

    public void setPostList(Set<Post> postList) {
        this.postList = postList;
    }
}
