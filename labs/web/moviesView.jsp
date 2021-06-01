<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page import="uts.isd.model.*" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<c:set var = "xmltext">   
<c:import url = "xsl/movies.xsl" var = "xslt"/>
<jsp:include page="/MovieListServlet" flush="true"/>
</c:set>
<x:transform xml = "${xmltext}" xslt = "${xslt}"></x:transform>

