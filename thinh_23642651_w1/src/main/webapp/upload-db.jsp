<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>File Upload to Database</title>
</head>
<body>

<h1 style="text-align: center;">
  File Upload to Database<br>
  (multipart/form-data)
</h1>

<form action="${pageContext.request.contextPath}/uploadDb" method="post" enctype="multipart/form-data">

  First Name:
  <input type="text" name="firstName">
  <br>

  Last Name:
  <input type="text" name="lastName">
  <br>

  Portrait Photo:
  <input type="file" name="portraitPhoto">
  <br>

  <button type="submit">Save</button>

</form>

</body>
</html>