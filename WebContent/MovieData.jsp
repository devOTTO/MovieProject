​<%@page import="java.util.ArrayList"%>
<%@page import="domain.Movie"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.MovieService"%>
<jsp:useBean id="movie" scope="request" class="domain.Movie"/>
<html>
    <head><title>Movie Data</title></head>
    <body>
        <p><b>Movie Data</b></p>
        Movie Title : <jsp:getProperty name="movie"
                         property="movName"/><br/>
        Movie ID : <jsp:getProperty name="movie"
                         property="movId"/><br/>
        Release Date : <jsp:getProperty name="movie"
                         property="movDate"/><br/>
        Movie Rating : <jsp:getProperty name="movie"
                         property="movRate"/><br/>
        Director Name : <jsp:getProperty name="movie"
                         property="dirId"/><br/>
    </body>
</html>

​