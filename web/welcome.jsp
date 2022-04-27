<%-- 
    Document   : main
    Created on : 22/03/2022, 7:04:25 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Welcome Page</title>
    </head>
    <body onload="startTime()" >        
        <div id="bar">
            <span id="links"><a href="account.jsp">Account</a>  |  <a href="logout.jsp">Logout</a></span>
        </div>
        <% 
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String tos = request.getParameter("tos");
        %>

        <div class="register-form">
            <table>    
                <tr><td class="title" colspan="2">Welcome </td></tr>
                <tr><td>Email: </td><td><%= email%></td></tr>                    
                <tr><td>Name: </td><td><%= name%></td></tr>
                <tr><td>Phone: </td><td><%= phone%></td></tr>              
            </table>
            <p class="message">Click <a href="main.jsp" class="button">here</a> to go to the main page</p>
        </div>
        <% 
            User user = new User(new Random().nextInt(999),email,name,password,phone);
            session.setAttribute("user", user);            
        %>

        <div id="clock" class="footer">

        </div>
    </body>
</html>
