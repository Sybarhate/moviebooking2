<%--
  Created by IntelliJ IDEA.
  User: bsakshi
  Date: 20-06-2023
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>  <% if(request.getAttribute("errorList") != null) {%>
    <div><%=request.getAttribute("errorList")%></div>
    <% } %></h4>
</body>
</html>
