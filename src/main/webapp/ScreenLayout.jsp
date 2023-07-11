<%@ page import="java.util.List" %>
<%@ page import="com.example.moviebooking2.model.ScreenLayout" %>
<%@ page import="com.example.moviebooking2.model.Screen" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 06-07-2023
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Seat Layout</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Seat Layout</h1>--%>


<%--<%--%>
<%--    List<ScreenLayout> seatNumbers = (List<ScreenLayout>) request.getAttribute("seatNumber");--%>
<%--    Screen screen = (Screen) request.getAttribute("screenLayoutRowAndColumn");--%>
<%--%>--%>

<%--<% if (screen != null) { %>--%>
<%--<h3>Screen Layout for <%= screen.getName() %></h3>--%>
<%--<table>--%>
<%--    <% int seatIndex = 0;--%>
<%--        for (int row = 1; row <= screen.getNoOfRows(); row++) { %>--%>
<%--    <tr>--%>
<%--        <% for (int col = 1; col <= screen.getNoOfColumns(); col++) {--%>
<%--            String seatLabel = "";--%>
<%--            if (seatIndex < seatNumbers.size()) {--%>
<%--                ScreenLayout seat = seatNumbers.get(seatIndex);--%>
<%--                seatLabel = seat.getSeatNumber();--%>
<%--                seatIndex++;--%>
<%--            }--%>
<%--        %>--%>
<%--        <td><%= seatLabel %></td>--%>
<%--        <% } %>--%>
<%--    </tr>--%>
<%--    <% } %>--%>
<%--</table>--%>
<%--<% } else { %>--%>
<%--<p>No cinema details available.</p>--%>
<%--<% } %>--%>


<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html>
<head>
    <title>Seat Layout</title>
    <style>
        table {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }

        th {
            padding: 10px;
        }

        td {
            padding: 10px;
            border: 3px solid green;
            cursor: pointer;
        }

        td:hover {
            background-color: #90EE90;
        }

        td.booked {
            background-color: red;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            // Handle seat click event
            $('td').click(function () {
                $(this).toggleClass('booked');
            });
        });
    </script>
</head>
<body>
<h2 style="text-align: center;">Screen Layout</h2>

<%
    List<ScreenLayout> seatNumbers = (List<ScreenLayout>) request.getAttribute("seatNumber");
    Screen screen = (Screen) request.getAttribute("screenLayoutRowAndColumn");
%>

<% if (screen != null) { %>
<h3 style="text-align: center;">Screen Layout for <%= screen.getName() %>
</h3>
<table>
    <% int seatIndex = 0;
        for (int row = 1; row <= screen.getNoOfRows(); row++) { %>
    <tr>
        <% for (int col = 1; col <= screen.getNoOfColumns(); col++) {
            String seatLabel = "";
            if (seatIndex < seatNumbers.size()) {
                ScreenLayout seat = seatNumbers.get(seatIndex);
                seatLabel = seat.getSeatNumber();
                seatIndex++;
            }
        %>
        <td><%= seatLabel %>
        </td>
        <% } %>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No cinema details available.</p>
<% } %>

</body>
</html>
