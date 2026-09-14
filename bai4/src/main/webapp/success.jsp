<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/14/2026
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Order Confirmation</title>
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

    /* Success Message Box */
    .success-container {
      flex: 1;
      padding: 20px;
      border: 1px solid #ccc;
      background-color: #f9f9f9;
    }

    .success-title {
      font-size: 18px;
      color: #2e7d32;
      margin-bottom: 15px;
      font-weight: bold;
    }

    .order-info-table {
      width: 100%;
      border-collapse: collapse;
      font-size: 13px;
      margin-top: 15px;
    }

    .order-info-table td {
      padding: 8px 0;
      color: #555;
    }

    .order-info-table td.label-col {
      width: 150px;
      font-weight: bold;
    }

    .btn {
      display: inline-block;
      margin-top: 20px;
      padding: 6px 14px;
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
  </aside>

  <!-- Main Content: Success Message -->
  <main class="success-container">
    <h2 class="success-title">Thank you for your order!</h2>
    <p style="font-size: 13px; color: #555;">Your order has been placed successfully. Below are your order details:</p>

    <table class="order-info-table">
      <tr>
        <td class="label-col">Fullname:</td>
        <td>${param.fullname}</td>
      </tr>
      <tr>
        <td class="label-col">Shipping Address:</td>
        <td>${param.address}</td>
      </tr>
      <tr>
        <td class="label-col">Total Price:</td>
        <td>(VNĐ) ${param.totalPrice}</td>
      </tr>
      <tr>
        <td class="label-col">Payment Method:</td>
        <td>${param.paymentMethod}</td>
      </tr>
    </table>

    <a href="books" class="btn">Continue shopping</a>
  </main>
</div>

</body>
</html>