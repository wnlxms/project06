package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDao {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		/* 로그인체크 */
		System.out.println("어드민 로그인시");
		System.out.println(dao.logincheck("admin", "admin"));
		System.out.println();
		
		System.out.println("일반회원 로그인시");
		System.out.println(dao.logincheck("종원", "whddnjs"));
		System.out.println();
		
		System.out.println("회원이 아닐시");
		System.out.println(dao.logincheck("준영", "wnsdud"));
		System.out.println();
		
		/* 회원가입 */
		dao.createAccount("asdasd0922", "asdasd", "지수");
	}
	public int logincheck(String id, String pw) { //관리자면 2  로그인성공시 1  로그인 실패시 0
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "SELECT COUNT(*) FROM member WHERE id = ? AND pw = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);	
			pstmt.setString(2, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = d.getRs(pstmt);
		int result = 0;
		try {
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt, rs);
		}
		return id.equals("admin") && result == 1 ? 2 : result;
	}
	
	public void createAccount(String id, String pw, String name) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "INSERT INTO member(id, pw, name) VALUES (?, ?, ?)";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			System.out.println(pstmt.executeUpdate()+ "행 삽입됨");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDto getMemberinfo(String id) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "SELECT name, point FROM member WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = d.getRs(pstmt);
		try {
			rs.next();
			String name = rs.getString(1);
			int point = rs.getInt(2);
			return new MemberDto(id, null, name, point);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public void payProduct(String id, int price, String productname) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "UPDATE member SET point = point - ? WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, price);
			pstmt.setString(2, id);
			System.out.println(pstmt.executeUpdate() + "행 업데이트됨");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "INSERT INTO buyproduct (id, productname) VALUES (?, ?)";
		pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, productname);
			System.out.println(pstmt.executeUpdate() + "행 업데이트됨");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			d.close(conn, pstmt);
		}
	}

	public void viewAd(String id, int point) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "UPDATE member SET point = point + ? WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			System.out.println(pstmt.executeUpdate() + "행 업데이트됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
	}
	
	public ArrayList<MemberDto> getAllMemberinfo() {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "SELECT id, pw, name, point FROM member";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		ResultSet rs = d.getRs(pstmt);
		ArrayList<MemberDto> list = new ArrayList<>();
		try {
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				list.add(new MemberDto(id, pw, name, point));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public MemberDto getMemberinfoadmin(String id) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "SELECT id, pw, name, point FROM member WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = d.getRs(pstmt);
		try {
			rs.next();
			String pw = rs.getString(2);
			String name = rs.getString(3);
			int point = rs.getInt(4);
			return new MemberDto(id, pw, name, point);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public void updatememberinfo(String id, String pw, String name, int point) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "UPDATE member SET id = ?, pw = ?, name = ? , point = ? WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setInt(4, point);
			pstmt.setString(5, id);
			System.out.println(pstmt.executeUpdate() + "행 업데이트됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
	}
	public void deletememberID(String id) {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "DELETE FROM member WHERE id = ?";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.setString(1, id);
			System.out.println(pstmt.executeUpdate() + "행 삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
	}
	public void updatememberpoint() {
		DatabaseUtil d = new DatabaseUtil();
		Connection conn = d.getConn();
		String sql = "UPDATE member SET point = point + 1";
		PreparedStatement pstmt = d.getPstmt(conn, sql);
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
		
	
	}
}
