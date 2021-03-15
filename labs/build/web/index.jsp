<%-- 
    Document   : index
    Created on : 15/03/2021, 3:05:56 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            ISD Demo
            <span id="links"> <a href="login.jsp"> Login</a> | <a href="register.jsp">Register </a></span>
        </div>
        
        <div id="clock" class="footer">            
        </div>
    </body>
</html>
