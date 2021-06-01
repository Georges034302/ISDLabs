<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page import="uts.isd.model.*" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%
    MovieMongoDAO manager = (MovieMongoDAO) session.getAttribute("manager");    
    ArrayList<Movie> matches = manager.fetchMovies();
%>

<c:set var = "xmltext">   
<c:import url = "xsl/movies.xsl" var = "xslt"/>
    <movies>
        <%            
            for (Movie movie : matches) {
        %>
        <movie>
            <ID><%= movie.getID()%></ID>
            <name><%= movie.getName()%></name>            
            <url><%= movie.getUrl() %></url>                       
        </movie>
        <%}%>          
    </movies>
</c:set>
<x:transform xml = "${xmltext}" xslt = "${xslt}"></x:transform>

