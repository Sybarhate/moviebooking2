<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 04-07-2023
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Movie Details</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-top: 0;
            margin-bottom: 20px;
            color: #333333;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #555555;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        button[type="submit"] {
            width: 100%;
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Edit Movie Details</h1>
    <form action="edit-movie" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${id}">
        <input type="hidden" name="cinemaId" value="${cinemaId}">
        <input type="file" name="movieImg" id="movieImg" value="${movieImg}">
        <label for="edit-title">Title:</label>
        <input type="text" name="title" id="edit-title" value="${title}">
        <br>
        <label for="edit-duration">Duration:</label>
        <input type="text" name="duration" id="edit-duration" value="${duration}">
        <br>
        <label for="edit-releasedDate">Released Date:</label>
        <input type="text" name="releasedDate" id="edit-releasedDate" value="${releasedDate}">
        <br>
        <br>
        <label for="edit-directorName">Director Name:</label>
        <input type="text" name="directorName" id="edit-directorName" value="${directorName}">
        <br>
        <br>
        <label for="edit-producerName">Producer Name:</label>
        <input type="text" name="producerName" id="edit-producerName" value="${producerName}">
        <br>
        <br>
        <label for="edit-language">Language:</label>
        <input type="text" name="language" id="edit-language" value="${language}">
        <br>
        <br>
        <button type="submit">Update</button>
    </form>
</div>
<%--    <form action="delete" method="POST" onsubmit="return confirm('Are you sure you want to delete this screen?');">--%>
<%--        <input type="hidden" name="movieid" value="${id}">--%>
<%--        <input type="submit" value="Delete">--%>
<%--    </form>--%>
</div>
</body>
</html>


