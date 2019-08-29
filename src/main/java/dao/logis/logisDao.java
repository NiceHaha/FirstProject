package dao.logis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.db.Dao;
import entity.logis.LogisEntity;

public class logisDao {
		
	
	/*新增*/
	public void add(LogisEntity logis) {
		Connection conn =Dao.getConn();
		String sql = "insert into GF_logis(logis_code,logis_name,logis_tel,logis_url)values(?,?,?,?)";
		PreparedStatement pr = null;
		ResultSet re=null;
		try {
			pr=conn.prepareStatement(sql);
			pr.setString(1, logis.getLogisCode());
			pr.setString(2, logis.getLogisName());
			pr.setString(3, logis.getLogisTel());
			pr.setString(4, logis.getLogisUrl());
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn, pr,re );
		}
	}
	
	/*删除*/
	public void delete(int id) {
		Connection conn =Dao.getConn();
		String sql = "delete from GF_logis where id = ?";
		PreparedStatement pr = null;
		ResultSet re=null;
		try {
			pr=conn.prepareStatement(sql);
			pr.setInt(1, id);
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn, pr,re );
		}
	
	}
	
	/*修改*/
	public void update(LogisEntity logis) {
		Connection conn = Dao.getConn();
		String sql = "update GF_logis set logis_code=?,logis_name=?,logis_tel=?,logis_url=?  where id = ?";
		PreparedStatement pr = null;
		ResultSet re=null;
		try {
			pr=conn.prepareStatement(sql);
			pr.setString(1, logis.getLogisCode());
			pr.setString(2, logis.getLogisName());
			pr.setString(3, logis.getLogisTel());
			pr.setString(4, logis.getLogisUrl());
			pr.setInt(5, logis.getId());
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn, pr,re );
		}
	}
	
	/*查询*/
	public List<LogisEntity> Query() {
		LogisEntity logis=new LogisEntity();
		List<LogisEntity> list=new ArrayList<>();
		Connection conn = Dao.getConn();
		String sql = "select * from gf_logis";
		PreparedStatement pr = null;
		ResultSet re=null;
		try {
			pr=conn.prepareStatement(sql);
			 re = pr.executeQuery();
			while (re.next()) {
				logis.setId(re.getInt("id"));
				logis.setLogisCode(re.getString("logis_code"));
				logis.setLogisName(re.getString("logis_name"));
				logis.setLogisTel(re.getString("logis_tel"));
				logis.setLogisUrl(re.getString("logis_url"));
				list.add(logis);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn, pr,re );
		}
		return list;
	}
}