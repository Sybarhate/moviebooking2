<%@ page import="com.example.moviebooking2.model.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.Cinema" %><%--<%@ page import="com.example.moviebooking2.model.Cinema" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.example.moviebooking2.model.Movie" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: bsakshi--%>
<%--  Date: 04-07-2023--%>
<%--  Time: 09:31--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Management</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 4px;
            padding: 20px;
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

        select, button {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            margin-bottom: 10px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
        #addMovieBtn:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--    <script>--%>

<%--        $(document).on('change','#cinema',function(){--%>
<%--            var cinemaId=$(this).val();--%>

<%--            //get current address bar URL--%>
<%--            const currURL=new URL($(location).attr('href'));--%>

<%--            //clear existing query string value and append query string stateId and providevalue of dropdown sel--%>
<%--            currURL.searchParams.set("cinemaId",cinemaId)--%>

<%--            //replace and trigger address BAR url with this new URL--%>
<%--            location.replace(currURL.toString());--%>
<%--        });--%>
<%--    </script>--%>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            populateFormData();--%>
<%--            $("form").submit(function (event) {--%>
<%--            });--%>
<%--        });--%>
<%--        function populateFormData() {--%>
<%--            var cinema = sessionStorage.getItem("cinema");--%>
<%--            document.getElementById("cinema").value = cinema;--%>
<%--        }--%>
<%--        function saveFormData() {--%>
<%--            var cinema = document.getElementById("cinema").value;--%>
<%--            sessionStorage.setItem("cinema", cinema);--%>
<%--        }--%>

<%--        // Call the saveFormData function whenever form values change--%>
<%--        $(document).on('input', '#form input, #form select', function () {--%>
<%--            saveFormData();--%>
<%--        });--%>
<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <form id="form">--%>
<%--    <h1>Movie Management</h1>--%>
<%--    <label for="cinema">Select Cinema:</label>--%>
<%--    <select id="cinema" name="cinema">--%>
<%--        <option value="" disabled selected>Select a cinema</option>--%>
<%--        <% List<Cinema> cinemas = (List<Cinema>) request.getAttribute("Cinema");--%>
<%--            if (cinemas != null && !cinemas.isEmpty()) {--%>
<%--                for (Cinema cinema : cinemas) { %>--%>
<%--        <option value="<%= cinema.getId() %>"><%= cinema.getName() %></option>--%>
<%--        <%  }--%>
<%--        } %>--%>
<%--    </select>--%>

<%--    <button>Add Movie</button>--%>

<%--    <table>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Title</th>--%>
<%--            <th>Duration</th>--%>
<%--            <th>Released Date</th>--%>
<%--            <th>Director Name</th>--%>
<%--            <th>Producer Name</th>--%>
<%--            <th>Language</th>--%>
<%--            <th>Edit</th>--%>
<%--            <th>Delete</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <% List<Movie> movies = (List<Movie>) request.getAttribute("Movie");--%>
<%--            if (movies != null && !movies.isEmpty()) {--%>
<%--                for (Movie movie : movies) { %>--%>
<%--        <tr>--%>
<%--            <td><%=movie.getId()%></td>--%>
<%--            <td><%=movie.getTitle()%> </td>--%>
<%--            <td><%=movie.getDuration() %> </td>--%>
<%--            <td><%=movie.getReleasedDate() %> </td>--%>
<%--            <td><%=movie.getDirectorName() %> </td>--%>
<%--            <td><%=movie.getProducerName() %> </td>--%>
<%--            <td><%=movie.getMovieLanguage() %> </td>--%>
<%--            <td><a href="edit-movie?id=<%= movie.getId()%>">Edit</a></td>--%>
<%--            <td><a href="delete-movie?id=<%=movie.getId()%>">Delete</a></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        } else {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td colspan="5">No cinema details available.</td>--%>
<%--        </tr>--%>
<%--        <% } %><!-- Screens will be populated here dynamically -->--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--        </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>

        $(document).on('change','#cinema',function(){
            var cinemaId=$(this).val();

            //get current address bar URL
            const currURL=new URL($(location).attr('href'));

            //clear existing query string value and append query string stateId and providevalue of dropdown sel
            currURL.searchParams.set("cinemaId",cinemaId)

            //replace and trigger address BAR url with this new URL
            location.replace(currURL.toString());
        });
    </script>
    <script>
        $(document).ready(function () {
            populateFormData();
            $("#addMovieFormAction").submit(function (event) {
                const currURL = new URL($(location).attr('href'));
                $('input[name="cinemaId"]').val(currURL.searchParams.get("cinemaId"));
            });

            // Retrieve the selected value from session storage and set it in the dropdown list
            function populateFormData() {
                var cinema = sessionStorage.getItem("cinema");
                if (cinema) {
                    $("#cinema").val(cinema);
                }
            }

            // Save the selected value in session storage whenever form values change
            $(document).on('change', '#cinema', function () {
                var cinema = $(this).val();
                sessionStorage.setItem("cinema", cinema);
            });
        });
    </script>

</head>
<body>
<div class="container">
<%--    <form id="form">--%>
    <form action="add-movie" id="addMovieFormAction">
        <h2>Movie Management</h2>
        <div class="movie-management">
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
        </div>
        <div class="links">
<%--            <a href="add-movie?cinemaId="+cinemaId>Add movie</a>--%>
<%--                    <form action="add-movie?cinemaId="+cinemaId>--%>
<%--&lt;%&ndash;                        <input type="hidden" name=cinemaId value=cinemaId>&ndash;%&gt;--%>
<%--                        <button type="submit"  class="add-movie" >Add Movie</button>--%>
<%--                    </form>--%>


        <input type="hidden" name="cinemaId" id="cinemaId">
        <button type="submit" class="add-button" id="addMovieBtn" >Add Movie</button>
    </form>

        </div>
<table id="movieTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Image</th>
            <th>Title</th>
            <th>Duration</th>
            <th>Released Date</th>
            <th>Director Name</th>
            <th>Producer Name</th>
            <th>Language</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
    <tbody>
    <% List<Movie> movies = (List<Movie>) request.getAttribute("Movie");
        if (movies != null && !movies.isEmpty()) {
            for (Movie movie : movies) { %>
    <tr>
        <td><%=movie.getId()%></td>
        <td><img src="<%=movie.getImage()%>" alt="No Image" width="80px" height="80px"></td>
        <td><%=movie.getTitle()%> </td>
        <td><%=movie.getDuration() %> </td>
        <td><%=movie.getReleasedDate() %> </td>
        <td><%=movie.getDirectorName() %> </td>
        <td><%=movie.getProducerName() %> </td>
        <td><%=movie.getMovieLanguage() %> </td>
        <td><a href="edit-movie?id=<%= movie.getId()%>">Edit</a></td>
        <td><a href="delete-movie?id=<%=movie.getId()%>">Delete</a></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No cinema details available.</td>
    </tr>
    <% } %><!-- Screens will be populated here dynamically -->
    </tbody>
</table>
<%--    </form>--%>

</div>
</body>
</html>