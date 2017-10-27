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

<form action="addStaff.action" method="Post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value=""/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="" staffId="staffAction_add_staffName"/></td>
            <td>性别：</td>
            <td><input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select  id="s1" name="department.depId">
                </select>

            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select id="s2" name="post.postId">
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>
<script>
    $(function () {
        $.post("${pageContext.request.contextPath}/findDepartment", null,
                function (data) {
                    var _html = "";
                    _html = '<option value="-1">' + "--请选择--" + '</option>';
                    $("#s2").html(_html);
                    $.each(data, function (index, value) {
                        _html += '<option value="' + value.depId + '">' + value.depName + '</option>'
                    });
                    $("#s1").html(_html);
                }, "json");

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
