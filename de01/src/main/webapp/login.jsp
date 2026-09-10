<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/9/2026
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input placeholder="Enter your username" type="text" name="username" value="${username}"/>
    <input placeholder="Enter your password" type="password" name="password" value="${password}"/>
    <button type="submit">Login</button>
</form>
</body>
</html>
