package dao.csrRecord;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.db.Dao;
import entity.csrRecord.CsrRecordEntity;
import entity.page.PageEntity;

/**
 * 客服记录
 * @author :lyy
 * @date :下午2:58:21 2019年5月10日
 *	
 *
 *	该功能未实现！！！
 */
public class CsrRecordDao {
	
	
	/**
	 * 添加客服聊天记录
	 * @param csrEntity
	 */
	public void insert(CsrRecordEntity csrRecordEntity) {
		Connection conn = Dao.getConn();//调用链接数据库方法
		PreparedStatement ps = null;
		try {
			String sql = "insert into gf_csr_record(user_code,csr_code,csr_name,user_name,start_tade,end_tade,total_tade,record_csat,record_content)values(?,?,?,?,now(),?,now()-"+csrRecordEntity.getStartTade()+",?,?);";
			ps = (PreparedStatement) conn.prepareStatement(sql);//执行sql
			ps.setString(1,csrRecordEntity.getUserCode());//用户编号
			ps.setString(2,csrRecordEntity.getCsrCode());//客服编号
			ps.setString(3,csrRecordEntity.getCsrName());//客服名字
			ps.setString(4,csrRecordEntity.getUserName());//用户名字
			ps.setDate(6,new Date(csrRecordEntity.getEndTade().getTime()));//结束时间
			ps.setString(8,csrRecordEntity.getRecordCsat());//满意度
			ps.setString(9,csrRecordEntity.getRecordContent());//具体内容
			ps.executeUpdate(sql);//执行添加
			System.out.println("数据添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
	}
	
	
	/**
	 * 查询客服记录
	 */
	public List<CsrRecordEntity> queryCsr(String csrName,PageEntity pageEntity){
		Connection conn = Dao.getConn();// 连接数据库
		String sql = "select * from gf_csr_record where csr_name like ? limit ?,?;";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		PreparedStatement ps = null;
		List<CsrRecordEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);// 上传SQL语句到数据库
			if(csrName == null) {
				csrName = "";
			}
			int pageNow = (pageEntity.getPageNow()-1) * pageEntity.getPageSize();
			ps.setString(1,"%"+csrName +"%");
			ps.setInt(2,pageNow);
			ps.setInt(3,pageEntity.getPageSize());
			ps.executeQuery();// 执行查询SQL语句
			ResultSet rs = ps.getResultSet(); 
			while (rs.next()) {
				CsrRecordEntity csrRecordEntity = new CsrRecordEntity();
				csrRecordEntity.setId(rs.getInt("id"));
				csrRecordEntity.setUserCode(rs.getString("user_code"));//用户编号
				csrRecordEntity.setCsrCode(rs.getString("csr_code"));//客服编号
				csrRecordEntity.setCsrName(rs.getString("csr_name"));//客服名字
				csrRecordEntity.setUserName(rs.getString("user_name"));//用户名字
				csrRecordEntity.setStartTade(rs.getDate("start_tade"));//开始时间
				csrRecordEntity.setEndTade(rs.getDate("end_tade"));//结束时间
				csrRecordEntity.setTotalTade(rs.getDate("total_tade"));//接待时长
				csrRecordEntity.setRecordCsat(rs.getString("record_csat"));//满意度
				csrRecordEntity.setRecordContent(rs.getString("record_content"));//具体内容
				list.add(csrRecordEntity);
			}
		}catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			Dao.closeConn(conn, ps, null);
		}
		return list;
	}
	
	
	/**
	 * 根据ID查出客服编号
	 */
	public String queryCsrId(int id){
		Connection conn = Dao.getConn();// 连接数据库
		String sql = "select * from gf_csr_record where id = ?";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		PreparedStatement ps = null;
		String csrName = null;
		try {
			ps = conn.prepareStatement(sql);// 上传SQL语句到数据库
			ps.setInt(1,id);
			ps.executeQuery();// 执行查询SQL语句
			ResultSet rs = ps.getResultSet();
			rs.next();
			csrName = rs.getString("csr_code");//客服编号
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
		return csrName;
	}
	


	/**
	 * 删除客服记录数据
	 */
	public void deleCsr(int code) {
		Connection con = Dao.getConn();//连接数据库
		PreparedStatement ps = null;//来执行SQL查询语句
		try {
			String sql = "delete from gf_csr_record where id = ?;";//通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
			ps = con.prepareStatement(sql);//上传SQL语句到数据库
			ps.setInt(1,code);//要删除的id
			ps.executeUpdate();//执行删除
			System.out.println("删除成功");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Dao.closeConn(con, ps, null);
		}
	}
	
	
	/**
	 * 修改客服记录数据
	 * @param csrEntity
	 * @param id
	 */
	public void updateCsr(CsrRecordEntity csrRecordEntity,int id) {
		Connection conn = Dao.getConn();//连接数据库
		String sql = "update gf_csr set user_code = ?,csr_code = ?,csr_name = ?,user_name = ?,start_tade = ?,end_tade = ?,total_tade = ?，record_csat = ?,record_content = ? where id = ?;";
		PreparedStatement ps = null;//来执行SQL查询语句
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,csrRecordEntity.getUserCode());//用户编号
			ps.setString(2,csrRecordEntity.getCsrCode());//客服编号
			ps.setString(3,csrRecordEntity.getCsrName());//客服名字
			ps.setString(4,csrRecordEntity.getUserName());//用户名字
			ps.setDate(5,new Date(csrRecordEntity.getStartTade().getTime()));//开始时间
			ps.setDate(6,new Date(csrRecordEntity.getEndTade().getTime()));//结束时间
			ps.setDate(7,new Date(csrRecordEntity.getTotalTade().getTime()));//接待时长
			ps.setString(8,csrRecordEntity.getRecordCsat());//满意度
			ps.setString(9,csrRecordEntity.getRecordContent());//具体内容
			ps.execute();//execute()表示通用
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn, ps, null);
		}
	}
	
	
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count() {
		Connection conn = Dao.getConn();// 连接数据库
		String sql = "select count(*) from gf_csr";
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);// 上传SQL语句到数据库
			ps.executeQuery();// 执行查询SQL语句
			ResultSet rs = ps.getResultSet();
			rs.next();
			count = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConn(conn, ps, null);
		}
		return count;
	}
}
