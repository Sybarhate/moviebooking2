<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 27-06-2023
  Time: 10:07
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

<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.Cinema" %>
<%@ page import="com.example.moviebooking2.model.Address" %>
<%@ page import="com.example.moviebooking2.model.State" %>
<%@ page import="com.example.moviebooking2.model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Link and Table Design</title>--%>
<%--    <style>--%>
<%--        body, html {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f0f0f0;--%>
<%--            height: 100%;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--        }--%>

<%--        .container {--%>
<%--            width: 100%;--%>
<%--            height: 100%;--%>
<%--            background-color: #f9f9f9;--%>
<%--            border: 1px solid #cccccc;--%>
<%--            border-radius: 5px;--%>
<%--            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);--%>
<%--        }--%>

<%--        h2 {--%>
<%--            text-align: center;--%>
<%--            margin: 20px 0;--%>
<%--        }--%>

<%--        .links {--%>
<%--            text-align: center;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        .links a {--%>
<%--            display: inline-block;--%>
<%--            margin: 10px;--%>
<%--            padding: 10px 20px;--%>
<%--            background-color: #4caf50;--%>
<%--            color: #ffffff;--%>
<%--            text-decoration: none;--%>
<%--            border-radius: 4px;--%>
<%--        }--%>

<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>

<%--        th, td {--%>
<%--            padding: 10px;--%>
<%--            text-align: left;--%>
<%--            border-bottom: 1px solid #cccccc;--%>
<%--        }--%>

<%--        th {--%>
<%--            background-color: #f2f2f2;--%>
<%--            font-weight: bold;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h2>Cinema Management</h2>--%>
<%--    <div class="links">--%>
<%--        <a href="Screen Management.html">Screen Management</a>--%>
<%--        <a href="Add new Cinema.html">Add new Cinema</a>--%>
<%--    </div>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Address</th>--%>
<%--        </tr>--%>
<%--        <% List<Cinema> cinemas = (List<Cinema>) request.getAttribute("cinemas");--%>
<%--            if (cinemas != null && !cinemas.isEmpty()) {--%>
<%--                for (Cinema cinema : cinemas) { %>--%>
<%--        <tr>--%>
<%--            <td><%= cinema.getId() %></td>--%>
<%--            <td><%= cinema.getName() %></td>--%>
<%--            <td><%= cinema.getId()+ ", " + cinema.getName() + ", " + cinema.getAddressId() %></td>--%>
<%--        </tr>--%>
<%--        <% }--%>
<%--        } else { %>--%>
<%--        <tr>--%>
<%--            <td colspan="3">No cinema details available.</td>--%>
<%--        </tr>--%>
<%--        <% } %>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Link and Table Design</title>
    <style>
        body, html {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            height: 100%;
            background-color: #f9f9f9;
            border: 1px solid #cccccc;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin: 20px 0;
        }

        .links {
            text-align: center;
            margin-bottom: 20px;
        }

        .links a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            text-decoration: none;
            border-radius: 4px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #cccccc;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        .edit-col,
        .delete-col {
            text-align: center;
            vertical-align: middle;
        }

        .edit-col a,
        .delete-col a {
            display: block;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Cinema Management</h2>
    <div class="links">
        <a href="screen-management">Screen Management</a>
        <a href="add">Add new Cinema</a>
        <a href="movie-management">Movie Management</a>
        <a href="ShowManagement.jsp">Show Management</a>
    </div>
    <table>
        <tr>
            <th>ID</th>
            <th>Image</th>
            <th>Name</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <% List<Cinema> cinemas = (List<Cinema>) request.getAttribute("cinemas");
            if (cinemas != null && !cinemas.isEmpty()) {
                for (Cinema cinema : cinemas) { %>
        <tr>
            <td><%= cinema.getId() %></td>
            <td><img src="<%=cinema.getImage()%>" alt="No Image" width="80px" height="80px"></td>
            <td><%= cinema.getName() %></td>
<%--            <td><%=cinema.getAddress().getAddressLine() + ", " + cinema.getCity().getCityName() + ", " + cinema.getState().getStateName() %></td>--%>
            <td><%=cinema.getAddress().getAddressLine() %>
            <td><%= cinema.getCity().getCityName() %>
            <td><%= cinema.getState().getStateName() %></td>
            <td><a href="edit?id=<%= cinema.getId() %>">Edit</a></td>
            <td><a href="delete?id=<%= cinema.getId() %>">Delete</a></td>
        </tr>
        <% }
        } else { %>
        <tr>
            <td colspan="5">No cinema details available.</td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>

