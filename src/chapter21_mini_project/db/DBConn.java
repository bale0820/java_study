package chapter21_mini_project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	private String url = "jdbc:mysql://127.0.0.1:3306/hrdb2019";
	private String user = "root";
	private String password = "mysql1234";
	protected Connection connect;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DBConn() {
		try {
			connect = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void getPreparedStatement(String sql) {
		try {
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			pstmt = connect.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public  void close() {
		try {
			if(rs !=  null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(connect != null) {
				connect.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
