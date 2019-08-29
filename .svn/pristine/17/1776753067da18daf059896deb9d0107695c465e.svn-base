package dao.emp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.emp.EmpEntity;
import entity.page.PageEntity;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 添加用户数据
	 * 
	 * @throws SQLException
	 */
	public void insert(EmpEntity empEntity) {
		String sql = "insert into gf_emp(emp_name,emp_sex,emp_age,emp_tel,emp_root,emp_addr,emp_position,emp_state,emp_code,depa_code,depa_name,account,password)"
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sql,empEntity.getName(),empEntity.getSex(),empEntity.getAge(),empEntity.getTel(),empEntity.getRoot(),empEntity.getAddr(),empEntity.getPosition()
				,empEntity.getState(),empEntity.getEmpCode(),empEntity.getDepaCode(),empEntity.getDepaName(),empEntity.getAccount(),empEntity.getPassword());
	}
	
	/**
	 * 查询用户
	 */
	public List<EmpEntity> query(String empName,PageEntity pageEntity) {
		String sql = "select id,emp_name name,emp_sex sex,emp_age age,emp_tel tel,emp_root root,emp_addr addr,emp_position position,emp_state state,emp_code empCode,depa_code depaCode,depa_name depaName,account account,password password from gf_emp where emp_name like ? limit ?,?";
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		RowMapper<EmpEntity> map = new BeanPropertyRowMapper<>(EmpEntity.class);
		List<EmpEntity> list = jdbcTemplate.query(sql,map,"%"+empName+"%",pageNow,pageEntity.getPageSize());
		System.out.println(list);
		return list;
	}
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count(String empName) {
		String sql = "select count(*) from gf_emp where emp_name like ?";
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"%"+empName+"%");
		return count;
	}
	
	/**
	 * 根据ID查出所对应的数据c
	 */
	public EmpEntity queryid(int id) {
		String sql = "select id,emp_name name,emp_sex sex,emp_age age,emp_tel tel,emp_root root,emp_addr addr,emp_position position,emp_state state,emp_code empCode,depa_code depaCode,depa_name depaName,account account,password password from gf_emp where id=?";
		RowMapper<EmpEntity> mapper = new BeanPropertyRowMapper<EmpEntity>(EmpEntity.class);
		EmpEntity empEntity = jdbcTemplate.queryForObject(sql, mapper,id);
		return empEntity;
	}


	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		String sql = "delete from gf_emp where id=?;";
		jdbcTemplate.update(sql,code);
	}

	/**
	 * 修改用户数据
	 * @throws SQLException
	 */
	public void update(EmpEntity empEntity, int id) {
		String sql = "update gf_emp set emp_name= ?,emp_sex= ?,emp_age= ?,emp_tel= ?,emp_root= ?,emp_addr= ?,emp_position= ?,emp_state= ?,depa_code= ?,depa_name= ?,account= ?,password= ? where id= ?;";
		jdbcTemplate.update(sql,empEntity.getName(),empEntity.getSex(),empEntity.getSex(),empEntity.getTel(),empEntity.getRoot(),empEntity.getAddr(),empEntity.getPosition(),empEntity.getState()
				,empEntity.getDepaCode(),empEntity.getDepaName(),empEntity.getAccount(),empEntity.getPassword(),id);
	}
}
