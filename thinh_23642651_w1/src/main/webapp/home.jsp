<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 8/18/2026
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello, ${sessionScope.user}</h2>

<a href="${pageContext.request.contextPath}/secure/secret.jsp">Secure page</a><br>
<a href="${pageContext.request.contextPath}/uploadmulti">Upload multiple file</a><br>
<a href="${pageContext.request.contextPath}/uploadDb">Upload file to database</a><br>
<a href="${pageContext.request.contextPath}/send-mail.jsp">Send email</a><br>

<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>
