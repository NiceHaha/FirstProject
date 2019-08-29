package dao.goodsreciew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import dao.base.BaseDao;
import dao.db.Dao;
import entity.goodsreciew.GoodsReciewEntity;
import entity.page.PageEntity;
//商品审核表
@Repository
public class GoodsReciewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//新增
	public void add(GoodsReciewEntity goodsr){
		String sql="insert into gf_goods_reciew(goods_code,goods_name,goods_price,goods_num,goods_path,goods_describe,goods_color,type_code,agent_code,goods_to)values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,goodsr.getGoodsCode(), goodsr.getGoodsName(), goodsr.getGoodsPrice(), goodsr.getGoodsNum(), goodsr.getGoodsPath(), goodsr.getGoodsDescribe(), goodsr.getGoodsColor(), goodsr.getTypeCode(), goodsr.getAgentCode(), goodsr.getGoodsTo());
	} 
	
	//删除
	public void delete(int id) {
		
		String sql="delete from GF_goods_reciew where id=?";
		jdbcTemplate.update(sql,id);
	}
	
	
	//修改
	public void update(GoodsReciewEntity goodsr){
		String sql="update GF_goods_reciew set goods_code=?,goods_name=?,goods_price=?,goods_num=?,goods_path=?,goods_describe=?,goods_color=?,type_code=?,agent_code=?,goods_to=? where id=?";
		jdbcTemplate.update(sql,goodsr.getGoodsCode(), goodsr.getGoodsName(), goodsr.getGoodsPrice(),goodsr.getGoodsNum(), goodsr.getGoodsPath(),goodsr.getGoodsDescribe(), goodsr.getGoodsColor(), goodsr.getTypeCode(), goodsr.getAgentCode(), goodsr.getGoodsTo(), goodsr.getId());
	}
	
	
	//查询
	public List<GoodsReciewEntity> query(){
		String sql="select id,goods_code as goodsCode,goods_name as goodsName,goods_price as goodsPrice,goods_num as goodsNum,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,agent_code as agentCode,goods_to as goodsTo from GF_goods_reciew";
		RowMapper<GoodsReciewEntity> row=new BeanPropertyRowMapper<>(GoodsReciewEntity.class);
		List<GoodsReciewEntity> list=jdbcTemplate.query(sql, row);
		return list;
	}
	
	//分页 dataName是模糊查询
		public  List<GoodsReciewEntity> query3(String  dataName,PageEntity page){
			if(dataName==null)
			dataName="";
			int pageNow = (page.getPageNow() - 1) * page.getPageSize();
			String sql="select id,goods_code as goodsCode,goods_name as goodsName,goods_price as goodsPrice,goods_num as goodsNum,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,agent_code as agentCode,goods_to as goodsTo from GF_goods_reciew where goods_name like ?  LIMIT ?,?";
			RowMapper<GoodsReciewEntity> row=new BeanPropertyRowMapper<>(GoodsReciewEntity.class);
			List<GoodsReciewEntity> list= jdbcTemplate.query(sql, row,"%"+dataName+"%",pageNow,page.getPageSize());
			return list;
		}
		
		
		/**
		 * 查出一共有多少条数据
		 * @return
		 */
		public int pageCount(String  dataName) {
			if(dataName==null)
				dataName="";
			String sql = "select count(*) from GF_goods_reciew where goods_name like ?";
			int count=jdbcTemplate.queryForObject(sql, Integer.class,"%"+dataName+"%");
			return count;
		}
	
	//传入一个id获取一个List
	public List<GoodsReciewEntity> query(int id){
		String sql="select id,goods_code as goodsCode,goods_name as goodsName,goods_price as goodsPrice,goods_num as goodsNum,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,agent_code as agentCode,goods_to as goodsTo from GF_goods_reciew where id=?";
		RowMapper<GoodsReciewEntity> row=new BeanPropertyRowMapper<>(GoodsReciewEntity.class);
		List<GoodsReciewEntity> list=jdbcTemplate.query(sql, row,id);
		return list;
	}
	
	
	
		//通过ID查出那一条图片地址
		
	//通过ID查出那条数据 返回一个对象
	public GoodsReciewEntity query1(int id){
		String sql="select id,goods_code as goodsCode,goods_name as goodsName,goods_price as goodsPrice,goods_num as goodsNum,goods_path as goodsPath,goods_describe as goodsDescribe,goods_color as goodsColor,type_code as typeCode,agent_code as agentCode,goods_to as goodsTo from GF_goods_reciew where id=?";
		RowMapper<GoodsReciewEntity> row=new BeanPropertyRowMapper<>(GoodsReciewEntity.class);
		GoodsReciewEntity goods=jdbcTemplate.queryForObject(sql,row,id);
		System.out.println(goods);
		return goods;
	}
	
	
	/**
	 * 判断名字是否重复
	 * @param name
	 * @return
	 */
	public int query4(String  name){
		String sql="select count(*) from GF_goods_reciew where goods_name=?";
		int nub=jdbcTemplate.queryForObject(sql,Integer.class ,name);
		return nub;
	}
	
	public int query4(String name ,int id){
		String sql="select count(*) from GF_goods_reciew where goods_name=? and id!=?";
		int nub=jdbcTemplate.queryForObject(sql,Integer.class ,name,id);
		return nub;
	}
}
