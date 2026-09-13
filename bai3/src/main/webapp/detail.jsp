<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/13/2026
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product ${product.model}</title>
</head>
<body>
    <h1>${product.model}</h1>
    <p>Price: $${product.price}</p>
    <p>Description: ${product.description}</p>
    <p>Quantity: ${product.quantity}</p>
    <div>
        <img src="${pageContext.request.contextPath}/${product.imgUrl}" alt="${product.model}" width="150" height="150">
    </div>
    <form action="${pageContext.request.contextPath}/cart" method="post">
        <input type="hidden" name="productId" value="${product.id}">
        <button>Add To Cart</button>
    </form>

</body>
</html>
