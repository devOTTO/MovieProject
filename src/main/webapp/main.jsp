​<%@page import="java.util.ArrayList"%>
<%@page import="main.java.domain.Movie"%>
<%@page import="main.java.domain.Director"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="main.java.domain.MovieService"%>
<%@page import="main.java.domain.DirectorService"%>
<% 
ArrayList<Movie> movies = new MovieService().getMovies(); 
ArrayList<Director> directors = new DirectorService().getDirectors(); 
%>

<script type="text/javascript">

 function keyword_check_dir(){

  if(document.searchdirector.directorSearch.value=='' || document.searchdirector.directorSearch.value == ' ' ) {

  alert('검색어를 입력하세요'); //경고창 띄움 
  return false; 
  }
  else return true;
 }

 function keyword_check_mov(){

	  if(document.searchedmovie.movieSearch.value=='' || document.searchedmovie.movieSearch.value == ' ') {

	  alert('검색어를 입력하세요'); //경고창 띄움 
	  return false; 
	  }
	  else return true;
	 }
</script>
<html>
	<%@ include file="common/header.jsp" %>  
    <body>
	<%@ include file="common/title.jsp" %>  
    <div class="container">
    <div class="row">
  	<div class="col-md-6 col-sm-4">
        <h2>Movie List</h2>
    <%@ include file="common/searchbar_movie.jsp" %>  
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
        
	<div class="col-md-6 col-sm-4">
        <h2>Director List</h2>
	<%@ include file="common/searchbar_director.jsp" %>  
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
    </div>
    </div>  
    </body>
	<%@ include file="common/footer.jsp" %>  
</html>