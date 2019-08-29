package dao.agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.db.Dao;
import entity.agent.Agent;
import entity.page.PageEntity;

@Repository
public class AgentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 放入代理商名称查询到它的code
	 * @param name
	 * @return code
	 */
	public String agentcode(String name) {
		String sql = "select agent_code from gf_agent where agent_name = ?";
		String code = jdbcTemplate.queryForObject(sql, String.class,name);
		return code;
	}
	
	/**
	 * 代理查询(分页，模糊查询)
	 * @return list
	 */
	public List<Agent> select(String str,PageEntity pageEntity) {
		String sql = "select * from gf_agent where agent_name like ? LIMIT ?,?";
		RowMapper<Agent> row = new BeanPropertyRowMapper<>(Agent.class);
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		List<Agent> list = jdbcTemplate.query(sql, row,"%"+str+"%",pageNow,pageEntity.getPageSize());
		return list;
		
	}
	
	/**
	 * 代理查询
	 * @return list
	 */
	public List<Agent> agentquery() {
		String sql = "select * from gf_agent";
		RowMapper<Agent> row = new BeanPropertyRowMapper<>(Agent.class);
		List<Agent> list = jdbcTemplate.query(sql,row);
		return list;
	}
	
	/**
	 * 通过传入一个品牌名字获取到品牌的编码	gn
	 * @param name
	 * @return
	 */
	public String selectcode(String name) {
		String sql = "select code from gf_brand where brand_name = ?";
		String code = jdbcTemplate.queryForObject(sql, String.class,name);
		return code;
	}
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int agentCount(String name) {
		String sql = "select count(*) from gf_agent where agent_name like ?";
		int count = jdbcTemplate.queryForObject(sql, int.class,"%"+name+"%");
		return count;
	}
	
	/**
	 * 总页数
	 * @param pageCount  总条数
	 * @param pageSize	每页显示页数
	 */
	public int pageCount(int count,int pageSize) {
		int pageCount = 1;
		if((count % pageSize) == 0) {
			pageCount = (count/pageSize);
		}else {
			pageCount =(count/pageSize) + 1;
		}
		return pageCount;
	}
	
	
	/**
	 * 代理添加
	 * @param brand
	 */
	public void insert(Agent agent) {
		String sql = "insert into gf_agent (agent_name,agent_city,agent_tel,brand_code,brand_name,agent_code) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{agent.getAgent_name(),agent.getAgent_city(),agent.getAgent_tel(),agent.getBrand_code(),agent.getBrand_name(),agent.getAgent_code()});
	}
	
	/**
	 * 代理修改
	 * @param brand
	 */
	public void update(Agent agent) {
		String sql = "update gf_agent set agent_name = ?,agent_city = ?,agent_tel = ?,brand_code = ?,brand_name = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] {agent.getAgent_name(),agent.getAgent_city(),agent.getAgent_tel(),agent.getBrand_code(),agent.getBrand_name(),agent.getId()});
	}
	/**
	 * 删除代理
	 * @param id
	 */
	public void delete(int id) {
		String sql = "delete from gf_agent where id = ?";
		jdbcTemplate.update(sql,id);
	}
	
	/**
	 * 数据回显
	 * @param id
	 * @return brand
	 */
	public Agent get(int id) {
		String sql = "select * from gf_agent where id = ?";
		RowMapper<Agent> map = new BeanPropertyRowMapper<>(Agent.class);
		Agent agent = jdbcTemplate.queryForObject(sql,map,id);
		return agent;
	}
	
	/**
	 * 查询是否有相同的代理名存在
	 * @param name
	 * @return a
	 */
	public int count(String name) {
		String sql = "select count(*) from gf_agent where agent_name = ?";
		int a = jdbcTemplate.queryForObject(sql, int.class,name);
		return a;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Agent> Query(String name) {
		String sql = "select agent_name from gf_agent where brand_name = ?";
		RowMapper<Agent> row = new BeanPropertyRowMapper<>(Agent.class);
		List<Agent> list = jdbcTemplate.query(sql,row,name);
		return list;
	}
}
