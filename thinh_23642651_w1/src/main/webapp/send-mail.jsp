<%--
  Created by IntelliJ IDEA.
  User: THIS PC
  Date: 8/19/2026
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/send-mail" method="POST" enctype="multipart/form-data">

    <label for="receiver">Người nhận:</label>
    <input type="email" id="receiver" name="receiver" value="nguyenphuocthinh0710@gmail.com" width="200"><br>

    <label for="subject">Tiêu đề:</label>
    <input type="text" id="subject" name="subject" value="Lập trình WWW"><br>

    <label for="content">Nội dung:</label><br>
    <textarea id="content" name="content" rows="10" cols="60"></textarea><br>

    <label for="attachment">File đính kèm:</label>
    <input type="file" id="attachments" name="attachments"><br>

    <button type="submit" >Gửi mail</button>

</form>
</body>
</html>
