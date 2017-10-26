<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[在校学生管理]</td>
   
    <td width="57%"align="right">
    	<%--查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--添加 --%>
    	<a href="${pageContext.request.contextPath}/pages/student/addOrEditStudent.jsp">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<form action="${pageContext.request.contextPath}/pages/student/listStudent.jsp" method="Post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px"><input type="text" name="condition" size="20" value=""/>（姓名|电话|QQ|性别）</td>
	    <td width="500px">
	    	课程类别：
	    	<select name="crmClass.crmCourseType.courseTypeId" onchange="">
			    <option value="">--选择班级--</option>
			    <option value="ee050687bd1a4455a153d7bbb7000008">JavaEE</option>
			    <option value="ee050687bd1a4455a153d7bbb7000009">大数据</option>
			</select>

	    	班级：<select name="crmClass.classId" >
				    <option value="">----请--选--择----</option>
				</select>
	    </td>
	    <td></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">入学时间</td>
    <td width="10%" align="center">班级</td>
    <td width="10%" align="center">QQ</td>
    <td width="10%" align="center">联系电话</td>
    <td width="10%" align="center">已付/应付学费</td>
    <td width="10%" align="center">状态</td>  <!-- 新生、转班、升级、退费、毕业 -->
  	<td width="5%" align="center">编辑</td>
  	<td width="5%" align="center">升级/转班</td>
  	<td width="5%" align="center">查看</td>
  	<td width="5%" align="center">流失</td>
  </tr>
  
	   <tr class="tabtd1">
		<td align="center">张三(男) </td>
		<td align="center">张三 </td>
		<td align="center">J161001期 </td>
		<td align="center">123456 </td>
		<td align="center">13312341234 </td>
		<td align="center">18000/18000 </td>
		<td align="center">
			新生 
		</td>
		
	    <td align="center">
	    	<a href="${pageContext.request.contextPath}/pages/student/addOrEditStudent.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
	    </td>
	    
	    <td align="center">
	    	<a href="${pageContext.request.contextPath}/pages/station/editStation.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
    	</td>
    	<!-- 查询详情 -->
		<td align="center">
			<a href="${pageContext.request.contextPath}/pages/student/showStudent.jsp"><img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/></a>
		</td>
		
	    <td align="center">
			<a href="${pageContext.request.contextPath}/pages/runoff/addRunoff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
	    </td>
	  </tr>
  
	   <tr class="tabtd2">
		<td align="center">李四(男) </td>
		<td align="center">李四 </td>
		<td align="center">J161001期 </td>
		<td align="center">234567 </td>
		<td align="center">13323452345 </td>
		<td align="center">18000/18000 </td>
		<td align="center">
			升级 
		</td>
		
	    <td align="center">
	    	<a href="${pageContext.request.contextPath}/pages/student/addOrEditStudent.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
	    </td>
	    
	    <td align="center">
	    	<a href="${pageContext.request.contextPath}/pages/station/editStation.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
    	</td>
    	<!-- 查询详情 -->
		<td align="center">
			<a href="${pageContext.request.contextPath}/pages/student/showStudent.jsp"><img src="${pageContext.request.contextPath}/images/button/view.gif" class="img"/></a>
		</td>
		
	    <td align="center">
			<a href="${pageContext.request.contextPath}/pages/runoff/addRunoff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
	    </td>
	  </tr>
  
</table>



<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
</body>
</html>