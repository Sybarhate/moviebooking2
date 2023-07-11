<%@ page import="com.example.moviebooking2.model.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.exception.Error" %><%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 16-06-2023
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sign Up Form</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 400px;
            margin: 0 auto;
            padding: 40px;
            background-color: #f9f9f9;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4caf50;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .login-link {
            margin-top: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Sign Up</h2>
    <div class="errorList">
        <%
            List<Error> errorList = (List<Error>) request.getAttribute("errorList");
            if (errorList != null && !errorList.isEmpty()) {
        %>
        <ul>
            <% for (Error error : errorList) { %>
         <div>   <li><%= error.getMessage() %></li>
         </div>            <% } %>
        </ul>
        <% } %>
    </div>

    <form action="registration-form" method="Post">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" >
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" >
        </div>
        <div class="form-group">
            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" >
        </div>
        <div class="form-group">
            <label for="mobileNumber">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" >
        </div>
        <div class="form-group">
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="text" id="dateOfBirth" name="dateOfBirth" >
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" >
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <textarea id="address" name="address" ></textarea>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" >
        </div>
        <div class="form-group">
            <label for="roleId">Role:</label>
            <select id="roleId" name="roleId" >
                <option value="" disabled selected>Select your role here</option>
                <% List<Role> role1 = (List<Role>) request.getAttribute("Role");
                    for (Role role : role1) { %>
                <option value="<%= role.getRoleId() %>"><%= role.getRoleName() %>
                </option>
                <% } %>
            </select>
        </div>

        <input type="submit" value="Sign Up">
        <div class="login-link">
            Already have an account? <a href="login.jsp">Login</a>
        </div>
    </form>
</div>
</body>
</html>
