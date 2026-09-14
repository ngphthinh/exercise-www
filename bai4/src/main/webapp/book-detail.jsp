<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/14/2026
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Product Details</title>
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
            /* Đường dẫn tới ảnh nền header */
            background: url('${pageContext.request.contextPath}/images/background-header.jpg') no-repeat center center;
            background-size: cover;
            background-color: #7a6a58; /* Color fallback */
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
        }

        /* Product Detail Main Content */
        .product-detail-container {
            flex: 1;
        }

        .detail-title {
            font-size: 14px;
            color: #666;
            margin-bottom: 20px;
        }

        .detail-image {
            width: 200px;
            height: 280px;
            object-fit: cover;
            margin-bottom: 15px;
            display: block;
        }

        .detail-info {
            font-size: 13px;
            color: #555;
            line-height: 1.6;
        }

        .back-link {
            display: inline-block;
            margin-top: 25px;
            color: #333;
            text-decoration: underline;
            font-size: 13px;
        }

        .back-link:hover {
            color: #000;
        }
    </style>
</head>
<body>

<!-- Header / Navigation -->
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

    <!-- Main Content: Chi tiết sản phẩm -->
    <main class="product-detail-container">
        <!-- Tiêu đề chi tiết sản phẩm -->
        <div class="detail-title">
            Product details: ${book.title} <c:if test="${not empty book.author}">- Tác giả: ${book.author}</c:if>
        </div>

        <!-- Ảnh sách -->
        <img src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title}" class="detail-image"/>

        <!-- Thông tin Giá & Số lượng -->
        <div class="detail-info">
            <p>Price (VNĐ): ${book.price}</p>
            <p>Quantity: ${book.quantity}</p>
        </div>

        <!-- Đường dẫn quay lại danh sách -->
        <a href="${pageContext.request.contextPath}/books" class="back-link">Back to Product List</a>
    </main>
</div>

</body>
</html>