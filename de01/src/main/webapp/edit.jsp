<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/9/2026
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/course/edit/${course.id}" method="post">
    <input placeholder="Nhập tên khóa học" name="courseName" value="${course.courseName}"/>
    <input placeholder="Nhập tên giảng viên" name="instructor" value="${course.instructor}"/>
    <input placeholder="Nhập tên danh mục" name="category" value="${course.category}"/>
    <input placeholder="Nhập tên giá" name="price" value="${course.price}"/>
    <input placeholder="Nhập thời gian học" name="duration" value="${course.duration}"/>
    <input placeholder="Ngày nhập học" name="startDate" type="date" value="${course.startDate}">
    Nổi bật
    <input type="radio" name="featured" value="true" checked="${course.featured}"> có
    <input type="radio" name="featured" value="false" checked="${!course.featured}"> không
    <button type="submit">Cap nhat</button>
</form>
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>
</body>
</html>
