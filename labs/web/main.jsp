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
        <script type="text/javascript" src="js/index.js"></script>
        <title>Main Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            MFlix Review
            <%
                User user = (User) session.getAttribute("user");
            %>
            <span id="links"> 
                <a href="EditServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'" onclick="<%Validator.clear(session);%>"> Account</a> 
                | 
                <a class="button" href="LogoutServlet"> Logout </a>
            </span>
        </div>

        <jsp:include page="moviesView_BAK.jsp" flush="true"/>

        <div id="clock" class="footer">            
        </div>
    </body>
</html>
