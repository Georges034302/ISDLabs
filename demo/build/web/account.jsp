<%-- 
    Document   : index
    Created on : 15/03/2021, 3:05:56 PM
    Author     : george
--%>

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
        <div id="bar">
            Edit User
            <span id="links"> <a href="profile.jsp"> Profile</a> | <a href="logout.jsp">Logout</a></span>
        </div>
        <%
            User user = (User)session.getAttribute("user");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String submitted = request.getParameter("submitted");
        %>
        <form action="account.jsp" method="post">
            <table class="table">
                <tr><td>Name</td><td><input type="text" name="name" value="<%= (submitted != null)? name:user.getName() %>" ></td></tr>
                <tr><td>Email</td><td><input type="text" name="email" value="<%= (submitted != null)?email:user.getEmail()%>"></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" value="<%= (submitted != null)?password:user.getPassword() %>"></td></tr>
                <tr><td>Phone</td><td><input type="text" name="phone" value="<%= (submitted != null)?phone:user.getPhone()%>"></td></tr>                
                <tr><td><input class="button" type="submit" value="Update"></td>
                    <td>
                        <select class="select" name="gender">
                            <option value="<%= (submitted != null)?gender:user.getGender()%>"><%= (submitted != null)?gender:user.getGender()%></option>
                            <option value="male">M</option>
                            <option value="female">F</option>
                            <option value="other">Other</option>                                                                
                        </select>
                            <input class="date" type="date" name="dob" value="<%= (submitted != null)?dob:user.getDob() %>"/> 
                    </td>
                </tr>     
                <input type="hidden" value="submitted" name="submitted">
            </table>
        </form>
        <% 
            user.updateInfo(name, email, password, phone, gender, dob);
            session.setAttribute("user", user);
         %>
        <div id="clock" class="footer">            
        </div>
    </body>
</html>
