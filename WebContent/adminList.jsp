<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%> 
<s:head/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminList.jsp' starting page</title>
  </head>
	<body>
	<s:property value="#request.tip"/>
	<center>管理员信息列表</center> 
	<table border=1> 
	<tr>
	<th>账号</th> 
	<th>姓名</th> 
	<th>密码</th>
	<th>类型</th>
	<th>删除</th> 
	</tr> 
	<s:iterator value="#request.admins">
	<tr>
	<td><s:property value="aid"/></td> 
	<td><s:property value="aname"/></td> 
	<td><s:property value="apasw"/></td>
	<td><s:property value="atype"/></td>
	<td>
	<s:form action="delAdmin" method="post">
	<s:hidden name="admin.aid" value="%{aid}"/>
	<s:submit value="删除" theme="simple" />
	</s:form>
	</td>
	</tr> 
	</s:iterator> 
	</table>
	
	<center>添加管理员信息</center> 
	<s:form action="addAdmin" method="post"> 
	<s:textfield name="admin.aid" label="账号" /> 
	<s:textfield name="admin.aname" label="姓名"/> 
	<s:textfield name="admin.apasw" label="密码 "/>
	<s:radio name="admin.atype" list="#{1 : '高级管理员', 0 : '普通管理员'}" label ="管理类型"/> 
	<s:submit value="添加"/> 
	</s:form> 
	<a href="loginSuccess.jsp">返回功能页面</a> 
	</body> 
</html>
