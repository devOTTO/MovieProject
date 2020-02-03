​<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter"%>
<%@page import="domain.Director"%>
<%@page import="domain.Movie"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="domain.DirectorService"%>
<%@page import="domain.MovieService"%>
<% 
String directorSearch = null;

if (request.getParameter("directorSearch") != null) {

	directorSearch = request.getParameter("directorSearch");

}

if (directorSearch == null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 주소 입니다.')");
	script.println("location.href = 'main.jsp'");
	script.println("</script>");
}
ArrayList<Director> directors = new DirectorService().getSearchedDirectors(directorSearch); 
%>
<html>
	<%@ include file="common/header.jsp" %>  
    <body>
    	<%@ include file="common/title.jsp" %>  
	<div class="col-md-6 col-sm-4">
        <h2>Director List</h2>
        <%
                if ((directors == null || directors.size() <= 0)) {
            %>
        There is no director matching with "<b><%=directorSearch %></b>".
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
        
        </div>    
    </body>
	<%@ include file="common/footer.jsp" %>  
</html>