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
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        %>
        <div id="bar">
            <span id="links"><a href="index.jsp">Home</a>  |  <a href="login.jsp">Login</a></span>
        </div>
        <div class="register-form">
        <form method="POST" action="/RegisterServlet">
                <table>
                    <tr><td>Email: </td><td><input class="form-input" type="text" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>"></td></tr>
                    <tr><td>Password:</td><td><input class="form-input" type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>"></td></tr>
                    <tr><td>Name: </td><td><input class="form-input" type="text" name="name" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>"></td></tr>
                    <tr><td>Phone: </td><td><input class="form-input" type="text" name="phone"></td></tr>
                    <tr><td>TOS: </td>
                        <td>
                            <input class="remember-checkbox" type="checkbox" name="tos">
                            <input class="login-button" type="submit" value="Sign Up">
                        </td>
                    </tr>    
                    <span class="message"> <%=(existErr != null ? existErr : "")%></span>
                </table>
            </form>
        </div>
        <div id="clock" class="footer">                        
        </div>
    </body>
</html>
