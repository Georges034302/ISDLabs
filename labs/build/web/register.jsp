<%-- 
    Document   : index
    Created on : Mar 19, 2021, 10:24:22 AM
    Author     : George
--%>

<%@page import="uts.isd.controller.Validator"%>
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
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        %>
        <div id="bar">Sign Up <span class="message"> <%=(existErr != null ? existErr : "")%></span>
            <span id="links"><a href="login.jsp" onclick="<%Validator.clear(session);%>">Login</a> | <a href="index.jsp" onclick="<%Validator.clear(session);%>">Home</a></span>
        </div>
        
        <form action="RegisterServlet" method="post">
            <table class="table">
                <tr><td>Full Name:</td><td><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>" name="name"></td></tr>
                <tr><td>Email:</td><td><input type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email"></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password"></td></tr>
                <tr><td>Phone</td><td><input type="text" name="phone" placeholder="Enter Phone"></td></tr>                
                <tr><td><input class="button" type="submit" value="Sign Up"></td>
                    <td>
                        <select class="select" name="gender">
                            <option value="">Gender</option>
                            <option value="male">M</option>
                            <option value="female">F</option>
                            <option value="other">Other</option>                                                                
                        </select>
                        <input class="date" type="date" name="dob"/> 
                    </td>
                </tr>                
            </table>
        </form>        
        <div id="clock" class="footer">
            
        </div>
    </body>
</html>
