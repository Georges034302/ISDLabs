<%-- 
    Document   : logout
    Created on : 22/03/2022, 7:12:28 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Logout Page</title>
    </head>
    <body onload="startTime()" >
        <div id="bar">
            <span id="links"><a href="index.jsp">Home</a> </span>
        </div>
        <div class="login-form"><p class="title">Thank you</p></div>
        <% 
            session.invalidate();
         %>
        <div id="clock" class="footer">
            
        </div>
    </body>
</html>
