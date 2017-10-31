<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <STYLE>
        .cla1 {
            FONT-SIZE: 12px;
            COLOR: #4b4b4b;
            LINE-HEIGHT: 18px;
            TEXT-DECORATION: none
        }

        .login_msg {
            font-family: serif;
        }

        .login_msg .msg {
            background-color: #acf;
        }

        .login_msg .btn {
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微软雅黑;
        }
        a{text-decoration: none}
        div>a:hover{
            font-size: xx-large;
            color: red;
        }
        a:visited{
            color: blue;
        }
    </STYLE>

    <TITLE></TITLE>
    <script type="text/javascript">
        if (self != top) {
            top.location = self.location;
        }
    </script>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
      background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" staffId="table1">
        <tr>
            <td height="193"></td>

        </tr>
        <tr align="center">

            <td class="login_msg" width="400">
                <form action="${pageContext.request.contextPath}login.action" method="Post">

                    <font size="6" color="#ffffff">
                        欢迎使用CRM系统
                    </font>
                    <br/>
                    <br/>
                    <font color="#ff0000">
                        ${msg}
                    </font>
                    <br/>
                    用户名：<input type="text" name="loginName" class="msg"/><br/><br/>
                    密&nbsp;码：<input type="password" name="loginPwd" class="msg"/><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" class="btn" value="登录 "/>

                </form>
            </td>
        </tr>
    </table>
    <a href="/小游戏.jsp">不如打把游戏??</a>

    <script type="text/javascript">
        /* s标签中直接编写JavaScript代码时，不支持el表达式，只能提供单独的函数
         function registerUrl(){
         document.location='/uiAction_staff_register';
         }
         */
    </script>
</div>
</BODY>
</HTML>