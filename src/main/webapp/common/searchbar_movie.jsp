<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JQuery Java script -->
        <form name="searchedmovie" action="MovieList.jsp" method="get" onsubmit="return keyword_check_mov()">
        <div class="input-group">
        <input type="search" class="form-control ds-input" name="movieSearch" placeholder="Search Movie...">
	  	</div>
        </form> 