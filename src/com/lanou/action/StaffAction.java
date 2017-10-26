package com.lanou.action;

import com.lanou.domain.Staff;
import com.lanou.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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

    public String login() {

        if (staffService.login(staff.getLoginName(), staff.getLoginPwd())) {
            ActionContext.getContext().getSession().put("name", staff.getLoginName());
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
}
