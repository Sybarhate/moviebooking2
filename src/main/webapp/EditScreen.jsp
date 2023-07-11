<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 03-07-2023
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 27-06-2023
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.moviebooking2.model.Cinema" %>
<%@ page import="com.example.moviebooking2.model.State" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Edit Cinema Information</title>--%>
<%--    <!-- Add your CSS styling or include external CSS files here -->--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Edit Cinema Information</h2>--%>

<%--&lt;%&ndash; Retrieve the cinema ID from the request parameters &ndash;%&gt;--%>
<%--<% String cinemaId = request.getParameter("id"); %>--%>

<%--&lt;%&ndash; Use the cinema ID to fetch the cinema details from the database &ndash;%&gt;--%>
<%--&lt;%&ndash; Replace the following code with your own implementation to retrieve cinema details &ndash;%&gt;--%>
<%--&lt;%&ndash; Example: Fetch cinema details using CinemaDao or any other data access mechanism &ndash;%&gt;--%>
<%--&lt;%&ndash; CinemaDao cinemaDao = new CinemaDao(); &ndash;%&gt;--%>
<%--&lt;%&ndash; Cinema cinema = cinemaDao.getCinemaById(cinemaId); &ndash;%&gt;--%>
<%--&lt;%&ndash; Replace the example cinema object with your actual cinema object &ndash;%&gt;--%>
<%--&lt;%&ndash; Cinema cinema = ...; &ndash;%&gt;--%>

<%--&lt;%&ndash; Display a form with pre-filled fields for editing cinema information &ndash;%&gt;--%>
<%--&lt;%&ndash; Replace the following form fields with the appropriate cinema attributes &ndash;%&gt;--%>
<%--<form action="update.jsp" method="POST">--%>
<%--    <input type="hidden" name="id" value="<%= cinemaId %>">--%>
<%--    <label for="name">Name:</label>--%>
<%--    <input type="text" name="name" id="name" value="<%= cinema.getName() %>">--%>
<%--    <br>--%>
<%--    <label for="address">Address:</label>--%>
<%--    <input type="text" name="address" id="address" value="<%= cinema.getAddress() %>">--%>
<%--    <br>--%>
<%--    <input type="submit" value="Update">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Cinema Information</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous">
    </script>
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

        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px 10px;
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
<h2>Edit Screen Details</h2>
<form action="edit-screen" method="POST">
    <input type="hidden" name="cinemaId" value="${cinemaId}">
    <input type="hidden" name="id" value="${screenId}">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" value="${screenName}">
    <br>
    <label for="noOfRows">Rows:</label>
    <input type="text" name="noOfRows" id="noOfRows" value="${noOfRows}"readonly>
    <br>
    <br>
    <label for="noOfCols">Rows:</label>
    <input type="text" name="noOfCols" id="noOfCols" value="${noOfCols}"readonly>
    <br>
    <input type="submit" value="Update">
    <%--        <input type="submit" value="Delete">--%>
</form>
<form action="delete" method="POST" onsubmit="return confirm('Are you sure you want to delete this screen?');">
    <input type="hidden" name="id" value="${screenId}">
</form>

</body>
</html>
