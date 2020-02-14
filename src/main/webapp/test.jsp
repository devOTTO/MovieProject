<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@ page import = "java.sql.*" %> 
<% 
	Connection conn = null; 
	try{ 
	String url = "jdbc:mysql://133.186.144.151:13303/dev_db";//생성한 데이타베이스 이름을 넣는다. 
	String id = "client"; // db에 접속하는 계정 
	String pw = "Client1234!"; // db에 접속하는 계정의 비밀번호 
	Class.forName("org.gjt.mm.mysql.Driver"); 
	conn=DriverManager.getConnection(url, id, pw); 
	out.println("success"); // mysql에 연결되면 성공!! 
	out.println("push test");
	}catch(Exception e){ 
		out.println("fail"); // mysql에 연결 실패!! 
	} 
%>
