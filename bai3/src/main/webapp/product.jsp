<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/11/2026
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex">
    <p>Product List</p>
    <c:forEach items="${products}" var="product">
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px; width: 200px ; margin-right: 10px;">
            <h3>${product.model}</h3>
            <p>Price: $${product.price}</p>
            <div>
                <img src="${pageContext.request.contextPath}/${product.imgUrl}" alt="${product.model}" width="150"
                     height="150">
            </div>
            <form action="${pageContext.request.contextPath}/cart" method="post">
                <input type="text" size="2" value="1" name="quantity"> <br/>
                <input type="hidden" name="id" value="${product.id}">
                <input type="hidden" name="price" value="${product.price}">
                <input type="hidden" name="model" value="${product.model}">
                <input type="hidden" name="action" value="add"><br/>
                <input type="submit" name="addToCart" value="Add To Cart"><br/>
            </form>
            <a href="${pageContext.request.contextPath}/product?id=${product.id}">Product detail</a>
        </div>
    </c:forEach>

</div>
<a href="${pageContext.request.contextPath}/cart">Go to Cart</a>
</body>
</html>
