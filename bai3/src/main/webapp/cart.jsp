<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/13/2026
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<h2>Cart</h2>
<c:if test="${empty cart.cartItemBeans}">
     <p>Cart is empty!</p>
</c:if>
<c:if test="${not empty cart.cartItemBeans}">
    <table class="table table-border">
        <tr>
            <th>Model</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="item" items="${cart.cartItemBeans}">
            <tr>
                <td>${item.product.model}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post"
                          style="display:inline;">
                        <input type="hidden" name="action" value="update"/>
                        <input type="hidden" name="productId" value="${item.product.id}"/>
                        <input type="number" name="quantity" value="${item.quantity}"
                               min="1"/>
                        <input type="submit" value="Update"/>
                    </form>
                </td>
                <td>${item.product.price}</td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post"
                          style="display:inline;">
                        <input type="hidden" name="action" value="remove"/>
                        <input type="hidden" name="productId" value="${item.product.id}"/>
                        <input type="submit" value="Remove"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><strong>Total: </strong> ${cart.total}</p>
    <form action="${pageContext.request.contextPath}/cart" method="post">
        <input type="hidden" name="action" value="clear"/>
        <input type="submit" value="Clear Cart"/>
    </form>
</c:if>

<a href="${pageContext.request.contextPath}/product">Continute Shopping</a>
</body
</html>
