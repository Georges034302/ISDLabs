<%-- 
    Document   : register
    Created on : 22/03/2022, 6:47:41 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Register Page</title>
    </head>
    <body onload="startTime()" >
        <div id="bar">
            <span id="links"><a href="index.jsp">Home</a>  |  <a href="login.jsp">Login</a></span>
        </div>
        <form id="form" method="POST" action="main.jsp">
                <table>
                    <tr><td>Email: </td><td><input type="text" name="email"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
                    <tr><td>Name: </td><td><input type="text" name="name"></td></tr>
                    <tr><td>Phone: </td><td><input type="text" name="phone"></td></tr>
                    <tr><td>TOS: </td><td><input type="checkbox" name="tos"></td></tr>
                    <tr><td></td><td><input class="button" type="submit" value="Sign Up"></td></tr>
                </table>
            </form>
        <div id="clock" class="footer">
            
            
        </div>
    </body>
</html>
