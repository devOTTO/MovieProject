​<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter"%>
<%@page import="main.java.domain.Movie"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="main.java.domain.MovieService"%>
<script type="text/javascript">
 function keyword_check_mov(){

	  if(document.searchedmovie.movieSearch.value=='' || document.searchedmovie.movieSearch.value == ' ') {

	  alert('검색어를 입력하세요'); //경고창 띄움 
	  return false; 
	  }
	  else return true;
	 }
</script>
<% 

String movieSearch = null;

if (request.getParameter("movieSearch") != null) {

	movieSearch = request.getParameter("movieSearch");

}

if (movieSearch == null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 주소 입니다.')");
	script.println("location.href = 'main.jsp'");
	script.println("</script>");
}
ArrayList<Movie> movies = new MovieService().getSearchedMovies(movieSearch); 
%>
<html>
	<%@ include file="common/header.jsp" %>  
    <body>
    <%@ include file="common/title.jsp" %>  
	<div class="container">
	<div class="col-md-6 col-sm-4">
        <h2>Movie List</h2>
    <%@ include file="common/searchbar_movie.jsp" %>     
        <%
                if ((movies == null || movies.size() <= 0)) {
            %>
        There is no movie matching with "<b><%=movieSearch %></b>".
        <%
        } else {%>
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>Director Name</th>
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
        
        </div>
        </div>    
    </body>
	<%@ include file="common/footer.jsp" %>  
</html>