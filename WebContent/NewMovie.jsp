​<%@page session="false" import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Movie Form</title>
    </head>
    <body>
        <h2>Create Movie Form</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="createmovie" method="post">
            <table>
                <tr><td>Movie Title : </td><td>
                        <input type="text" name="movName" size="24"></td></tr>
                <tr><td>Release Date(YYYY-MM-DD) : </td><td>
                        <input type="text" name="movDate" size="24"></td></tr>
                <tr><td>Movie Rating : </td><td>
                        <input type="text" name="movRate" size="24"></td></tr>
                <tr><td>Director ID : </td><td>
                        <input type="text" name="dirId" size="24"></td></tr>
                        </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>