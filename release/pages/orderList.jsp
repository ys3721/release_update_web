<%@ page import="java.util.List" %>
<%@ page import="cn.kaixin.model.OrderModel" %><%--
  Created by IntelliJ IDEA.
  User: Yao Shuai
  Date: 2019/8/9
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>可以了</title>
</head>
<body>
<div align="center">
    <h1>Test struts logic-el Iterate Tag</h1>
</div>

<%
    {
        List<OrderModel> _orders = (List)request.getAttribute("orderModelList");
        out.println(_orders.size() +"条数据</p></br>");
        for (OrderModel order : _orders) {
            out.println(order.toString());
            out.println("</p></br>");
        }
    }
%>

</body>
</html>
