
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.example.moviebooking2.model.Cinema" %>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"--%>
<%--            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="--%>
<%--            crossorigin="anonymous">--%>
<%--    </script>--%>
<%--    <script>--%>

<%--        $(document).on('change','#cinema',function(){--%>
<%--            var stateId=$(this).val();--%>

<%--            //get current address bar URL--%>
<%--            const currURL=new URL($(location).attr('href'));--%>

<%--            //clear existing query string value and append query string stateId and providevalue of dropdown sel--%>
<%--            currURL.searchParams.set("cinema",cinema)--%>

<%--            //replace and trigger address BAR url with this new URL--%>
<%--            location.replace(currURL.toString());--%>
<%--        });--%>
<%--    </script>--%>
<%--    <title>Cinema Screen Management</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            background-color: #f0f0f0;--%>
<%--        }--%>

<%--        .container {--%>
<%--            width: 100%;--%>
<%--            height: 100vh;--%>
<%--            display: flex;--%>
<%--            flex-direction: column;--%>
<%--            align-items: center;--%>
<%--            justify-content: flex-start;--%>
<%--            padding: 20px;--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        h2 {--%>
<%--            text-align: center;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        label {--%>
<%--            display: block;--%>
<%--            margin-bottom: 10px;--%>
<%--            font-weight: bold;--%>
<%--        }--%>

<%--        select, input {--%>
<%--            width: 200px;--%>
<%--            padding: 8px;--%>
<%--            border: 1px solid #cccccc;--%>
<%--            border-radius: 4px;--%>
<%--        }--%>

<%--        table {--%>
<%--            width: 100%;--%>
<%--            border-collapse: collapse;--%>
<%--            background-color: #ffffff;--%>
<%--            border: 1px solid #cccccc;--%>
<%--            margin-top: 10px;--%>
<%--        }--%>

<%--        th {--%>
<%--            padding: 8px;--%>
<%--            border-bottom: 1px solid #cccccc;--%>
<%--            background-color: #f9f9f9;--%>
<%--        }--%>

<%--        td {--%>
<%--            padding: 8px;--%>
<%--            border-bottom: 1px solid #cccccc;--%>
<%--        }--%>

<%--        .cinema-management {--%>
<%--            display: flex;--%>
<%--            justify-content: center;--%>
<%--            align-items: center;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        .cinema-management select {--%>
<%--            margin-right: 10px;--%>
<%--        }--%>

<%--        #addScreenBtn {--%>
<%--            padding: 10px 20px;--%>
<%--            background-color: #4caf50;--%>
<%--            color: #ffffff;--%>
<%--            border: none;--%>
<%--            border-radius: 4px;--%>
<%--            cursor: pointer;--%>
<%--        }--%>

<%--        #addScreenBtn:hover {--%>
<%--            background-color: #45a049;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h2>Cinema Screen Management</h2>--%>
<%--    <div class="screen-management">--%>
<%--        <label for="cinema">Cinema:</label>--%>
<%--        <select id="cinema" name="cinema">--%>
<%--            <option value="" disabled selected>Select a cinema</option>--%>
<%--            &lt;%&ndash; Loop to populate the cinemas dynamically &ndash;%&gt;--%>
<%--            <% List<Cinema> cinemas = (List<Cinema>) request.getAttribute("Cinema");--%>
<%--                if (cinemas != null && !cinemas.isEmpty()) {--%>
<%--                    for (Cinema cinema : cinemas) { %>--%>
<%--            <option value="<%= cinema.getId() %>"><%= cinema.getName() %></option>--%>
<%--            <%      }--%>
<%--            } %>--%>
<%--        </select>--%>

<%--        <button id="addScreenBtn">Add Screen</button>--%>
<%--    </div>--%>

<%--    <table id="screenTable">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Rows</th>--%>
<%--            <th>Columns</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <!-- Screen data will be dynamically added here -->--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.Cinema" %>
<%@ page import="com.example.moviebooking2.model.Screen" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cinema Screen Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }

        .container {
            width: 100%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            padding: 20px;
            box-sizing: border-box;
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

        select, input {
            width: 200px;
            padding: 8px;
            border: 1px solid #cccccc;
            border-radius: 4px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
            border: 1px solid #cccccc;
            margin-top: 10px;
        }

        /*th {*/
        /*    padding: 8px;*/
        /*    border-bottom: 1px solid #cccccc;*/
        /*    background-color: #f9f9f9;*/
        /*}*/

        /*td {*/
        /*    padding: 8px;*/
        /*    border-bottom: 1px solid #cccccc;*/
        /*}*/
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f2f2f2;
        }
        .screen-management {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }

        .screen-management select {
            margin-right: 10px;
        }

        #addScreenBtn {
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            align-items: center;
        }

        #addScreenBtn:hover {
            background-color: #45a049;
        }
        .edit-col a,
        .delete-col a {
            display: block;
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
        .screen-management {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap; /* Added */
            margin-bottom: 20px;
        }

        .links a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
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
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            populateFormData();--%>
<%--            $("#addScreenFormAction").submit(function (event) {--%>
<%--                //get current address bar URL--%>
<%--                const currURL=new URL($(location).attr('href'));--%>
<%--                // alert("Hello...");--%>
<%--                // alert(currURL.searchParams.get("cinemaId"));--%>
<%--                $('input[name="cinemaId"]').val(currURL.searchParams.get("cinemaId"));--%>
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
<%--</script>--%>
    <script>
        $(document).ready(function () {
            populateFormData();
            $("#addScreenFormAction").submit(function (event) {
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
<%--    <form id="addScreenFormAction">--%>
    <form action="add-screen" id="addScreenFormAction">
    <h2>Cinema Screen Management</h2>
    <div class="screen-management">
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
<%--          </form>--%>
    <div class="links">
<%--      <a href="add-screen?cinemaId="+cinemaId>Add Screen</a>--%>
<%--    <form action="add-screen" id="addScreenFormAction">--%>

            <input type="hidden" name="cinemaId" id="cinemaId">
            <button type="submit" class="add-button" id="addScreenBtn" >Add Screen</button>
        </form>

    </div>
    <table id="screenTable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Rows</th>
            <th>Columns</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        </thead>
        <tbody>

        <% List<Screen> screens = (List<Screen>) request.getAttribute("Screen");
            if (screens != null && !screens.isEmpty()) {
                for (Screen screen : screens) { %>
        <tr>
            <td><%= screen.getScreenId() %>
            </td>
            <td><%= screen.getName() %>
            </td>
            <%--            <td><%=cinema.getAddress().getAddressLine() + ", " + cinema.getCity().getCityName() + ", " + cinema.getState().getStateName() %></td>--%>
            <td><%=screen.getNoOfRows() %></td>
            <td><%=screen.getNoOfColumns() %></td>
            <td><a href="edit-screen?id=<%= screen.getScreenId()%>">Edit</a></td>
            <td><a href="delete-screen?id=<%=screen.getScreenId()%>">Delete</a></td>
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
