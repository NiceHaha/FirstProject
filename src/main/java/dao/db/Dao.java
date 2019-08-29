package dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.util.PropertiesUtil;

public class Dao {
	public static void main(String[] args) {
		getConn();
	}
	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public static Connection getConn() {

		Connection conn = null;
		try {
			String aa=PropertiesUtil.getValue("jdbc.class");
			//System.out.println(aa);
			String bb=PropertiesUtil.getValue("jdbc.url");
			//System.out.println(bb);
			String cc=PropertiesUtil.getValue("jdbc.account");
			//System.out.println(cc);
			String dd=PropertiesUtil.getValue("jdbc.password");
			//System.out.println(dd);
			Class.forName(aa);
			conn=DriverManager.getConnection(bb,cc,dd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * 
	 */
	public static void closeConn(Connection conn,PreparedStatement ps,ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
