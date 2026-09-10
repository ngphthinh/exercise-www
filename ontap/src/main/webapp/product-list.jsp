<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/9/2026
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${products}" var="product">
    <div>
        <p>product name: ${product.productName}</p>
        <p>price: ${product.price}</p>
        <p>description: ${product.description}</p>
        <p>category: ${product.category}</p>
        <p>expiryDate: ${product.expiryDate}</p>
        <p>available: ${product.available ? "Yes" : "No" }</p>
        <img src="${pageContext.request.contextPath}/uploads/${product.urlImg}"
             alt="${product.productName}">
    </div>
</c:forEach>
</body>
</html>
