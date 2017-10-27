<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script src="../../js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="${pageContext.request.contextPath}/editStaff.action" method="Post">

    <input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value="${param.loginName}"/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd" value="${param.loginPwd}"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="${param.staffName}"/></td>
            <td>性别：</td>
            <td>
                <input type="radio" name="gender"
                       value="男" <c:if test="${param.gender eq '男'}">checked="checked"</c:if> />男
                <input type="radio" name="gender"
                       value="女" <c:if test="${param.gender eq '女'}">checked="checked"</c:if> />女
                <input type="text" value="${param.gender}">
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select name="department" id="s1">
                    <s:iterator value="#session.departments" var="depart">
                        <option value="${depart.depId}" <c:if test="${depart.depId eq param.depId}">
                            selected
                        </c:if>>${depart.depName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select name="post" id="s2">
                    <s:iterator value="#session.posts" var="post">
                        <option value="${post.postId}" <c:if test="${post.postId eq param.postId}">
                            selected
                        </c:if>>${post.postName}</option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="${param.onDutyDate}" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>
<script>
    $(function () {
        $("#s1").change(function () {
            $.post("${pageContext.request.contextPath}/findPostByDepId",
                    {
                        depId: $("#s1").val()
                    }
                    ,
                    function (data) {
                        var _html = "";
                        _html = '<option value="-1">' + "--请选择--" + '</option>';
                        $.each(data, function (index, value) {
                            _html += '<option value="' + value.postId + '">' + value.postName + '</option>'
                        });
                        $("#s2").html(_html);
                    }, "json");
        })
    });

</script>
</body>
</html>
