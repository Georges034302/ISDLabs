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
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Account Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            Edit User
            <span id="links"> <a href="profile.jsp"> Profile</a> | <a href="logout.jsp">Logout</a></span>
        </div>
       
        <div id="clock" class="footer">            
        </div>
    </body>
</html>
