package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnectionPool;

public class MovieDAO {

    private DBConnectionPool connPool;

    ArrayList<Movie> allMovie() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            rset = stmt.executeQuery();
            while (rset.next()) {
                movies.add(new Movie(rset.getInt("MOV_ID"), rset.getString("MOV_NAME"), 
                        rset.getDate("MOV_DATE"), rset.getInt("MOV_RATE"), rset.getInt("DIR_ID")));
            }
            return movies;
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
            = "SELECT * FROM MOVIE";
    ArrayList<Movie> searchedMovies(String movName) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(SEARCH);
            stmt.setString(1,"%"+movName+"%");
            rset = stmt.executeQuery();
            while (rset.next()) {
                movies.add(new Movie(rset.getInt("MOV_ID"), rset.getString("MOV_NAME"), 
                        rset.getDate("MOV_DATE"), rset.getInt("MOV_RATE"), rset.getInt("DIR_ID")));
            }
            return movies;
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
    private static final String SEARCH
            = "SELECT * FROM MOVIE WHERE MOV_NAME LIKE ?";
    ArrayList<Movie> directorMovies(int dirId) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_DIR_STMT);
            stmt.setInt(1, dirId);
            rset = stmt.executeQuery();
            while (rset.next()) {
                movies.add(new Movie(rset.getInt("MOV_ID"), rset.getString("MOV_NAME"), 
                        rset.getDate("MOV_DATE"), rset.getInt("MOV_RATE"), rset.getInt("DIR_ID")));
            }
            return movies;
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
    private static final String RETRIEVE_DIR_STMT
            = "SELECT * FROM MOVIE where DIR_ID = ?";
    
     Movie selectedMovie(int movId) throws SQLException {
        Movie movie = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_ONE);
            stmt.setInt(1, movId);
            rset = stmt.executeQuery();
            while (rset.next()) {
                movie =new Movie(rset.getInt("MOV_ID"), rset.getString("MOV_NAME"), 
                        rset.getDate("MOV_DATE"), rset.getInt("MOV_RATE"), rset.getInt("DIR_ID"));
            }
            return movie;
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
        int insert(Movie movie) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rID = null;
        int rset = -1;
        try {
            int ID = -1;
        	conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(INSERT_STMT);
            stmt.setString(1, movie.getMovName());
            stmt.setInt(2, movie.getMovRate());
            stmt.setDate(3, movie.getMovDate());
            stmt.setInt(4, movie.getDirId());

            rset = stmt.executeUpdate();

            stmt = conn.prepareStatement(GETID_STMT);
            rID = stmt.executeQuery();
            ID = rID.getInt("MOV_ID");
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
    private static final String GETID_STMT = "SELECT MOV_ID FROM MOVIE ORDER BY MOV_ID DESC limit 1";
    private static final String INSERT_STMT = "INSERT INTO MOVIE(MOV_NAME, MOV_RATE, MOV_DATE, DIR_ID) VALUES(?,?,?,?)";
    private static final String RETRIEVE_ONE
            = "SELECT * FROM MOVIE WHERE MOV_ID = ?";
}