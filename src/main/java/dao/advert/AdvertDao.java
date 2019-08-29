package dao.advert;

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
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import entity.page.PageEntity;

@Repository
public class AdvertDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	  * 添加广告
	 */
	public void insertAdvert(AdvertEntity advert) {
		String sql="insert into GF_advert(advert_url,descride,goods_code,advert_click,advert_show) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, advert.getAdvertUrl(),advert.getDescride(),advert.getGoodsCode(),advert.getAdvertClick(),advert.getAdvertShow());	
	}
	
	/**
	  * 删除广告
	 */
	public int deleteAdvert(Integer id) {
		int mark = 0;
		try {
			String sql = "delete from GF_advert where id=?";
			jdbcTemplate.update(sql,id);
			mark = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mark;
	}
	
	/**
	 * 修改广告
	 */
	public void updateAdvert(AdvertEntity advert) {
		String sql = "update GF_advert set advert_url=?,descride=? where id=?";
		jdbcTemplate.update(sql, advert.getAdvertUrl(), advert.getDescride(),advert.getId());
	}
	
	/**
	 * 修改广告的展示状态
	 */
	public int updateAdvertShow(Integer advertShow,Integer id) {
		int mark = 0;
		try {
			String sql = "update GF_advert set advert_show = ? where id=?";
			jdbcTemplate.update(sql,advertShow,id);
			mark=1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mark;//修改成功返回1，修改失败返回0
	}
	
	/*根据商品编号查询商品，得到图片路径，用于新增广告*/
//	public String queryAdvertGood(String goodsCode) {
//		String adventUrl ="";
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = Dao.getConn();
//			String sql="select goods_path from GF_goods where code = ?";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, goodsCode);
//			ps.executeQuery();
//			rs = ps.getResultSet();
//			while(rs.next()) {
//				adventUrl = rs.getString(1);	
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			Dao.closeConn(conn, ps, rs);
//		}
//		return adventUrl;
//	}
	
	/**
	 * 根据商品id查询单条广告数据， 用于修改时回显
	 */
	public AdvertEntity queryOneAdvert(Integer id) {
		RowMapper<AdvertEntity> rowMapper = new BeanPropertyRowMapper<>(AdvertEntity.class);
		String sql="select id,advert_url as advertUrl,descride,goods_code as goodsCode,advert_click as advertClick,advert_show as advertShow from GF_advert where id = ?";
		AdvertEntity advert = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return advert;
	}
	
	/**
	 * 查询所有广告，用List接
	 */
	public List<AdvertEntity> queryAdvert() {
		RowMapper<AdvertEntity> rowMapper = new BeanPropertyRowMapper<>(AdvertEntity.class);
		String sql="select id,advert_url as advertUrl,descride,goods_code as goodsCode,advert_click as advertClick,advert_show as advertShow from GF_advert";
		List<AdvertEntity> listAdvert = jdbcTemplate.query(sql, rowMapper);
		return listAdvert;
	}
	
	/**
	  * 分页查询，用List接
	 */
	public List<AdvertEntity> queryAdvertPage(PageEntity page) {
		RowMapper<AdvertEntity> rowMapper = new BeanPropertyRowMapper<>(AdvertEntity.class);
		//查询总条数
		String countSql = "select count(*) from GF_advert";
		Integer count = jdbcTemplate.queryForObject(countSql, Integer.class);
		//给page设总条数
		page.setCount(count);

		//分页查询
		String pageSql="select id,advert_url as advertUrl,descride,goods_code as goodsCode,advert_click as advertClick,advert_show as advertShow from GF_advert limit ?,?";
		/* 起始下标 */
		int pageStartIndex = (page.getPageNow() - 1) * page.getPageSize();
		/* 每页显示多少条 */
		int pageSize = page.getPageSize();
		
		List<AdvertEntity> listAdvert = jdbcTemplate.query(pageSql, rowMapper ,pageStartIndex,pageSize);
		return listAdvert;
	}	
}
