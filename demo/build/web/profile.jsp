<%-- 
    Document   : index
    Created on : 15/03/2021, 3:05:56 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/profile.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Profile Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            User Profile
            <span id="links"> <a href="account.jsp">Account</a> | <a href="logout.jsp">Logout </a></span>
        </div>
       
        <table id="users">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Gender</th>
                <th>Date of Birth</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>

        <div id="clock" class="footer">            
        </div>
    </body>
</html>
