package com.lanou.cc.action;

import com.lanou.cc.domain.Classes;
import com.lanou.cc.domain.CourseType;
import com.lanou.cc.service.ClassesService;
import com.lanou.cc.service.CourseTypeService;
import com.lanou.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 2017/10/30.
 */
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {

    private Classes classes = new Classes();

    @Resource
    private ClassesService classesService;

    @Resource(name = "courseTypeService")
    private CourseTypeService courseTypeService;


    private int pageNum = 1;
    private int pageSize = 3;

    public String addOrUpdateClasses() {
        classesService.addOrUpdateClasses(classes);
        return SUCCESS;
    }

    public String findAllClasses() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Classes> all = classesService.findAll(classes, pageNum, pageSize);
        ActionContext.getContext().put("pageBean", all);

        ValueStack valueStack = ActionContext.getContext().getValueStack();
        return SUCCESS;
    }

    public String findAllCourseType() {
        List<CourseType> all = courseTypeService.findAll();
        ActionContext.getContext().put("courseType", all);
        return SUCCESS;
    }

    //文件上传
    private File schedule;//表单提交过来的文件
    private String scheduleFileName;// 提交的文件对应的文件名 例如test.png
    private String scheduleContentType;// 提交的文件对应的格式

    /**
     * 文件上传
     *
     * @return
     */
    public String singleUpload() {
        // 获取当前项目下的files路径
        String path = ServletActionContext.getServletContext().getRealPath("files");
        File deskFile = new File(path);

        // 如果目的文件不存在, 需要创建一下files
        if (!deskFile.exists() || !deskFile.isDirectory()) {
            deskFile.mkdirs();
        }

        //构建一个空的文件对象, 用于存储上传的文件
        File file = new File(deskFile, scheduleFileName);

        try {
            FileUtils.copyFile(schedule, file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Classes classes1 = classesService.findClassesByClassId(classes.getClassId());
        classes1.setUploadFilename(scheduleFileName);
        classes1.setUploadPath(path);
        Date dt = new Date();
        classes1.setUploadTime(dt);
        classesService.addOrUpdateClasses(classes1);
        return SUCCESS;
    }

    //文件下载
    private InputStream inputStream;
    private String fileName;//要下载的名称

    /**
     * 文件下载
     */
    public String download() {
        // 获得下载路径
        String dirPath = ServletActionContext.getServletContext().getRealPath("files");

//        fileName = "4ec2d5628535e5dd05f20f5171c6a7efcf1b6266.jpg";//初始化文件名称

        File file = new File(dirPath, fileName);

        try {
            /* 构建输入流对象 */
            inputStream = new FileInputStream(file);
            /* 将文件名称中包含中文的部分进行浏览器的兼容处理, 放在inputStream赋值之后, 动作方法返回之前*/
            fileName = filenameEncoding(fileName,
                    ServletActionContext.getRequest(),
                    ServletActionContext.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String filenameEncoding(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String agent = request.getHeader("User-Agent");
        if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
        } else if (agent.contains("Safari")) {
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    public File getSchedule() {
        return schedule;
    }

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public String getScheduleFileName() {
        return scheduleFileName;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    public String getScheduleContentType() {
        return scheduleContentType;
    }

    public void setScheduleContentType(String scheduleContentType) {
        this.scheduleContentType = scheduleContentType;
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Classes getModel() {
        return classes;
    }
}
