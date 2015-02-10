<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SSO 主页</title>
</head>
<body>
<div>
帐号: ${sessionScope.account}<br>
时间: ${sessionScope.ticketTime}<br>
票据: ${sessionScope.ticket}<br>
 SID: ${pageContext.session.id}
</div>
<form action="${pageContext.request.contextPath}/simter/sso/logout" method="post">
    <input type="submit" value="注销">
</form>
</body>
</html>