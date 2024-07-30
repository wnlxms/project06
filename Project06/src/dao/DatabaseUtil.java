package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "asdasd";
	private final String password = "asdasd";
	
    public Connection getConn() {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	
    public PreparedStatement getPstmt(Connection conn, String sql) {
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement(sql);
    		return pstmt;
    	} catch (SQLException e) {
            e.printStackTrace();
            return null;
    	}
	}
	
	public ResultSet getRs(PreparedStatement pstmt) {//SQL 쿼리 실행 결과를 담는 ResultSet 객체를 반환하는 메소드
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			return rs;
		} catch(SQLException e) {
            e.printStackTrace();
		}
		return null;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
		if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
		if (conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
		if (conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
	}
}
