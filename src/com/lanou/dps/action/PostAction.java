package com.lanou.dps.action;

import com.lanou.dps.domain.Department;
import com.lanou.dps.domain.Post;
import com.lanou.dps.service.DepartmentService;
import com.lanou.dps.service.PostService;
import com.lanou.dps.util.PageBean;
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

    private String postID;
    @Resource
    private PostService postService;



    private int pageNum;
    private int pageSize = 3;

    @Resource(name = "departmentService")
    private DepartmentService departmentService;


    public String findAllPost() {
        List<Post> posts = postService.findAllPost();
        ActionContext.getContext().getSession().put("posts", posts);
        return SUCCESS;
    }
    /* 分页 */
    public String findAllPostP() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Post> all = postService.findAllDepartmentP(post, pageNum, pageSize);
        ActionContext.getContext().put("pageBean", all);
        return SUCCESS;
    }

    public String addPost() {
        if (postID.equals("")) {
            System.out.println(1);
            Department department = departmentService.findById(department_id);
            post.setDepartment(department);
            postService.addPost(post);

        } else {
            Department department = departmentService.findById(department_id);
            post.setDepartment(department);
            post.setPostId(postID);
            postService.update(post);
        }
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

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
