package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
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

}
