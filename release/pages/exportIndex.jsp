<%--
  Created by IntelliJ IDEA.
  User: Yao Shuai
  Date: 2019/8/13
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>去看999这个号</title>
</head>
<body>
<h3>这个是输入角色号，然后去qa3看997这个号</h3>
<form action="exportRole.do" method="get">
    <p>IP: <input type="text" name="ip" /></p>
    <p>数据端口: <input type="text" name="port" /></p>
    <p>角色id: <input type="text" name="roleId" /></p>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
