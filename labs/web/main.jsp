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
        <link rel="stylesheet" href="css/profile.css">
        <script type="text/javascript" src="js/index.js"></script>
        <title>Main Page</title>
    </head>
    <body onload="startTime()">
        <div id="bar">
            MFlix Streaming
            <%
                User user = (User) session.getAttribute("user");
            %>
            <span id="links"> 
                <a class="button" href="EditServlet?email='<%= user.getID()%>'&password='<%=user.getPassword()%>'" > Account </a> 
                | 
                <a class="button" href="LogoutServlet" > Logout </a>
            </span>
        </div>

        <jsp:include page="moviesView.jsp" flush="true"/>

        <div id="clock" class="footer">            
        </div>
    </body>
</html>
