<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/14/2026
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Your Shopping Cart</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            color: #333;
        }

        /* Navbar Header Style */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            height: 100px;
            padding: 0 30px;
            background-size: cover;
            background-color: #7a6a58;
        }

        .brand {
            font-size: 26px;
            font-weight: bold;
            color: #ffffff;
            background-color: rgba(90, 90, 90, 0.5);
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            letter-spacing: 1px;
        }

        .nav-links {
            display: flex;
            gap: 10px;
            list-style: none;
        }

        .nav-links a {
            display: block;
            color: #ffffff;
            text-decoration: none;
            background-color: rgba(90, 90, 90, 0.5);
            padding: 8px 14px;
            border-radius: 4px;
            font-size: 13px;
            font-weight: bold;
            text-transform: uppercase;
            transition: background-color 0.2s ease;
        }

        .nav-links a:hover {
            background-color: rgba(60, 60, 60, 0.8);
        }

        /* Container & Layout */
        .container {
            display: flex;
            max-width: 1100px;
            margin: 20px auto;
            padding: 0 15px;
            gap: 30px;
        }

        /* Sidebar Left Styles */
        .sidebar {
            width: 250px;
            flex-shrink: 0;
        }

        .widget {
            background-color: #e6e6e6;
            padding: 15px;
            margin-bottom: 25px;
        }

        .widget-title {
            font-size: 14px;
            color: #777;
            text-transform: uppercase;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .widget p {
            font-size: 12px;
            color: #555;
            line-height: 1.4;
        }

        .widget a {
            color: #333;
            text-decoration: underline;
        }

        .search-input {
            width: 100%;
            padding: 5px;
            border: 1px solid #777;
            border-radius: 6px;
            outline: none;
            margin-bottom: 20px;
        }

        .cart-link {
            font-size: 12px;
            color: #333;
            text-decoration: underline;
        }

        /* Cart Content Table */
        .cart-container {
            flex: 1;
        }

        .cart-title {
            text-align: center;
            font-size: 14px;
            color: #555;
            text-transform: uppercase;
            letter-spacing: 0.5px;
            margin-bottom: 15px;
        }

        .cart-table {
            width: 100%;
            border-collapse: collapse;
            font-size: 13px;
        }

        .cart-table th,
        .cart-table td {
            border: 1px solid #999;
            padding: 8px 10px;
            text-align: left;
        }

        .cart-table th {
            background-color: #2f3e46;
            color: #ffffff;
            font-weight: bold;
        }

        .cart-table td.center,
        .cart-table th.center {
            text-align: center;
        }

        .cart-table td.right,
        .cart-table th.right {
            text-align: right;
        }

        .cart-table a {
            color: #333;
            text-decoration: underline;
        }

        .total-row td {
            font-weight: normal;
        }

        /* Action Buttons */
        .cart-actions {
            margin-top: 15px;
            display: flex;
            gap: 10px;
        }

        .btn {
            padding: 4px 10px;
            font-size: 12px;
            background-color: #f0f0f0;
            border: 1px solid #999;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            color: #333;
        }

        .btn:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>

<!-- Header Navigation -->
<nav class="navbar">
    <a href="#" class="brand">IUH BOOKSTORE</a>
    <ul class="nav-links">
        <li><a href="#">HOME</a></li>
        <li><a href="#">EXAMPLES</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>
</nav>

<!-- Main Container -->
<div class="container">
    <!-- Sidebar Left -->
    <aside class="sidebar">
        <div class="widget">
            <h3 class="widget-title">ABOUT US</h3>
            <p>About us information will be here...... <a href="#">Read More »</a></p>
        </div>

        <div class="sidebar-search">
            <h3 class="widget-title">SEARCH SITE</h3>
            <form action="search" method="get">
                <input type="text" name="keyword" class="search-input" value="${keyword}"/>

            </form>
        </div>

        <div>
            <a href="cart" class="cart-link">Shopping cart (${cart.items.size()})</a>
        </div>
    </aside>

    <!-- Main Content: Cart Table -->
    <main class="cart-container">
        <h2 class="cart-title">YOUR SHOPPING CART</h2>

        <table class="cart-table">
            <thead>
            <tr>
                <th>Product ID</th>
                <th>Product name</th>
                <th class="right">Price</th>
                <th class="center">Qty</th>
                <th class="right">Total</th>
                <th class="center">Remove</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="grandTotal" value="0"/>
            <c:forEach var="item" items="${cart.items}">
                <c:set var="itemTotal" value="${item.book.price * item.quantity}"/>
                <c:set var="grandTotal" value="${grandTotal + itemTotal}"/>
                <tr>
                    <td>${item.book.bookId}</td>
                    <td>
                            ${item.book.title}
                        <c:if test="${not empty item.book.author}">- Tác giả: ${item.book.author}</c:if>
                    </td>
                    <td class="right">${item.book.price}</td>
                    <td class="center">${item.quantity}</td>
                    <td class="right">${itemTotal}</td>
                    <td class="center">
                        <form action="cart" method="post" style="display: inline;">
                            <input type="hidden" name="action" value="remove"/>
                            <input type="hidden" name="bookId" value="${item.book.bookId}"/>
                            <button type="submit" class="btn"
                                    style="background-color: white; border:  none; text-decoration: underline">Remove
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <!-- Total Price Row -->
            <tr class="total-row">
                <td colspan="4" class="right" style="border-right: none;">Total price</td>
                <td colspan="2" class="right" style="border-left: none;">(VNĐ) ${grandTotal}</td>
            </tr>
            </tbody>
        </table>

        <!-- Buttons -->
        <div class="cart-actions">
            <button class="btn" onclick="location.href='checkout'">Checkout</button>
            <button class="btn" onclick="location.href='books'">Continue shopping</button>
        </div>
    </main>
</div>

</body>
</html>