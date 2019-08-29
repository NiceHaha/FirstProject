package dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.db.Dao;
import entity.account.AccountEntity;

public class AccountDao {
	public static void main(String[] args) {
		AccountDao accountDao = new AccountDao();
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccount("sdfsdfs");
		accountEntity.setPassword("ffssf");
		accountDao.insert(accountEntity);
		accountDao.update(accountEntity, 3);
		accountDao.delete(1);
		accountDao.query();
	}

	/**
	 * 添加账号
	 * 
	 * @throws SQLException
	 */
	public void insert(AccountEntity accountEntity) {
		Connection conn = Dao.getConn();
		String sql = "insert into gf_account(code,account,password)values(?,?,?);";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountEntity.getCode());
			ps.setString(2, accountEntity.getAccount());
			ps.setString(3, accountEntity.getPassword());
			ps.executeUpdate();
			System.out.println("添加");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
	}

	/**
	 * 查询账号
	 */
	public List<AccountEntity> query() {
		Connection conn = Dao.getConn();// 连接数据库
		String sql = "select * from gf_account ";
		PreparedStatement ps = null;
		List<AccountEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);// 上传SQL语句到数据库
			ps.executeQuery();// 执行查询SQL语句
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				AccountEntity accountEntity = new AccountEntity();
				accountEntity.setId(rs.getInt("id"));
				accountEntity.setCode(rs.getString("code"));
				accountEntity.setAccount(rs.getString("account"));
				accountEntity.setPassword(rs.getString("password"));
				list.add(accountEntity);
			}
			System.out.println("查询");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
		return list;
	}

	/**
	 * 删除部门账号
	 */
	public void delete(int code) {
		Connection conn = Dao.getConn();
		PreparedStatement ps = null;
		try {
			String sql = "delete from gf_account where id= ?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, code);// 要删除的ID
			ps.executeUpdate();// 执行删除
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
	}

	/**
	 * 修改账号数据
	 * 
	 * @throws SQLException
	 */
	public void update(AccountEntity accountEntity, int id) {
		Connection conn = Dao.getConn();
		String sql = "update gf_account set account=?,password=? where id= ?;";
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, accountEntity.getAccount());
			ps.setString(2, accountEntity.getPassword());
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println("修改");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
	}
}
