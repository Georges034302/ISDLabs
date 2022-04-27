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
        <link rel="stylesheet" href="css/form.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Register Page</title>
    </head>
    <body onload="startTime()" >
        <div id="bar">
            <span id="links"><a href="index.jsp">Home</a>  |  <a href="login.jsp">Login</a></span>
        </div>
        <div class="register-form">
        <form method="POST" action="welcome.jsp">
                <table>
                    <tr><td>Email: </td><td><input class="form-input" type="text" name="email"></td></tr>
                    <tr><td>Password:</td><td><input class="form-input" type="password" name="password"></td></tr>
                    <tr><td>Name: </td><td><input class="form-input" type="text" name="name"></td></tr>
                    <tr><td>Phone: </td><td><input class="form-input" type="text" name="phone"></td></tr>
                    <tr><td>TOS: </td>
                        <td>
                            <input class="remember-checkbox" type="checkbox" name="tos">
                            <input class="login-button" type="submit" value="Sign Up">
                        </td>
                    </tr>                    
                </table>
            </form>
        </div>
        <div id="clock" class="footer">                        
        </div>
    </body>
</html>
