<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>

<h1>Đăng nhập</h1>

<form action="${pageContext.request.contextPath}/login" method="post">
    Tên đăng nhập:
    <input type="text" name="username" value="admin">
    <br>

    Mật khẩu:
    <input type="password" name="password" value="123">
    <br>

    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>
<a href="${pageContext.request.contextPath}/register.jsp">Don't have an account? Register here</a>
</body>
</html>