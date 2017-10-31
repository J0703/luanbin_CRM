package com.lanou.dps.action;

import com.lanou.dps.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by dllo on 2017/10/30.
 */
public class LoginInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        Staff staff = (Staff) ActionContext.getContext().getSession().get("staff");
//        if (StringUtils.isBlank(staff.getLoginName())){
//            String result = actionInvocation.invoke();
//            return result;
//        }
        return actionInvocation.invoke();
    }
}
