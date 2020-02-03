​<%@page import="java.util.ArrayList"%>
<%@page import="domain.Director"%>
<%@page import="domain.Movie"%>
<%@ page import="java.io.PrintWriter"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.DirectorService"%>
<%@page import="domain.MovieService"%>
<% 
int dirId = 0;

if (request.getParameter("dirId") != null) {

	dirId = Integer.parseInt(request.getParameter("dirId"));

}

if (dirId == 0) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 주소 입니다.')");
	script.println("location.href = 'main.jsp'");
	script.println("</script>");
}
Director director = new DirectorService().selectedDirector(dirId); 
ArrayList<Movie> movies = new MovieService().getMoviesByDirId(dirId);
%>

<html>
	<%@ include file="common/header.jsp" %> 
    <body>
    	<%@ include file="common/title.jsp" %>  
    <div class="col-md-4">
    <table class="table table-striped table-bordered table-hover">
            <caption class="caption-top">About Director</caption>
            <tr>
                <td class="info">
               	Director Id
               	</td>
               	<td>
               	<%=director.getDirId() %>
               	</td>
            </tr>
             <tr>
                <td class="info">
               	Director Name
               	</td>
               	<td>
               	<%=director.getDirName() %>
               	</td>
            </tr>
            <tr>
                <td class="info">
               	Director Age
               	</td>
               	<td>
               	<%=director.getDirAge() %>
               	</td>
            </tr>                                   
    </table>
    </div>
    <div class="col-md-4">
    <div class="panel panel-default">
  
  	<div class="panel-heading">About Movie</div>
  	<%
	if ((movies == null || movies.size() <= 0)) {
    %>
	<div class="panel-body">
	<p>There is no movie.</p>
	</div>
     <%
     } else {
       for (int i = 0; i < movies.size(); i++) {
            Movie Data = movies.get(i);
     %>
 	
    <table class="table table-striped table-bordered table-hover">  
			<caption class="caption-top">#<%=i+1 %> Movie</caption>
            <tr>
                <td class="info">
               	Movie Title
               	</td>
               	<td>
               	<%=Data.getMovName() %>
               	</td>
            </tr>
             <tr>
                <td class="info">
               	Release Date
               	</td>
               	<td>
               	<%=Data.getMovDate() %>
               	</td>
            </tr>
             <tr>
                <td class="info">
               	 Movie Rating
               	</td>
               	<td>
               	<%=Data.getMovRate() %>
               	</td>
            </tr>            
    </table>
    <% }} %>  
    </div>    
    </body>
    	<%@ include file="common/footer.jsp" %>  
</html>

​