​<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
   <%@ include file="common/header.jsp" %> 
    <body>
        <h2 class="col-md-4">Create Movie Form</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
         <form class="col-md-4" action="createmovie" method="post">
		 <div class="form-group">
		    <label for="movName">Movie Title</label>
		    <input type="text" class="form-control" name="movName" placeholder="Movie Title">
		  </div>
		  <div class="form-group">
		    <label for="dirAge">Release Date(YYYY-MM-DD)</label>
		    <input type="text" class="form-control" name="movDate" placeholder="Release Date(YYYY-MM-DD)">
		  </div>
		  <div class="form-group">
		    <label for="dirAge">Movie Rating</label>
		    <input type="text" class="form-control" name="movRate" placeholder=">Movie Rating">
		  </div>
		  <div class="form-group">
		    <label for="dirAge">Director ID</label>
		    <input type="text" class="form-control" name="dirId" placeholder="Director ID">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
        <%@ include file="common/footer.jsp" %>  
</html>