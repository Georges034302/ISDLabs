<%-- 
    Document   : index
    Created on : 15/03/2021, 3:05:56 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Profile Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            ISD Demo
            <span id="links"> <a href="account.jsp">Account</a> | <a href="logout.jsp">Logout </a></span>
        </div>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <table class="table">            
            <tr><td>Name:</td><td><%= user.getName() %></td></tr>
            <tr><td>Email:</td><td>${user.email}</td></tr>
            <tr><td>Password:</td><td>${user.password}</td></tr>
            <tr><td>Phone:</td><td>${user.phone}</td></tr>
            <tr><td>Gender:</td><td><%= user.getGender() %></td></tr>
            <tr><td>Date of Birth:</td><td>${user.dob}</td></tr>            
        </table>
        
        <div id="clock" class="footer">            
        </div>
    </body>
</html>
