<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 8/20/2026
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Student-Result</title>
</head>
<body>
<h2>Student Information</h2>

<p><b>Name:</b> ${student.firstName} ${student.lastName}</p>

<p><b>Date of Birth:</b> ${student.dob}</p>

<p><b>Email:</b> ${student.email}</p>

<p><b>Mobile:</b> ${student.mobile}</p>

<p><b>Gender:</b> ${student.gender}</p>

<p><b>Address:</b> ${student.address}, ${student.city}, ${student.state}, ${student.country}</p>

<p><b>Course:</b> ${student.course}</p>

Hobbies:

<ul>

    <c:forEach var="h" items="${student.hobbies}">

        <li>${h}</li>

    </c:forEach>

</ul>
</body>
</html>
