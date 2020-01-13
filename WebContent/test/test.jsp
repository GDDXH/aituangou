<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dknight
  Date: 2018/11/5
  Time: 上午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
	<s:property value="buyer.id"/>
	<s:iterator value="carts" status="status">
	<p>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</p>
			<tr>
				<td><s:property value="price"/></td>
			</tr>
	</s:iterator>
</body>
</html>
