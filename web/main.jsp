<%-- 
    Document   : main
    Created on : 22/03/2022, 7:04:25 PM
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Main Page</title>
    </head>
    <body onload="startTime()" >        
        <div id="bar">
            <span id="links"><a href="account.jsp">Account</a>  |  <a href="logout.jsp">Logout</a></span>
        </div>
        <% 
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String tos = request.getParameter("tos");
        %>

        <table id="form">
            <%if(tos != null){%>
                <tr><td>Email: </td><td><%= email%></td></tr>                    
                <tr><td>Name: </td><td><%= name%></td></tr>
                <tr><td>Phone: </td><td><%= phone%></td></tr>   
            <%}else{%>                
                <tr><td>Warning: </td><td>Please Agree to the TOS <a href="register.jsp">click here to go back</a></td></tr>   
            <%}%>
        </table>
        <div id="clock" class="footer">

        </div>
    </body>
</html>

