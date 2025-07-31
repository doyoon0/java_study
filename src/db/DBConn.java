package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	private String url = "jdbc:mysql://localhost:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	
	Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	//Constructor
	protected DBConn() {
		try {
			//1단계
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement 생성
	public void getStatement() {
		try {
			//2단계 : Statement 객체 생성
			stmt = connection.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 생성
	public void getPreparedStatement(String sql) {
		try {
			//2단계 : PreparedStatement 객체 생성
			pstmt = connection.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//객체 종료
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
