<%@page import="uts.isd.controller.MoviesXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<c:import url = "xsl/movies.xsl" var = "xslt"/>
<c:set var ="xmltxt">  
    <%out.print(MoviesXML.xmlString()); %>
</c:set>
<x:transform xml = "${xmltxt}" xslt = "${xslt}"></x:transform>
