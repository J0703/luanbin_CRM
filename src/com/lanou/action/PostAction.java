package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.service.DepartmentService;
import com.lanou.service.PostService;
import com.lanou.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 2017/10/25.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post> {
    private Post post = new Post();

    private String department_id;
    @Resource
    private PostService postService;
    @Resource(name = "departmentService")
    private DepartmentService departmentService;


    public String findAllPost() {
        List<Post> posts = postService.findAllPost();
        ActionContext.getContext().getSession().put("posts", posts);
        System.out.println(posts);
        return SUCCESS;
    }

    public String addPost() {
        Department department = departmentService.findById(department_id);
        post.setDepartment(department);
        postService.addPost(post);
        return SUCCESS;
    }

    @Override
    public Post getModel() {
        return post;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }
}
