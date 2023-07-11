<%@ page import="com.example.moviebooking2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 21-06-2023
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Verification Code Form</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f1f1f1;
        }

        .form-container {
            text-align: center;
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 300px;
            padding: 5px;
        }

        .resend-link {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Verification Code Form</h2>
    <form action="verification"method="Post">
        <div class="form-group">
            <label for="verification-code">Verification Code:</label>
            <input type="text" id="verification-code" name="verification-code" required>
        </div>

<%--        <input type="hidden" id="userId" name="verificationCode" value="<%=((User)request.getAttribute("user")).getUserId()%>">--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>
        <input type="hidden" name="userId" value="<%=(request.getAttribute("user"))%>">
    <div class="resend-link">
        <input type="submit" value="Sign Up">

<%--        <a href="#" style="color: #007bff;">Resend Code</a>--%>
    </div>
</div>
</body>
</html>

