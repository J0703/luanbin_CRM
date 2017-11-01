package com.lanou.util;

import com.lanou.dps.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by dllo on 2017/10/30.
 */
public class Interceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");
        System.out.println(staff);
        if (!"人力资源部".equals(staff.getPost().getDepartment().getDepName())) {
            ActionContext.getContext().put("msg","你没有权限");
            return "miss";
        }
        return actionInvocation.invoke();
    }
}
