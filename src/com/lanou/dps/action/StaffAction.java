package com.lanou.dps.action;

import com.lanou.dps.domain.Department;
import com.lanou.dps.domain.Post;
import com.lanou.dps.domain.Staff;
import com.lanou.dps.service.PostService;
import com.lanou.dps.service.StaffService;
import com.lanou.dps.service.DepartmentService;
import com.lanou.dps.util.CrmStringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 2017/10/24.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();
    //使用spring属性注解完成service层的装载
    @Resource
    private StaffService staffService;
    private List<Department> departments = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private String depId;


    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    @Resource(name = "postService")
    private PostService postService;


    public String findDepartment() {
        departments = departmentService.findAllDepartment();
        return SUCCESS;
    }


    public String findPostByDepId() {
        posts = postService.findPostByDepId(this.depId);
        return SUCCESS;
    }

    public String showStaff() {

        if ("".equals(staff.getStaffName())) {
            if ("-1".equals(staff.getDepartment().getDepId())) {
                List<Staff> staffs = staffService.findAll();
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else if ("-1".equals(staff.getPost().getPostId())) {
                List<Post> posts = postService.findPostByDepId(staff.getDepartment().getDepId());

                List<Staff> staffs = new ArrayList<>();
                for (Post post : posts) {
                    List<Staff> staffByPostId = staffService.findStaffByPostId(post.getPostId());
                    for (Staff staff1 : staffByPostId) {
                        staffs.add(staff1);
                    }
                }
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else {
                List<Staff> staffs = staffService.findStaffByPostId(staff.getPost().getPostId());
                ActionContext.getContext().getSession().put("staffs", staffs);
            }
        } else {
            if ("-1".equals(staff.getDepartment().getDepId())) {
                List<Staff> staffs = staffService.findStaffByStaffName(staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else if ("-1".equals(staff.getPost().getPostId())) {
                List<Post> posts = postService.findPostByDepId(staff.getDepartment().getDepId());
                List<Staff> staffs = new ArrayList<>();
                for (Post post : posts) {
                    List<Staff> staffByPostId = staffService.findStaffByPostIdAndStaffName(post.getPostId(), staff.getStaffName());
                    for (Staff staff1 : staffByPostId) {
                        staffs.add(staff1);
                    }
                }
                ActionContext.getContext().getSession().put("staffs", staffs);
            } else {
                List<Staff> staffs = staffService.findStaffByPostIdAndStaffName(staff.getPost().getPostId(), staff.getStaffName());
                ActionContext.getContext().getSession().put("staffs", staffs);
            }
        }
        return SUCCESS;
    }

    public String addStaff() {

        if ("".equals(staff.getLoginName())) {
            addActionError("登录名不能为空");
            return INPUT;
        }
        if ("".equals(staff.getLoginPwd())) {
            addActionError("密码不能为空");
            return INPUT;
        }
        if ("".equals(staff.getStaffName())) {
            addActionError("姓名不能为空");
            return INPUT;
        }
        if ("".equals(staff.getGender())) {
            addActionError("性别不能为空");
            return INPUT;
        }
        if ("-1".equals(staff.getDepartment().getDepId())) {
            addActionError("请选择部门");
            return INPUT;
        }
        if ("-1".equals(staff.getPost().getPostId())) {
            addActionError("请选择职务");
            return INPUT;
        }
        if (staff.getOnDutyDate() == null) {
            addActionError("入职时间不能为空");
            return INPUT;
        }
        Department byId = departmentService.findById(staff.getDepartment().getDepId());
        staff.setDepartment(byId);
        staff.setLoginPwd(CrmStringUtils.getMD5Value(staff.getLoginPwd()));
        staff.getPost().setDepartment(byId);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.addStaff(staff);
        return SUCCESS;
    }

    public String listStaff() {
        List<Staff> staffs = staffService.findAll();
        ActionContext.getContext().getSession().put("staffs", staffs);
        return SUCCESS;
    }

    public String findDepartmentAndPost() {
        staff = staffService.findByStaffId(staff.getStaffId());
        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments", departments);

        List<Post> posts = postService.findPostByDepId(staff.getPost().getDepartment().getDepId());
        ActionContext.getContext().getSession().put("posts", posts);
        return SUCCESS;
    }

    public String editStaff() {
        Department byId = departmentService.findById(staff.getDepartment().getDepId());
        staff.setDepartment(byId);
        staff.getPost().setDepartment(byId);
        Post post1 = postService.findPostByPostId(staff.getPost().getPostId());
        staff.setPost(post1);
        staffService.editStaff(staff);
        return SUCCESS;
    }

    public String login() {
        Staff s = staffService.login(staff.getLoginName(), staff.getLoginPwd());
        if (s != null) {
            ActionContext.getContext().getSession().put("staff", s);
            return SUCCESS;
        }

        return ERROR;
    }

    /**
     * 针对登录动作进行的验证
     */
    public void validateLogin() {
        if (StringUtils.isBlank(staff.getLoginName()) && StringUtils.isBlank(staff.getLoginPwd())) {
            addFieldError("msg", "用户名密码不能");
            ActionContext.getContext().getSession().put("msg", "用户名密码不能为空 !~~~~");
        }
    }

    @Override
    public Staff getModel() {
        return staff;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }


}
