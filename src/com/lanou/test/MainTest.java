package com.lanou.test;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 2017/10/26.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void addPost(){

        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        PostService postService = (PostService) context.getBean("postService");

        Department department = departmentService.findById("2c90906f5f522d64015f522d9c6e0000");

        Post post = new Post();
        post.setPostName("dsfj");
        post.setDepartment(department);

        postService.addPost(post);
        System.out.println(department);
    }

}
