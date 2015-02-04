<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SSO 登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/simter/sso/login.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/simter/sso/login" method="post">
    <input type="text" name="account" placeholder="帐号" required value="${param.account}" autofocus>
    <input type="text" name="password" placeholder="密码" required value="${param.password}">
    <input type="submit" name="login" value="登录">
    <input type="hidden" name="origin" value="${param.origin}">
    <div style="color: red">${msg}</div>
</form>
</body>
</html>