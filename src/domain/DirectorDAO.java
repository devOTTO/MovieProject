package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBConnectionPool;

public class DirectorDAO {

    private DBConnectionPool connPool;

    ArrayList<Director> allDirector() throws SQLException {
        ArrayList<Director> directors = new ArrayList<Director>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                directors.add(new Director(rset.getInt("DIR_ID"), rset.getString("DIR_NAME"), rset.getInt("DIR_AGE")));            }
            return directors;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    private static final String RETRIEVE_STMT
            = "SELECT * FROM DIRECTOR";
   
     Director selectedDirector(int dirId) throws SQLException {
        Director director = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_ONE);
            stmt.setInt(1, dirId);
            rset = stmt.executeQuery();
            while (rset.next()) {
            	director =new Director(rset.getInt("DIR_ID"), rset.getString("DIR_NAME"), rset.getInt("DIR_AGE"));
            	
            }
            return director;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
        int insert(Director director) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rID = null;
        int rset = -1;
        try {
            int ID = -1;
        	conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setString(1, director.getDirName());
            stmt.setInt(2, director.getDirAge());
            rset = stmt.executeUpdate();
            System.out.println(stmt);
            stmt = conn.prepareStatement(GETID_STMT);
            rID = stmt.executeQuery();
            ID = rID.getInt("DIR_ID");
            System.out.println(ID);
            return ID;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
    private static final String GETID_STMT = "SELECT DIR_ID FROM DIRECTOR ORDER BY DIR_ID DESC limit 1";
    private static final String INSERT_STMT = "INSERT INTO DIRECTOR (DIR_NAME, DIR_AGE) VALUES(?, ?)";
    private static final String RETRIEVE_ONE
            = "SELECT * FROM DIRECTOR WHERE DIR_ID = ?";
}
