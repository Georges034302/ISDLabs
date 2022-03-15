<%-- 
    Document   : index
    Created on : 15/03/2022, 6:44:13 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Home Page</title>
    </head>
    <body onload="startTime()" >
        <h1>Hello World!</h1>
        <% 
            String name = "George";        
        %>
        <p>Tutor: <%= name%> </p>
        <p>Random ID: <%= new Random().nextInt(999999) %></p>
        <div id="clock" class="footer">
            
        </div>
    </body>
</html>
