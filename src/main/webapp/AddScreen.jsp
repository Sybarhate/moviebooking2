<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 03-07-2023
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<head>
    <title>Add Screen Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add Screen Details</h2>

    <form action="add-screen" method="post">
        <input type="hidden" name="cinemaId" value="${cinemaId}">
        <input type="hidden" name="id" id="id">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name">
        <br>
        <label for="noOfRows">Rows:</label>
        <textarea name="noOfRows" id="noOfRows"></textarea>
        <br>
        <br>
        <label for="noOfCols">Columns:</label>
        <textarea name="noOfCols" id="noOfCols"></textarea>
        <br>
        <input type="submit" value="ADD">
    </form>
</div>
</body>
</html>