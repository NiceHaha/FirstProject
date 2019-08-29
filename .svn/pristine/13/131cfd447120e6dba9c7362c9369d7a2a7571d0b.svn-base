package dao.depaReciew;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.depa_reciew.DepaReciewEntity;
import entity.page.PageEntity;

/**
 * 部门审核表
 * @author Administrator
 *
 */

@Repository
public class DepaReciewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 添加部门 如果同意添加则把该条数据添加到部门表中 
	 *  不管通不通过数据都会在本表有记录
	 * 
	 * @throws SQLException
	 */
	public void insert(DepaReciewEntity depaReciewEntity) {
		String sql = "insert into gf_depa_reciew(depa_code,depa_name,yes_no,depa_descride)values(?,?,?,?);";
		jdbcTemplate.update(sql,depaReciewEntity.getCode(),depaReciewEntity.getName(),depaReciewEntity.getYesNo(),depaReciewEntity.getDescride());
	}
	
	/**
	 *查询所有部门申请 
	 */
	public List<DepaReciewEntity> query(String deapName,PageEntity pageEntity) {
		String sql = "select id,depa_code code,depa_name name,yes_no yesNo,depa_descride descride from gf_depa_reciew where depa_name like ? LIMIT ?,?";
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		RowMapper<DepaReciewEntity> map = new BeanPropertyRowMapper<>(DepaReciewEntity.class);
		List<DepaReciewEntity> list = jdbcTemplate.query(sql,map,"%"+deapName+"%",pageNow,pageEntity.getPageSize());
		return list;
	}
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count(String depaName) {
		String sql = "select count(*) from gf_depa_reciew where depa_name like ?";
		int count = jdbcTemplate.queryForObject(sql,Integer.class,depaName);
		return count;
	}
	
	/**
	 *根据部门id获取对应的信息 
	 */
	public DepaReciewEntity queryId(int id) {
		String sql = "select id,depa_code code,depa_name name,yes_no yesNo,depa_descride descride from gf_depa_reciew where id = ?";
		RowMapper<DepaReciewEntity> map = new BeanPropertyRowMapper<>(DepaReciewEntity.class);
		DepaReciewEntity depaReciewEntity = jdbcTemplate.queryForObject(sql,map,id);
		return depaReciewEntity;
	}
	
	/**
	 * 删除部门申请  （不会删除部门表中的数据）
	 */
	public void delete(int code) {
		String sql = "delete from gf_depa_reciew where id= ?;";
		jdbcTemplate.update(sql,code);
	}
	
	/**
	 * 修改部门申请状态  比如没有通过的可以改为通过
	 * 
	 * @throws SQLException
	 */
	public void update(DepaReciewEntity depaReciewEntity, int id) {
		String sql = "update gf_depa_reciew set yes_no=? where id= ?;";
		jdbcTemplate.update(sql,depaReciewEntity.getYesNo(),id);
	}
}
