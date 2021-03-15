<%-- 
    Document   : register
    Created on : 15/03/2021, 3:55:19 PM
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
    <body onload="startTime()">
        <div id="bar">
            Sign Up
            <span id="links"> <a href="login.jsp"> Login</a> | <a href="index.jsp">Home </a></span>
        </div>

        <form action="welcome.jsp" method="post">
            <table class="table">
                <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
                <tr><td>Email</td><td><input type="text" name="email"/></td></tr>
                <tr><td>Password</td><td><input type="password" name="password"/></td></tr>                
                <tr>
                    <td>
                            <input type="submit" value="Submit" class="button">
                    </td>
                    <td>
                        <select class="select" name="gender">
                            <option value="empty">Gender</option>
                            <option value="male">M</option>
                            <option value="female">F</option>
                            <option value="other">Other</option>                                                                
                        </select>
                        <input class="date" type="date" name="dob"/>                                     
                    </td>
                </tr>               
                
            </table>
        </form>

        <div id="clock" class="footer"></div>

    </body>
</html>
