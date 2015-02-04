<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSO 主页</title>
</head>
<body>
帐号: ${sessionScope.account}<br>
时间: ${sessionScope.ticketTime}<br>
票据: ${sessionScope.ticket}
</body>
</html>