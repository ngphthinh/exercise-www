<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <h1>Nhập thông tin sản phẩm</h1>
    <form action="${pageContext.request.contextPath}/product" enctype="multipart/form-data" method="post">
        <input
                type="text"
                name="product-name" placeholder="Enter product name"
                value="Product-01"
        /> <br/>
        <input
                type="number" name="price" placeholder="Enter price"
                value="100"
        /> <br/>
        Image:
        <input
                type="file" name="url-img"
        /> <br/>
        Category:
        <select name="category">
            <option value="Phone" selected>Phone</option>
            <option value="Tablet">Tablet</option>
            <option value="Laptop">Laptop</option>
            <option value="PC">PC</option>
        </select> <br/>
        Available:
        <input
                type="radio"
                name="is-available"
                value="yes" checked
        /> Yes
        <input
                type="radio"
                name="is-available"
                value="no"
        /> No <br/>
        <input type="date" placeholder="Enter expiry date" name="expiry-date"/> <br/>
        <textarea name="description" placeholder="Enter description">
        Hahi baba
        </textarea>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>