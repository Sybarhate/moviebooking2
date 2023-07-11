<%@ page import="com.example.moviebooking2.model.State" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.City" %><%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 21-06-2023
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous">
</script>
<head>
    <title>Add Cinema Details</title>
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
    <script>

        $(document).on('change','#stateId',function(){
            var stateId=$(this).val();

            //get current address bar URL
            const currURL=new URL($(location).attr('href'));

            //clear existing query string value and append query string stateId and providevalue of dropdown sel
            currURL.searchParams.set("stateID",stateId)

            //replace and trigger address BAR url with this new URL
            location.replace(currURL.toString());
        });
    </script>
</head>
<body>
<div class="container">
    <h2>Add new Cinema</h2>

    <form action="add" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="id">

        <label for="image">Image:</label>
        <input type="file" id="image" name="image">

        <label for="name">Name:</label>
        <input type="text" name="name" id="name">
        <br>

        <label for="stateId">State:</label>
        <select id="stateId" name="stateId">
            <option value="" disabled selected>Select a state</option>
            <% List<State> states = (List<State>) request.getAttribute("State");
                for (State state : states) { %>
            <option value="<%= state.getStateId() %>"><%= state.getStateName() %></option>
            <% } %>
        </select>
        <br>
        <label for="cityId">City:</label>
        <select id="cityId" name="cityId">
            <option value="" disabled selected>Select a city</option>

            <%
            if (request.getAttribute("City") != null){
                List<City> cities = (List<City>) request.getAttribute("City");
                for (City city : cities) { %>
            <option value="<%= city.getCityId() %>"><%= city.getCityName() %></option>
            <% }
            }%>
        </select>

        <br>

        <label for="address">Address:</label>
        <textarea name="address" id="address" rows="4"></textarea>
        <br>
        <br>

        <label for="pincode">Pincode:</label>
        <input type="text" name="pincode" id="pincode">
        <br>
        <br>

        <input type="submit" value="ADD">
    </form>

</div>
</body>
</html>