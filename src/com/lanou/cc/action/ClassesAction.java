package com.lanou.cc.action;

import com.lanou.cc.domain.Classes;
import com.lanou.cc.service.ClassesService;
import com.lanou.dps.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 2017/10/30.
 */
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {

    private Classes classes = new Classes();

    @Resource
    private ClassesService classesService;

    private int pageNum = 1;
    private int pageSize = 3;

    public String addOrUpdateClasses() {

        System.out.println(classes);
        classesService.addOrUpdateClasses(classes);
        return SUCCESS;
    }

    public String findAllClasses(){
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Classes> all = classesService.findAll(classes,pageNum,pageSize);
        ActionContext.getContext().put(" ", all);

        ValueStack valueStack=ActionContext.getContext().getValueStack();
        System.out.println(all);
        return SUCCESS;
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

    @Override
    public Classes getModel() {
        return classes;
    }
}
