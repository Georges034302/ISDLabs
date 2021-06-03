<%-- 
    Document   : index
    Created on : Mar 19, 2021, 10:24:22 AM
    Author     : George
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
        <div id="bar">M-Flix Review 
            <span id="links"><a href="login.jsp">Login</a> | <a href="register.jsp">Register</a></span>
        </div>
        <jsp:include page="ConnServlet" flush="true"/>
        <div id="clock" class="footer">
            
        </div>        
    </body>
</html>
