​<%@page import="java.util.ArrayList"%>
<%@page import="domain.Movie"%>
<%@page import="domain.Director"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.MovieService"%>
<%@page import="domain.DirectorService"%>
<% 
ArrayList<Movie> movies = new MovieService().getMovies(); 
ArrayList<Director> directors = new DirectorService().getDirectors(); 
%>
<html>
	<%@ include file="common/header.jsp" %>  
    <body>
  	<div class="col-md-4">
        <h2>Movie List</h2>
            <%
                if ((movies == null || movies.size() <= 0)) {
            %>
        There is no movie.
        <%
        } else {%>
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>Movie Title</th>
            </tr>
            <%
                for (int i = 0; i < movies.size(); i++) {
                    Movie Data = movies.get(i);
            %>
            <tr>
                <td align="center"><a href="MovieData.jsp?movId=<%=Data.getMovId()%>"><%=Data.getMovName()%></a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%}%>
           <a href="NewMovie.jsp" class="btn btn-info" >Add Movie</a>
        </div>
        
	<div class="col-md-4">
        <h2>Director List</h2>
        <%
                if ((directors == null || directors.size() <= 0)) {
            %>
        There is no director.
        <%
        } else {%>
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>Director Name</th>
            </tr>
            <%
                for (int i = 0; i < directors.size(); i++) {
                    Director Data = directors.get(i);
            %>
            <tr>
                <td align="center"><a href="DirectorData.jsp?dirId=<%=Data.getDirId()%>"><%=Data.getDirName()%></a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%}%>
        <a href="NewDirector.jsp" class="btn btn-info" >Add Director</a>
        </div>
        
    </body>
	<%@ include file="common/footer.jsp" %>  
</html>