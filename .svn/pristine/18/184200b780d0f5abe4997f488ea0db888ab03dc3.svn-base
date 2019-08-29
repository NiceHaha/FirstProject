package dao.goods;

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
import entity.goods.GoodsEntity;
import entity.page.PageEntity;
/**
 * 
 * @author guoning
 *
 * 2019年5月30日下午3:27:04
 */

@Repository
public class GoodsDao {	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 新增
	 * @param goods
	 */
	public void add(GoodsEntity goods){
		String sql="insert into GF_goods(goods_name,goods_price,goods_path,goods_describe,goods_color,type_code,code,agent_code)values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,goods.getGoodsName(), goods.getGoodsPrice(), goods.getGoodsPath(), goods.getGoodsDescribe(), goods.getGoodsColor(), goods.getTypeCode(), goods.getCode(), goods.getAgentCode());
	} 
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id){
		String sql="delete from GF_goods where id=?";
		jdbcTemplate.update(sql,id);
	}
	
	/**
	 * 修改
	 * @param goods
	 */
	public void update(GoodsEntity goods){
		String sql="update GF_goods set goods_name=?,goods_price=?,goods_path=?,goods_describe=?,goods_color=?,type_code=?,code=? where id=?";
		jdbcTemplate.update(sql,goods.getGoodsName(), goods.getGoodsPrice(), goods.getGoodsPath(), goods.getGoodsDescribe(), goods.getGoodsColor(), goods.getTypeCode(), goods.getCode(), goods.getId());
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<GoodsEntity> Query() {
		String sql = "select code from gf_goods";
		RowMapper<GoodsEntity> row=new BeanPropertyRowMapper<>(GoodsEntity.class);
		List<GoodsEntity> list=jdbcTemplate.query(sql, row);
		return list;
	}
	
	/**
	 * 分页模糊查询
	 * @param dataName
	 * @param page
	 * @return
	 */
	public List<GoodsEntity> Query(String dataName,PageEntity page) {
		if(dataName==null)
			dataName="";
		int pageNow = (page.getPageNow() - 1) * page.getPageSize();
		String sql = "select id,goods_name as goodsName,goods_price as goodsPrice,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,code,agent_code as agentCode from gf_goods where goods_name like ? LIMIT ?,? ";
		RowMapper<GoodsEntity> row=new BeanPropertyRowMapper<>(GoodsEntity.class);
		List<GoodsEntity> list =jdbcTemplate.query(sql, row,"%"+dataName+"%",pageNow,page.getPageSize());
		return list;
	}
	
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int pageCount(String dataName) {
		if(dataName==null)
			dataName="";
		String sql = "select count(*) from gf_goods where goods_name like ?";
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"%"+dataName+"%");
		return count;
	}
	
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	public GoodsEntity Query1(int id) {
		String sql = "select id,goods_name as goodsName,goods_price as goodsPrice,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,code,agent_code as agentCode from gf_goods where id=?";
		RowMapper<GoodsEntity> row=new BeanPropertyRowMapper<>(GoodsEntity.class);
		GoodsEntity goods= jdbcTemplate.queryForObject(sql, row,id);
		return goods;
	}
	
	/**
	 * 判断名字是否存在
	 * @param name
	 * @param id
	 * @return
	 */
	public int Query(String name,int id) {
		String sql = "select count(*) from gf_goods where goods_name=? and id!=? ";
		int num= jdbcTemplate.queryForObject(sql, Integer.class,name,id);
		return num;
	}

}
