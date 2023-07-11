<%@ page import="com.example.moviebooking2.model.Screen" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.Movie" %>
<%@ page import="com.example.moviebooking2.model.Cinema" %><%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 10-07-2023
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
    <style>
        .form-group {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            margin-bottom: 10px;
        }

        .form-group label {
            flex-basis: 100px;
            margin-right: 10px;
        }

        .form-group select,
        .form-group input[type="date"],
        .form-group input[type="time"] {
            width: 200px;
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .form-group .date-group {
            display: flex;
            align-items: center;
        }

        .form-group .date-group label {
            margin-right: 10px;
        }

        .form-group .date-group input[type="date"],
        .form-group .date-group input[type="time"] {
            width: 150px;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>

</head>
<body>
<div class="form-group">
    <label for="cinema">Cinema:</label>
    <select id="cinema" name="cinema">
        <option value="" disabled selected>Select a cinema</option>
        <% List<Cinema> cinemas = (List<Cinema>) request.getAttribute("Cinema");
            if (cinemas != null && !cinemas.isEmpty()) {
                for (Cinema cinema : cinemas) { %>
        <option value="<%= cinema.getId() %>"><%= cinema.getName() %></option>
        <%  }
        } %>
    </select>

    <label for="movie">Movie:</label>
    <select id="movie" name="movie">
        <option value="" disabled selected>Select a movie</option>
        <% List<Movie> movies = (List<Movie>) request.getAttribute("Movie");
            if (movies != null && !movies.isEmpty()) {
                for (Movie movie : movies) { %>
        <option value="<%= movie.getId() %>"><%= movie.getTitle() %></option>
        <%  }
        } %>
    </select>

    <label for="screen">Screen:</label>
    <select id="screen" name="screen">
        <option value="" disabled selected>Select a screen</option>
        <% List<Screen> screens = (List<Screen>) request.getAttribute("Screen");
            if (screens != null && !screens.isEmpty()) {
                for (Screen screen : screens) { %>
        <option value="<%= screen.getScreenId() %>"><%= screen.getName() %></option>
        <%  }
        } %>
    </select>
</div>

<div class="form-group">
    <div class="date-group">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate">
    </div>

    <div class="date-group">
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate">
    </div>

    <div class="date-group">
        <label for="startTime">Start Time:</label>
        <input type="time" id="startTime" name="startTime">
    </div>

    <div class="date-group">
        <label for="endTime">End Time:</label>
        <input type="time" id="endTime" name="endTime">
    </div>
</div>

<button id="addButton">Add</button>

</body>
</html>
