<%-- 
    Document   : index
    Created on : Mar 19, 2021, 10:24:22 AM
    Author     : George
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
        <title>Welcome Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">ISD Demo
            <span id="links"><a href="logout.jsp">Logout</a> | <a href="profile.jsp">Profile</a></span>
        </div>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
        %>

        <table class="table">            
            <tr><td>Name:</td><td><%= name%></td></tr>
            <tr><td>Email:</td><td><%= email%></td></tr>
            <tr><td>Password:</td><td><%= password%></td></tr>
            <tr><td>Phone:</td><td><%= phone%></td></tr>
            <tr><td>Gender:</td><td><%= gender%></td></tr>
            <tr><td>Date of Birth:</td><td><%= dob%></td></tr>            
        </table>
        <div id="clock" class="footer"></div>
    </body>
</html>
