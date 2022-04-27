<%-- 
    Document   : login
    Created on : 22/03/2022, 6:47:32 PM
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
        <title>Login Page</title>
    </head>
    <body onload="startTime()" >
        <div id="bar">
            <span id="links"><a href="index.jsp">Home</a>  |  <a href="register.jsp">Register</a></span>
        </div>
        <div class="login-form">
        <form method="POST" action="welcome.jsp">
                <table>
                    <tr><td>Email: </td><td><input class="form-input" type="text" name="email"></td></tr>
                    <tr><td>Password:</td><td><input class="form-input" type="password" name="password"></td></tr>
                    <tr><td> </td> <td> <input class="login-button" type="submit" value="Sign In"> </td></tr>                    
                </table>
            </form>
        </div>
        <div id="clock" class="footer">
            
        </div>
    </body>
</html>
