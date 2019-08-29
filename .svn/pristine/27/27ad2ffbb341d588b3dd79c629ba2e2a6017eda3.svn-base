package dao.depa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.depa.DepaEntity;
import entity.page.PageEntity;

/**
 * 部门审核
 * @author Administrator
 *
 */
@Repository
public class DepaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 添加部门
	 * 
	 * @throws SQLException
	 */
	public void insert(DepaEntity depaEntity) {
		String sql = "insert into gf_depa(depa_code,depa_name)values(?,?);";
		jdbcTemplate.update(sql,depaEntity.getCode(),depaEntity.getName());
	}
	
	/**
	 * 查询部门
	 */
	public List<DepaEntity> query(String depaName,PageEntity pageEntity) {
		String sql = "select id,depa_code code,depa_name name from gf_depa where depa_name like ? LIMIT ?,?";
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		RowMapper<DepaEntity> map = new BeanPropertyRowMapper<>(DepaEntity.class);
		List<DepaEntity> list =jdbcTemplate.query(sql,map,"%"+depaName+"%",pageNow,pageEntity.getPageSize());
		return list;
	}
	
	/**
	 * 查出所有部门名称
	 * @param pageEntity
	 * @return
	 */
	public List<DepaEntity> query() {
			String sql = "select id,depa_code code,depa_name name from gf_depa";
			RowMapper<DepaEntity> map = new BeanPropertyRowMapper<>(DepaEntity.class);
			List<DepaEntity> list = jdbcTemplate.query(sql,map);
			return list;
		}
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count(String depaName) {
		String sql = "select count(*) from gf_depa where depa_name like ?";
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"%"+depaName+"%");
		return count;
	}
	/**
	 * 模糊查询
	 */
	public List<DepaEntity> query(String depaName) {
		String sql = "select id,depa_code code,depa_name name from gf_depa where depa_name like ?";
		RowMapper<DepaEntity> map = new BeanPropertyRowMapper<>(DepaEntity.class);
		List<DepaEntity> list = jdbcTemplate.query(sql,map);
		return list;
	}
	
	/**
	 * 根据部门名字查出部门部门编号
	 */
	public String queryName(String name) {
		String sql = "select depa_code from gf_depa where depa_name = ?";
		String code = jdbcTemplate.queryForObject(sql,String.class,name);
		return code;
	}
	
	/**
	 * 根据部门code查出部门名称
	 */
	public String queryCode(String code) {
		String sql = "select depa_name from gf_depa where depa_code = ?";
		String name = jdbcTemplate.queryForObject(sql,String.class,code);
		return name;
	}
	
	/**
	 * 删除部门数据
	 */
	public void delete(int code) {
			String sql = "delete from gf_depa where id= ?;";
			jdbcTemplate.update(sql,code);
	}
	/**
	 * 根据id查出部门
	 */
	public DepaEntity queryId(int id) {
		String sql = "select id,depa_code code,depa_name name from gf_depa where id = ?";
		RowMapper<DepaEntity> map = new BeanPropertyRowMapper<>(DepaEntity.class);
		DepaEntity depaEntity = jdbcTemplate.queryForObject(sql,map,id);
		return depaEntity;
	}
	/**
	 * 修改部门数据
	 * 
	 * @throws SQLException
	 */
	public void update(DepaEntity depaEntity, int id) {
		String sql = "update gf_depa set depa_name=? where id= ?;";
		jdbcTemplate.update(sql,depaEntity.getName(),id);
	}
}
