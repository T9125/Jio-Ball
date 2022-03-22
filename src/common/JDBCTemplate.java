package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "SEMI";
	private static final String PASSWORD = "1234";
	
	// private 생성자
	private JDBCTemplate() {}
	
	// DB 연결 객체
	private static Connection conn;
	
	// Connection 객체 반환 - 싱글톤 패턴 적용
	public static Connection getConnection() {
		
		try {
			// 드라이버 로드
			Class.forName(DRIVER);
			
			// DB 연결
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			// AutoCommit 설정 끄기
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DB 연결 객체 반환
		return conn;
	}
	
	// Connect 객체 닫기
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Statement 객체 닫기
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed()) st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// PreparedStatement 객체 닫기
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed()) ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 객체 닫기
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Commit 수행
	public static void commit(Connection conn) {
		try {
			if (conn!=null && !conn.isClosed()) conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Rollback 수행
	public static void rollback(Connection conn) {
		try {
			if (conn!=null && !conn.isClosed()) conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}