<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <h1>HTML For Example with File Upload</h1>
    <form style="border: 1px solid black; padding: 5px" action="${pageContext.request.contextPath}/processFormUpload"
          method="post" enctype="multipart/form-data">
        <div style="margin-bottom: 20px">
            <label>Name:</label>
            <input type="text" name="name" value="Nguyễn Phước Thịnh">
        </div>
        <div style="margin-bottom: 20px">
            <label>Password:</label>
            <input type="password" name="password" value="passwordne">
        </div>

        <div style="margin-bottom: 20px">
            <span>Gender:</span>
            <input type="radio" name="gender" value="male" checked>
            <label>Male</label>

            <input type="radio" name="gender" value="female">
            <label>Female</label>
        </div>
        <div style="margin-bottom: 20px">
            <label>Hobbies:</label>
            <input type="checkbox" name="hobbies" value="Reading"> Reading
            <input type="checkbox" name="hobbies" value="Sport"> Sport
            <input type="checkbox" name="hobbies" value="Music"> Music
        </div>
        <div style="margin-bottom: 20px">
            <label>Country:</label>
            <select name="country">
                <option selected value="Vietname">Vietname</option>
                <option value="English">English</option>
                <option value="China">China</option>
                <option value="Japan">Japan</option>
                <option value="Spain">Spain</option>
            </select>
        </div>
        <div style="margin-bottom: 20px">
            <label>Birth Date:</label>
            <input type="date" name="birth-date">
        </div>

        <div style="margin-bottom: 20px">
            <label>Profile Picture:</label>
            <input type="file" name="profile-picture">
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>