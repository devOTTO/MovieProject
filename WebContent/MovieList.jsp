​<%@page import="java.util.ArrayList"%>
<%@page import="domain.Movie"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.MovieService"%>
<% ArrayList<Movie> movies = new MovieService().getMovies(); %>
<html>
    <head><title>Movie List</title></head>
    <body>
        <p><b>Movie List</b></p>
            <%
                if ((movies == null || movies.size() <= 0)) {
            %>
        There is no movie.
        <%
        } else {%>
        <table border="2px">
            <tr>
                <th width="500">Movie Title</th>
            </tr>
            <%
                for (int i = 0; i < movies.size(); i++) {
                    Movie Data = movies.get(i);
            %>
            <tr>
                <td align="center"><form action="showmoviedata" method="post"><input type="submit" value="<%=Data.getMovName()%>">
                <input type="hidden" name="movId" value="<%=Data.getMovId()%>"></form></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
%>
   <a href="NewMovie.jsp">Create a new movie data</a>
    </body>
</html>