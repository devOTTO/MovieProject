​<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="main.java.util.Status"/>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="common/header.jsp" %> 
    <body>
    	<%@ include file="common/title.jsp" %>  
        <h2  class="col-md-4">Create Director Form</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form class="col-md-4" action="createdirector" method="post">
		 <div class="form-group">
		    <label for="dirName">Director Name</label>
		    <input type="text" class="form-control" name="dirName" placeholder="Director Name">
		  </div>
		  <div class="form-group">
		    <label for="dirAge">Director Age</label>
		    <input type="text" class="form-control" name="dirAge" placeholder="Director Age">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
    <%@ include file="common/footer.jsp" %>  
</html>