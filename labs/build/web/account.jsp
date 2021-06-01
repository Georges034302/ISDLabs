<%-- 
    Document   : index
    Created on : 15/03/2021, 3:05:56 PM
    Author     : george
--%>

<%@page import="uts.isd.controller.Validator"%>
<%@page import="uts.isd.model.User"%>
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
        <%
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
        %>
        <div id="bar">

            Edit User <span class="message"> <%=(updated != null ? updated : "")%></span>
            <span id="links"> 
                <a href="MainServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'"> MFlix</a> 
                 | 
                <a href="LogoutServlet">Logout</a></span>
        </div>
       
        <form action="UpdateServlet" method="post">
            <table class="table">
                <tr><td>ID</td><td><input type="text" name="id" value="<%= user.getID()%>" readonly></td></tr>
                <tr><td>Name</td><td><input type="text" name="name" value="<%= user.getName()%>" ></td></tr>
                <tr><td>Email</td><td><input type="text" name="email" value="<%= user.getEmail()%>"></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="<%= user.getPassword()%>"></td></tr>
                <tr><td>Phone</td><td><input type="text" name="phone" value="<%= user.getPhone()%>"></td></tr>                
                <tr><td><input class="button" type="submit" value="Update"></td>
                    <td>
                        <select class="select" name="gender">
                            <option value="<%= user.getGender()%>"><%= user.getGender()%></option>
                            <option value="male">M</option>
                            <option value="female">F</option>
                            <option value="other">Other</option>                                                                
                        </select>
                        <input class="date" type="date" name="dob" value="<%= user.getDob()%>"/> 
                    </td>
                </tr>               
            </table>
        </form>  
        <div id="clock" class="footer">            
        </div>
    </body>
</html>
