​<%@page import="java.util.ArrayList"%>
<%@page import="domain.Movie"%>
<%@page import="domain.Director"%>
<%@ page import="java.io.PrintWriter"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.MovieService"%>
<%@page import="domain.DirectorService"%>
<% 
int movId = 0;

if (request.getParameter("movId") != null) {

	movId = Integer.parseInt(request.getParameter("movId"));

}

if (movId == 0) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 주소입니다.')");
	script.println("location.href = 'main.jsp'");
	script.println("</script>");
}
Movie movie = new MovieService().selectedMovie(movId); 
Director director = new DirectorService().selectedDirector(movie.getDirId());
%>

<html>
	<%@ include file="common/header.jsp" %> 
    <body>
    	<%@ include file="common/title.jsp" %>  
    <div class="col-md-4">
    <table class="table table-striped table-bordered table-hover">
            <caption class="caption-top">About Movie</caption>
            <tr>
                <td class="info">
               	Movie Title
               	</td>
               	<td>
               	<%=movie.getMovName() %>
               	</td>
            </tr>
             <tr>
                <td class="info">
               	Release Date
               	</td>
               	<td>
               	<%=movie.getMovDate() %>
               	</td>
            </tr>
             <tr>
                <td class="info">
               	 Movie Rating
               	</td>
               	<td>
               	<%=movie.getMovRate() %>
               	</td>
            </tr>                       
    </table>
    </div>
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
    </body>
    	<%@ include file="common/footer.jsp" %>  
</html>

​