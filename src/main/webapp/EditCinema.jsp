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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script>

        $(document).on('change', '#stateId', function () {
            var stateId = $(this).val();

            //get current address bar URL
            const currURL = new URL($(location).attr('href'));

            //clear existing query string value and append query string stateId and providevalue of dropdown sel
            currURL.searchParams.set("stateID", stateId)

            //replace and trigger address BAR url with this new URL
            location.replace(currURL.toString());
        });
    </script>

    <script>
        $(document).ready(function () {
            populateFormData();
            $("form").submit(function (event) {

            });
        });

        function populateFormData() {
            var stateId = sessionStorage.getItem("stateId");
            document.getElementById("stateId").value = stateId;
        }

        function saveFormData() {
            var stateId = document.getElementById("stateId").value;
            sessionStorage.setItem("stateId", stateId);
        }

        // Call the saveFormData function whenever form values change
        $(document).on('input', '#form input, #form select', function () {
            saveFormData();
        });
    </script>
    <%--    <script>--%>
    <%--        $(document).ready(function() {--%>
    <%--            var selectedStateId = <%= (int) request.getAttribute("stateID") %>;--%>
    <%--            $('#stateId').val(selectedStateId);--%>
    <%--        });--%>
    <%--    </script>--%>
    <%--    <script>--%>
    <%--        $(document).ready(function() {--%>
    <%--            var selectedStateId = <%= (int) request.getAttribute("stateID") %>;--%>
    <%--            $('#stateId').val(selectedStateId);--%>
    <%--        });--%>
    <%--    </script>--%>

</head>
<body>

<h2>Edit Cinema Information</h2>
<form action="edit" method="POST" id="form" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${cinemaId}">
    <label for="name">Name:</label>

    <input type="file" name="img" id="img" value="${cinemaImage}">

    <input type="text" name="name" id="name" value="${cinemaName}">
    <br>
    <label for="address">Address:</label>
    <input type="text" name="address" id="address" value="${cinemaAddress}">
    <br>
    <label for="stateId">State:</label>
    <select id="stateId" name="stateId">
        <option>Select a state</option>
        <% List<State> states = (List<State>) request.getAttribute("State");
            for (State state : states) {
                String selected = (state.getStateId() == (int) request.getAttribute("stateid")) ? "selected" : "";
        %>
        <option value="<%= state.getStateId() %>"<%=selected%>><%= state.getStateName() %>
        </option>
        <% } %>
    </select>

    <br>
    <label for="cityId">City:</label>
    <select id="cityId" name="cityId">
        <option>Select a city</option>
        <%
            if (request.getAttribute("City") != null) {
                List<City> cities = (List<City>) request.getAttribute("City");
                for (City city : cities) {
                    String selected = (city.getCityId() == (int) request.getAttribute("cityID")) ? "selected" : "";
        %>
        <option value="<%= city.getCityId() %>"<%=selected%>><%= city.getCityName() %>
        </option>
        <% }
        }%>
    </select>
    <%--    <label for="city">City:</label>--%>
    <%--    <input type="text" name="city" id="city" value="${cinemaCity}">--%>
    <%--    <br>--%>
    <%--    <label for="state">State:</label>--%>
    <%--    <input type="state" name="state" id="state" value="${cinemaState}">--%>
    <%--    <br>--%>
    <input type="submit" value="Update">
</form>

<form action="delete" method="POST" onsubmit="return confirm('Are you sure you want to delete this cinema?');">
    <input type="hidden" name="id" value="${cinemaId}">
</form>

</body>
</html>
