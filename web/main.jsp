<%-- 
    Document   : main
    Created on : 22/03/2022, 7:04:25 PM
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
        <title>Main Page</title>
    </head>
    <body onload="startTime()" >        
        <div id="bar">
            <span id="links"><a href="account.jsp">Account</a>  |  <a href="logout.jsp">Logout</a></span>
        </div>
        <% 
            User user = (User)session.getAttribute("user");
        %>

        <div class="register-form">
            <table>    
                <tr><td class="title" colspan="2"><%= user.getName() %>'s Account </td></tr>
                <tr><td>User ID: </td><td><%= user.getID() %></td></tr>                    
                <tr><td>Email: </td><td><%= user.getEmail()%></td></tr>
                <tr><td>Phone: </td><td><%= user.getPhone()%></td></tr>              
            </table>
            
        </div>
        <%             
            session.setAttribute("user", user);
        %>
        <div id="clock" class="footer">

        </div>
    </body>
</html>

