<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO 登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/simter/sso/login" method="post">
    <input type="text" name="account" placeholder="帐号" required value="${param.account}" autofocus>
    <input type="text" name="password" placeholder="密码" required value="${param.password}">
    <input type="submit" name="login" value="登录">
    <input type="hidden" name="origin" value="${param.origin}">
    <div>sessionId=${pageContext.session.id}</div>
    <div style="color: red">${msg}</div>
</form>
</body>
</html>