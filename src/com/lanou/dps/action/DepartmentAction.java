package com.lanou.dps.action;

import com.lanou.dps.domain.Department;
import com.lanou.dps.service.DepartmentService;
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
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private Department department = new Department();

    @Resource
    private DepartmentService departmentService;

    private int pageNum;
    private int pageSize = 3;

    public String addDepartment() {
        if (department.getDepName().trim().equals("")) {
            return ERROR;
        }
        if (department.getDepId().equals("")) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }
        return SUCCESS;

    }

    public String findAllDepartmentP() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Department> all = departmentService.findAllDepartmentP(department, pageNum, pageSize);
        ActionContext.getContext().put("pageBean", all);
        return SUCCESS;
    }

    public String findAllDepartment() {

        List<Department> departments = departmentService.findAllDepartment();
        ActionContext.getContext().getSession().put("departments", departments);
        System.out.println(departments);
        return SUCCESS;
    }


    @Override
    public Department getModel() {
        return department;
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
