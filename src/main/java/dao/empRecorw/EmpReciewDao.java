package dao.empRecorw;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import entity.empReciew.EmpRecorEntity;
import entity.page.PageEntity;

@Repository
public class EmpReciewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 添加用户数据
	 * 
	 * @throws SQLException
	 */
	public void insert(EmpRecorEntity empRecorEntity) {
		String sql = "insert into gf_emp_reciew(emp_name,emp_sex,emp_age,emp_tel,emp_addr,emp_position,emp_state,dapa_code,emp_account,emp_password)"
		+"values(?,?,?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql,empRecorEntity.getName(),empRecorEntity.getSex(),empRecorEntity.getAge(),empRecorEntity.getTel(),empRecorEntity.getAddr(),empRecorEntity.getPosition()
				,empRecorEntity.getState(),empRecorEntity.getDepaCode(),empRecorEntity.getAccount(),empRecorEntity.getPassword());
	}

	/**
	 * 查询用户
	 */
	public List<EmpRecorEntity> query(String empName,PageEntity pageEntity) {
		String sql = "select id,emp_name name,emp_sex sex,emp_age age,emp_tel tel,emp_addr addr,emp_position postion,emp_state state,dapa_code code,emp_account account,emp_password password from gf_emp_reciew where emp_name like ? limit ?,?";
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		RowMapper<EmpRecorEntity> mapper = new BeanPropertyRowMapper<EmpRecorEntity>(EmpRecorEntity.class);
		List<EmpRecorEntity> list = jdbcTemplate.query(sql,mapper,"%"+empName+"%",pageNow,pageEntity.getPageSize());
		System.out.println(list);
		return list;
	}
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count(String empName) {
		String sql = "select count(*) from gf_emp_reciew where emp_name like ?";
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"%"+empName+"%");
		return count;
	}
	
	
	/**
	 *根据id查出所对应的数据
	 */
	public EmpRecorEntity queryId(int id) {
		String sql = "select id,emp_name name,emp_sex sex,emp_age age,emp_tel tel,emp_addr addr,emp_position postion,emp_state state,dapa_code code,emp_account account,emp_password password from gf_emp_reciew where id = ?";
		RowMapper<EmpRecorEntity> mapper = new BeanPropertyRowMapper<EmpRecorEntity>(EmpRecorEntity.class);
		EmpRecorEntity empRecorEntity = jdbcTemplate.queryForObject(sql,mapper,id);
		return empRecorEntity;
	}

	

	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		String sql = "delete from gf_emp_reciew where id= ?;";
		jdbcTemplate.update(sql,code);
	}
}
