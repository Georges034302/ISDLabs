<%-- 
    Document   : account
    Created on : 22/03/2022, 7:12:36 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Account Page</title>
    </head>
    <body onload="startTime()" >
        <div id="bar">
            <span id="links"><a href="main.jsp">Main</a>  |  <a href="logout.jsp">Logout</a></span>
        </div>
        <% 
            User user = (User)session.getAttribute("user");
            String updated= request.getParameter("updatted");
        %>
        <form id="form" method="POST" action="account.jsp">
                <table>
                    <tr><td>Email: </td><td><input type="text" name="email" value="<%= user.getID() %>" readonly="true"></td></tr>
                    <tr><td>Email: </td><td><input type="text" name="email" value="<%= user.getEmail() %>"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="password" value="${user.password}"></td></tr>
                    <tr><td>Name: </td><td><input type="text" name="name" value="${user.name}"></td></tr>
                    <tr><td>Phone: </td><td><input type="text" name="phone" value="${user.phone}"></td></tr>
                    <tr><td>TOS: </td><td><input type="checkbox" name="tos"></td></tr>
                    <tr><td></td><td><input type="hidden" value="updatted" name="updatted"></td></tr>
                    <tr><td></td><td><input class="button" type="submit" value="Edit"></td></tr>                    
                </table>
        </form>
        <% 
            if(updated != null && updated.equals("updatted")){
                    String email = request.getParameter("email");
                    String name = request.getParameter("name");
                    String password = request.getParameter("password");
                    String phone = request.getParameter("phone");
                    
                    user.setID(user.getID());
                    user.setEmail(email);
                    user.setName(name);
                    user.setPassword(password);
                    user.setPhone(phone);
                    
                    session.setAttribute("user", user);
            }
            %>
        <div id="clock" class="footer">
            
        </div>
    </body>
</html>
