<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[课程类别]</td>

        <td width="57%" align="right">
            <a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/>
            </a>
            <%--编辑前：添加类别 --%>
            <a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>


<%--条件查询 start --%>

<s:form namespace="/" action="findAll">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <s:hidden id="pageNum" name="pageNum" value="1"/>
        <tr>
            <td width="10%">课程类别：</td>
            <td><input type="text" name="courseName" size="30" value=""></td>
        </tr>
        <tr>
            <td>课程简介：</td>
            <td><input type="text" name="remark" size="30" value=""/></td>
        </tr>
        <tr>
            <td>总学时：</td>
            <td><input type="text" name="totalStart" size="12" value=""/> 至 <input type="text" name="totalEnd" size="12"
                                                                                   value=""/></td>
        </tr>
        <tr>
            <td>课程费用：</td>
            <td><input type="text" name="courseCostStart" size="12" value=""/> 至 <input type="text" name="courseCostEnd"
                                                                                        size="12" value=""/></td>
        </tr>
    </table>
</s:form>

<s:actionerror/>
<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>
<table width="97%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <td width="14%" align="center">名称</td>
        <td width="33%" align="center">简介</td>
        <td width="13%" align="center">总学时</td>
        <td width="18%" align="center">收费标准</td>
        <td width="11%" align="center">编辑</td>
    </tr>
    <%--数据展示，单行：tabtd1；双行：tabtd2 --%>
    <s:iterator value="#pageBean.data" var="courseType">
        <tr class="tabtd1">
            <td align="center">${courseType.courseName}</td>
            <td align="center">${courseType.remark}</td>
            <td align="center">${courseType.total}</td>
            <td align="center">${courseType.courseCost}</td>
            <td width="11%" align="center">

                <a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp?courseTypeId=${courseType.courseTypeId}&courseCost=${courseType.courseCost}&total=${courseType.total}&remark=${courseType.remark}&courseName=${courseType.courseName}"><img
                        src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>

</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第<s:property value="#pageBean.pageNum"/>/<s:property value="#pageBean.totalPage"/>页</span>
            <span>
                <%--<a href="findAll.action">[首页]</a>&nbsp;&nbsp;--%>
            <%--<a href="findAll.action?pageNum=${pageBean.pageNum - 1}">[上一页]</a>&nbsp;&nbsp;--%>
            <%--<a--%>
                    <%--<c:choose>--%>

                        <%--<c:when test="${pageBean.pageNum >= pageBean.totalPage}">href="#"</c:when>--%>

                        <%--<c:otherwise>href="findAll.action?pageNum=${pageBean.pageNum + 1}"</c:otherwise>--%>

                    <%--</c:choose>--%>
            <%-->[下一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="findAll.action?pageNum=${pageBean.totalPage}">[尾页]</a>--%>
                <s:if test="#pageBean.pageNum gt 1">
                    <a href="javascript:void(0)" onclick="showPage(1)">[首页]</a>&nbsp;&nbsp;
                    <a href="javascript:void(0)" onclick="showPage(
                        <s:property value="#pageBean.pageNum - 1 "/> )">[上一页]</a>&nbsp;&nbsp;
                </s:if>
                    <%--动态显示条 --%>
                    <s:iterator begin="#pageBean.start" end="#pageBean.end" var="num">
                        <s:if test="#num <= #pageBean.totalPage">
                            <a href="javascript:void(0)" onclick="showPage(<s:property value="#num"/>)">
                            <s:property value="#num"/> </a>&nbsp;&nbsp;
                        </s:if>
                    </s:iterator>
                <s:if test="#pageBean.pageNum lt #pageBean.totalPage">
                    <a href="javascript:void(0)" onclick="showPage(
                        <s:property value="#pageBean.pageNum + 1"/> )">[下一页]</a>&nbsp;&nbsp;
                    <a href="javascript:void(0)"
                       onclick="showPage(<s:property value="#pageBean.totalPage"/>)">[尾页]</a>
                </s:if>
        </span>
        </td>
    </tr>
</table>
<script type="text/javascript">
    function showPage(num) {
// 1 修改隐藏域的值
        document.getElementById("pageNum").value = num; // 2 提交表单
        document.forms[0].submit();
    }
</script>
</body>
</html>
