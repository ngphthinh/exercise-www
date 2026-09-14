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
    <title>Book list</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%;
            height: 120px;
            padding: 0 40px;
            /* Replace 'background-header.jpg' with your actual header image path */
            background-color: #ff7100;
            background-size: cover;
        }

        .brand {
            font-size: 28px;
            font-weight: bold;
            color: #ffffff;
            background-color: rgba(90, 90, 90, 0.6);
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            letter-spacing: 1px;
        }

        .nav-links {
            display: flex;
            gap: 12px;
            list-style: none;
        }

        .nav-links a {
            display: block;
            color: #ffffff;
            text-decoration: none;
            background-color: rgba(90, 90, 90, 0.6);
            padding: 8px 16px;
            border-radius: 4px;
            font-size: 13px;
            font-weight: bold;
            text-transform: uppercase;
            transition: background-color 0.2s ease;
        }

        .nav-links a:hover {
            background-color: rgba(60, 60, 60, 0.8);
        }

        .container {
            display: flex;
            max-width: 1100px;
            margin: 20px auto;
            padding: 0 15px;
            gap: 20px;
        }

        /* Sidebar Styles */
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

        /* Product Grid Styles */
        .product-grid {
            flex: 1;
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 15px;
        }

        .product-card {
            border: 1px solid #333;
            padding: 10px;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
        }

        .product-title {
            font-size: 13px;
            color: #666;
            margin-bottom: 10px;
            height: 36px;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }

        .product-image {
            width: 140px;
            height: 190px;
            object-fit: cover;
            margin-bottom: 10px;
        }

        .product-info {
            font-size: 13px;
            color: #555;
            line-height: 1.5;
        }

        .product-info a {
            color: #555;
            text-decoration: underline;
        }

        .product-info a:hover {
            color: #000;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <a href="#" class="brand">IUH BOOKSTORE</a>
    <ul class="nav-links">
        <li><a href="#">HOME</a></li>
        <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
        <li><a href="#">SERVICES</a></li>
        <li><a href="#">PRODUCTS</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>
</nav>
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

    <!-- Main Product Grid -->
    <main class="product-grid">
        <c:forEach var="book" items="${books}">
            <div class="product-card">
                <div class="product-title">
                        ${book.title} <c:if test="${not empty book.author}">- Tác giả: ${book.author}</c:if>
                </div>

                <img src="${pageContext.request.contextPath}/images/${book.image}" alt="${book.title}"
                     class="product-image"/>

                <div class="product-info">
                    <p>Price: ${book.price}</p>
                    <p>Quantity: ${book.quantity}</p>
                    <p><a href="${pageContext.request.contextPath}/book?id=${book.bookId}">Product details</a></p>
                    <div>
                        <form action="${pageContext.request.contextPath}/cart" method="post">
                            <input type="hidden" name="action" value="add"/>
                            <input type="hidden" name="bookId" value="${book.bookId}"/>
                            <button type="submit">Add to cart</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </main>
</div>
<div>


</div>

</body>
</html>
