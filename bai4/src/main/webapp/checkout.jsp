<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/14/2026
  Time: 9:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Checkout</title>
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
            background: url('${pageContext.request.contextPath}/images/background-header.jpg') no-repeat center center;
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

        /* Checkout Form Container */
        .checkout-container {
            flex: 1;
        }

        .checkout-title {
            text-align: center;
            font-size: 13px;
            color: #666;
            margin-bottom: 8px;
        }

        .checkout-table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #333;
            font-size: 13px;
        }

        .checkout-table td {
            border: 1px solid #ccc;
            padding: 10px 15px;
            vertical-align: middle;
        }

        .checkout-table td.label-col {
            width: 180px;
            color: #555;
            background-color: #fff;
        }

        .input-text {
            width: 200px;
            padding: 4px 6px;
            border: 1px solid #777;
            border-radius: 4px;
            background-color: #eee;
            outline: none;
        }

        .input-text.long {
            width: 320px;
        }

        .radio-group {
            display: flex;
            align-items: center;
            gap: 15px;
            color: #555;
        }

        .radio-group label {
            display: flex;
            align-items: center;
            gap: 4px;
            cursor: pointer;
        }

        .form-actions {
            text-align: center;
            padding: 12px !important;
            background-color: #fff;
        }

        .btn {
            padding: 4px 12px;
            font-size: 12px;
            background-color: #f0f0f0;
            border: 1px solid #999;
            border-radius: 3px;
            cursor: pointer;
            color: #333;
            margin: 0 3px;
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

    <!-- Main Content: Checkout Form -->
    <main class="checkout-container">
        <div class="checkout-title">Checkout - Already registered? ...</div>

        <form action="${pageContext.servletContext.contextPath}/checkout" method="post">
            <table class="checkout-table">
                <tr>
                    <td class="label-col">Fullname:</td>
                    <td>
                        <input type="text" name="fullname" class="input-text" required />
                    </td>
                </tr>
                <tr>
                    <td class="label-col">Shipping address:</td>
                    <td>
                        <input type="text" name="address" class="input-text long" required />
                    </td>
                </tr>
                <tr>
                    <td class="label-col">Total price:</td>
                    <td>
                        <input type="text" name="totalPrice" class="input-text" value="${totalPrice}" readonly />
                    </td>
                </tr>
                <tr>
                    <td class="label-col">Payment method</td>
                    <td>
                        <div class="radio-group">
                            <label><input type="radio" name="paymentMethod" value="Paypal" checked /> Paypal</label>
                            <label><input type="radio" name="paymentMethod" value="ATM" /> ATM Debit</label>
                            <label><input type="radio" name="paymentMethod" value="VisaMaster" /> Visa/Master card</label>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="form-actions">
                        <button type="submit" class="btn">Save</button>
                        <button type="button" class="btn" onclick="location.href='cart'">Cancel</button>
                    </td>
                </tr>
            </table>
        </form>
    </main>
</div>

</body>
</html>