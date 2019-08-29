package dao.csr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.db.Dao;
import entity.csr.CsrEntity;
import entity.csrRecord.CsrRecordEntity;
import entity.page.PageEntity;

/**
 * @author :lyy
 * @date :下午2:59:48 2019年5月9日
 *
 */
@Repository
public class CsrDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 添加客服
	 */
	public void insert(CsrEntity csrEntity) {
		String sql = "insert into gf_csr(csr_name,csr_sex,csr_age,csr_tel,csr_path,csr_status,emp_code)values(?,?,?,?,?,?,?);";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		jdbcTemplate.update(sql,csrEntity.getCsrName(),csrEntity.getCsrSex(),csrEntity.getCsrAge(),csrEntity.getCsrTel(),csrEntity.getCsrPath(),csrEntity.getCsrStatus(),csrEntity.getEmpCode());
	}
	
	
	
	/**
	 * 查询客服 (分页)
	 * @param pageEntity 
	 * @param csrName 
	 */
	public List<CsrEntity> queryCsr(String csrName, PageEntity pageEntity){
		String sql = "select * from gf_csr where csr_name like ? limit ?,?";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		int pageNow = (pageEntity.getPageNow()-1) * pageEntity.getPageSize();
		RowMapper<CsrEntity> csRowMapper = new BeanPropertyRowMapper<>(CsrEntity.class);
		List<CsrEntity> list  = jdbcTemplate.query(sql,csRowMapper,"%"+csrName+"%",pageNow,pageEntity.getPageSize());
		return list;
	}
	
	
	
	  	
	 
  /**
   * 	索框 ----->模糊查询 根据名字搜索客服
   * 	@return
   */
	public List<CsrEntity> queryCsrName(String csrName){
		String sql = "select * from gf_csr where csr_name like ?";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		RowMapper<CsrEntity> csRowMapper = new BeanPropertyRowMapper<>(CsrEntity.class);
		List<CsrEntity> list = jdbcTemplate.query(sql,csRowMapper,"%"+csrName+"%");
		
		return list;
	}
	
	
	
	/**
	 * 根据客服编号查询客服聊天记录
	 * 
	 */
	public List<CsrRecordEntity> queryEmpCode(String  code){
		Connection conn = Dao.getConn();// 连接数据库
		String sql = "select * from gf_csr_record where csr_code = ?";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		PreparedStatement ps = null;
		List<CsrRecordEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);// 上传SQL语句到数据库
			ps.setString(1,code);
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
	 * 删除客服
	 */
	public void deleCsr(int code) {
			String sql = "delete from gf_csr where id = ?;";//通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
			jdbcTemplate.update(sql,code);
	}
	
	
	/**
	 * 修改客服数据
	 * 根据ID修改
	 * @param csrEntity
	 * @param id
	 */
	public void updateCsr(CsrEntity csrEntity,int id) {
		String sql = "update gf_csr set csr_name = ?,csr_sex = ?,csr_age = ?,csr_tel = ?,csr_path = ?,csr_status = ?,emp_code = ? where id = ?;";
		jdbcTemplate.update(sql,csrEntity.getCsrName(),csrEntity.getCsrSex(),csrEntity.getCsrAge(),csrEntity.getCsrTel(),csrEntity.getCsrPath(),csrEntity.getCsrStatus(),csrEntity.getEmpCode(),id);
	}
	
	/**
	 * 根据id 回显客服数据
	 * @param id
	 * @return
	 */
	public CsrEntity queryCsrId(int id){
		String sql = "select id,csr_name csrName,csr_sex csrSex,csr_age csrAge,csr_tel csrTel,csr_path csrPath,csr_status csrStatus,emp_code empCode from gf_csr where id = ?";// 通过数据库连接加载指定的SQL语句，预编译sql，一般会使用预编译sql，比较安全
		RowMapper<CsrEntity> mapper = new BeanPropertyRowMapper<>(CsrEntity.class);
		CsrEntity csrEntity = jdbcTemplate.queryForObject(sql, mapper,id);
		return csrEntity;
	}
	
	
	/**
	 * 	查出一共有多少条数据
	 * @return
	 */
	public int pageCount(String csrName) {
		String sql = "select count(*) from gf_csr where csr_name like ?";
		int countNum = jdbcTemplate.queryForObject(sql,Integer.class,"%"+csrName+"%");
		return countNum;
	}

	
	/**
	 * 	 总页数
	 * @param pageCount  总条数
	 * @param pageSize	每页显示页数
	 */
	public int pageCount(int count,int pageSize) {
		int pageCount =1;
		if((count % pageSize) == 0) {
			pageCount = (count/pageSize);
		}else {
			pageCount =(count/pageSize) + 1;
		}
		return pageCount;
	}

}