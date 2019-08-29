package dao.login;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.db.Dao;
import entity.emp.EmpEntity;
import entity.user.UserEntity;

@Repository
public class Flogindb {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int checkUser(String username,String password) {
		int mark=0;
		try {
			String sql="select count(*) from GF_user where user_account=? and user_password=?";
			 mark=jdbcTemplate.queryForObject(sql,Integer.class,username,password);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mark;
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		try {
//			String sql="select count(*) from GF_user where user_account=? and user_password=?";		
//			
//			conn=Dao.getConn();//获取连接
//			
//			ps=conn.prepareStatement(sql);//发送sql到数据库
//			ps.setString(1, username);
//			ps.setString(2, password);
//			ps.executeQuery();//执行查询
//			rs=ps.getResultSet();
//			rs.next();
//			mark=rs.getInt(1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			Dao.closeConn(conn,ps,rs);
//		}
//		return mark;
	}

	public int ajaxcha(String useraccount) {
		int mark=0;
		try {
			String sql="select count(*) from GF_user where user_account=?";
			mark=jdbcTemplate.queryForObject(sql, Integer.class,useraccount);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mark;
//		int mark=0;
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		
//		try {
//			String sql="select count(*) from GF_user where user_account=?";		
//			
//			conn=Dao.getConn();//获取连接
//			
//			ps=conn.prepareStatement(sql);//发送sql到数据库
//			ps.setString(1, useraccount);
//			
//			ps.executeQuery();//执行查询
//			rs=ps.getResultSet();
//			rs.next();
//			mark=rs.getInt(1);//得到第一条结果
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			Dao.closeConn(conn,ps,rs);
//		}
//		return mark;
	}
	
	
	public void fzeng(UserEntity userentity) throws Exception {
		String sql="insert into GF_user(user_account,user_password,user_name,user_sex,user_age,user_tel,user_addr)values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, userentity.getAccount(),userentity.getPassword(),userentity.getName(),userentity.getSex(),userentity.getAge(),userentity.getTel(),userentity.getAddr());
		
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		try {
//			String sql="insert into GF_user(user_account,user_password,user_name,user_sex,user_age,user_tel,user_addr)values(?,?,?,?,?,?,?)";
//			conn=Dao.getConn();//获取连接
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, userentity.getAccount());
//			ps.setString(2, userentity.getPassword());
//			ps.setString(3, userentity.getName());
//			ps.setInt(4, userentity.getSex());
//			ps.setInt(5, userentity.getAge());
//			ps.setString(6, userentity.getTel());
//			ps.setString(7, userentity.getAddr());
//			
//			
//			
//			ps.executeUpdate();//执行
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			Dao.closeConn(conn,ps,rs);
//		}
	}
	
	
}
