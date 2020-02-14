​<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="main.java.util.Status"/>
<%@page import="main.java.domain.DirectorService"%>
<%@page import="main.java.domain.Director"%>
<%@page session="false" language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
   <%@ include file="common/header.jsp" %> 

<script type="text/javascript">
$(document).ready(function() {
	 $("#dirId").autocomplete({
	 source : function(request, response) {
	 $.ajax({
	 url : "/MovieProject/searchdirector",
	 type : "post",
	 dataType : "json",
	 data: {dirName:$("#dirId").val()},
	 success : function(data) {
		 response(
			$.map(data, function(item) {
				return {
					label: item.dirName,
					value: item.dirId
				}
			})
		)},
	 error : function(xhr, status, error) {
		 console.log(error);
		 alert(error);
	}
	 });},
	 minLength: 2,
	 response: function(event, ui){
		 console.log(ui);
	 },
	 select: function(event, ui){
		 console.log("Selected:" + ui.item.value);
	 },
	 focus : function(event, ui) {    //포커스 가면
         return false;//한글 에러 잡기용도로 사용됨
     },
	 });
	});
</script>
    <body>
    	<%@ include file="common/title.jsp" %>  
        <h2 class="col-md-6">Create Movie Form</h2>
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
		    <input type="text" class="form-control" name="movRate" placeholder="Movie Rating">
		  </div>
		  <div class="form-group">
		    <label for="dirId">Director Id (Search By Id)</label>
		    <input type="text" class="form-control" id="dirId" name="dirId" placeholder="Search Director Name...">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
        <%@ include file="common/footer.jsp" %>  
</html>
