<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSO登录</title>
</head>
<body>
<form action="simter/sso/login" method="post">
    <input type="text" name="account" placeholder="帐号" required value="<%= request.getAttribute("account") %>">
    <input type="text" name="password" placeholder="密码" required value="<%= request.getAttribute("password") %>">
    <input type="submit" name="login" value="登录">
    <input type="hidden" name="origin"
           value="<%= request.getParameter("origin") != null ? request.getParameter("origin") : request.getAttribute("origin") %>">
</form>
</body>
</html>