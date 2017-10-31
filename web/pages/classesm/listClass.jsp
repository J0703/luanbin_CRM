<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
    <title>班级管理</title>
</head>
<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<form name="createForm" action="" method="Post">
    <table border="0" cellspacing="0" cellpadding="0" class="wukuang">
        <tr>
            <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
            <td width="20%" align="left">[班级管理]</td>
            <td width="42%" align="center">&nbsp;</td>
            <td width="36%" align="right">
                <%--添加班级  /html/classesm/addClass.jsp--%>
                <a href="${pageContext.request.contextPath}/findAllCourseType.action">
                    <img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/>
                </a>
                <%--高级查询
                <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
                --%>
            </td>
            <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
        </tr>
    </table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="97%" border="1">
    <thead>
    <tr class="henglan" style="font-weight:bold;">
        <th width="150px" align="center">班级名称</th>
        <th width="200px" align="center">所属课程</th>
        <th width="80px" align="center">开班时间</th>
        <th width="80px" align="center">毕业时间</th>

        <th width="80px" align="center">状态</th>
        <th width="70px" align="center">学生总数</th>
        <th width="70px" align="center">升学数</th>
        <th width="70px" align="center">转班数</th>
        <th width="50px" align="center">编辑</th>
        <th width="50px" align="center">查看</th>
        <th align="center">课程表</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="#pageBean.data" var="classes">
        <tr class="tabtd2">
            <td align="center">${classes.name}</td>
            <td align="center">${classes.courseType.courseName}</td>
            <td align="center">${classes.beginTime}</td>
            <td align="center">${classes.endTime}</td>
            <td align="center"><c:if test="${classes.status eq '0'}">未开班</c:if></td>
            <td align="center">${classes.totalCount}</td>
            <td align="center">${classes.upgradeCount}</td>
            <td align="center">${classes.runoffCount}</td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/pages/classesm/addOrEditClass.jsp?"><img
                        src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/pages/classesm/showClass.jsp"><img
                        src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
            <td align="center" title="上次上传时间：${classes.uploadTime}">

                <c:choose>
                    <c:when test="${empty classes.uploadPath}">
                        <a href="${pageContext.request.contextPath}/pages/classesm/uploadClass.jsp?courseName=${classes.courseType.courseName}&name=${classes.name}&uploadTime=${classes.uploadTime}&id=${classes.classId}">上传</a> | 无法下载
                        <br/>
                    </c:when>
                    <c:otherwise>
                        已上传 |
                        <a href="${pageContext.request.contextPath}/download.action?fileName=${classes.uploadFilename}">下载</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </s:iterator>
    </tbody>
</table>
<s:actionerror/>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第<s:property value="#pageBean.pageNum"/>/<s:property value="#pageBean.totalPage"/>页</span>
            <span>
                <a href="findAllClasses.action">[首页]</a>&nbsp;&nbsp;
            <a href="findAllClasses.action?pageNum=${pageBean.pageNum - 1}">[上一页]</a>&nbsp;&nbsp;
            <a
                    <c:choose>

                        <c:when test="${pageBean.pageNum >= pageBean.totalPage}">href="#"</c:when>

                        <c:otherwise>href="findAllClasses.action?pageNum=${pageBean.pageNum + 1}"</c:otherwise>

                    </c:choose>
            >[下一页]</a>&nbsp;&nbsp;
            <a href="findAllClasses.action?pageNum=${pageBean.totalPage}">[尾页]</a>
                </span>
        </td>
    </tr>
</table>
</body>
</html>
