<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 9/9/2026
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<ul>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <li><a href="${pageContext.request.contextPath}/create">Thêm</a></li>
    </c:if>
    <li>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button>Logout</button>
        </form>
    </li>
</ul>
<div>
    <form action="${pageContext.request.contextPath}/search" method="get">
        <input placeholder="Search" name="search" value="${search}"/>
        <select>
            <option></option>

        </select>
        <button type="submit">Tìm kiếm</button>
    </form>

</div>
<table>
    <thead>
    <th>Mã</th>
    <th>tên khóa học</th>
    <th> giảng viên</th>
    <th>danh mục</th>
    <th>trình độ</th>
    <th>học phí</th>
    <th>thời lượng</th>
    <th>ngày khai giảng</th>
    <th>Nổi bật</th>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <th>Action</th>
    </c:if>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.courseName}</td>
            <td>${course.instructor}</td>
            <td>${course.category}</td>
            <td>${course.level}</td>
            <td>${course.price}</td>
            <td>${course.duration}</td>
            <td>${course.startDate}</td>
            <td><c:choose>
                <c:when test="${course.featured}">
                    Nổi bật
                </c:when>
                <c:otherwise>
                    Không nổi bật
                </c:otherwise>
            </c:choose></td>
            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                <td>
                    <form action="${pageContext.request.contextPath}/delete/${course.id}" method="get">
                        <button>Deleted</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/course/${course.id}" method="get">
                        <button>Detail</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/course/edit/${course.id}" method="get">
                        <button>Edit</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
