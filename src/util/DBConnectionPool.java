//DBConnectionPool.java
package util;
//JDBC imports
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
//JNDI imports
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
public class DBConnectionPool extends Object {
   private static DBConnectionPool instance;
   private static DataSource ds=null;
   private static final String dbName="jdbc/devDB";  
   //Keep this package private.
   DBConnectionPool() throws SQLException {init();}
   public static DBConnectionPool getInstance() throws SQLException {
      if (instance==null) instance=new DBConnectionPool();
      return instance;
   }
   public void init() throws SQLException {
      try {
         Context intContext=new InitialContext();         
         Context envContext=(Context)intContext.lookup("java:/comp/env");
         ds=(DataSource)envContext.lookup(dbName);
      } catch (NamingException e) {System.err.println(
      "Problem looking up "+dbName+": "+e);}
   }
   public static Connection getPoolConnection() throws SQLException {
      instance=DBConnectionPool.getInstance();
      Connection conn=ds.getConnection(); 
      if (conn==null) throw new SQLException(
         "Maximum number ofconnections in pool exceeded.");
      return conn;
   }
} 
// <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
// <%@ page import="java.sql.*"%>
// <%@ page import="javax.sql.*"%>
// <%@ page import="javax.naming.*"%>
// <%
//     Connection conn=null;
//     try{
//         Context init = new InitialContext();
//         DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/devDB");
//         conn = ds.getConnection();
//         out.println("Success!!!");
//     }catch(Exception e){
//         out.println("Failure!!!");
//         e.printStackTrace();
//     }

// %>