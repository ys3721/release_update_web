<%@ page import="java.util.*" %>
<html>
<body>
    <h1 align="center">当前要更新使用的服务器包为：</h1>
    <p>
        <%
            String packageName = (String) request.getAttribute("packageName");
            out.println(packageName);
        %>
    </p>

</body>
</html>