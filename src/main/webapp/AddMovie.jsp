<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 04-07-2023
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Movie Details</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-top: 0;
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"], select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<div class="container">
    <h1>Add Movie Details</h1>
    <form action="add-movie" method="post" enctype="multipart/form-data">
        <input type="hidden" name="cinemaId" value="${cinemaId}">

        <input type="hidden" id="id" name="id">
        <label for="image">Image:</label>
        <input type="file" id="image" name="image">

        <label for="title">Title:</label>
        <input type="text" id="title" name="title">

        <label for="duration">Duration:</label>
        <input type="text" id="duration" name="duration">

        <label for="releasedDate">Released Date:</label>
        <input type="text" id="releasedDate" name="releasedDate">

        <label for="directorName">Director Name:</label>
        <input type="text" id="directorName" name="directorName">

        <label for="producerName">Producer Name:</label>
        <input type="text" id="producerName" name="producerName">

        <label for="language">Language:</label>
        <input type="text" id="language" name="language">

        <input type="hidden" id="cinemaId" name="cinemaId">

        <button type="submit">Add Movie</button>
    </form>
</div>
</body>
</html>
