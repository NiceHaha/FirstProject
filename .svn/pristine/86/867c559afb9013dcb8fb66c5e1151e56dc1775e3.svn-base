package dao.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.brand.Brand;
import entity.page.PageEntity;
@Repository
public class BrandDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 品牌查询
	 * @return list
	 */
	public List<Brand> select(String str,PageEntity pageEntity) {
		String sql = "select * from gf_brand where brand_name like ? LIMIT ?,?";
		RowMapper<Brand> rowMapper = new BeanPropertyRowMapper<>(Brand.class);
		int pageNow = (pageEntity.getPageNow() - 1) * pageEntity.getPageSize();
		List<Brand> list = jdbcTemplate.query(sql, rowMapper,"%"+str+"%",pageNow,pageEntity.getPageSize());
		return list;
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
	 * 查出一共有多少条数据
	 * @return
	 */
	public int brandCount(String name) {
		String sql = "select count(*) from gf_brand where brand_name like ?";
		int count = jdbcTemplate.queryForObject(sql, int.class,"%"+name+"%");
		return count;
	}
	
	//通过传入一个品牌名字获取到品牌的编码	gn
	public String selectcode(String name) {
		String sql = "select code from gf_brand where brand_name=?";
		String code = jdbcTemplate.queryForObject(sql, String.class,name);
		return code;
	}
	
	/**
	 * 品牌添加
	 * @param brand
	 */
	public void insert(Brand brand) {
		String sql = "insert into gf_brand (brand_name,brand_tel,code,brand_url) values (?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {brand.getBrand_name(),brand.getBrand_tel(),brand.getCode(),brand.getBrand_url()});
	}
	
	/**
	 * 品牌修改
	 * @param brand
	 */
	public void update(Brand brand) {
		String sql = "update gf_brand set brand_name = ?,brand_tel = ?,brand_url = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] {brand.getBrand_name(),brand.getBrand_tel(),brand.getBrand_url(),brand.getId()});
	}
	
	/**
	 * 删除品牌
	 * @param id
	 */
	public void delete(int id) {
		String sql = "delete from gf_brand where id = ?";
		jdbcTemplate.update(sql,id);
	}
	
	/**
	 * 删除品牌并且删除品牌下的商品
	 * @param code
	 */
	public void deletegoods(String code) {
		String sql = "delete from gf_goods where type_code = ?";
		jdbcTemplate.update(sql,code);
	}
	/**
	 * 删除品牌并且改变代理商的值
	 * @param code
	 */
	public void deleteag(String code) {
		String sql = "update gf_agent set brand_name = null ,brand_code = null where brand_code = ?";
		jdbcTemplate.update(sql,code);
	}
	
	/**
	 * 数据回显
	 * @param id
	 * @return brand
	 */
	public Brand get(int id) {
		String sql = "select * from gf_brand where id = ?";
		RowMapper<Brand> map = new BeanPropertyRowMapper<>(Brand.class);
		Brand brand = jdbcTemplate.queryForObject(sql,map,id);
		return brand;
	}
	
	/**
	 * 查询是否有相同的品牌存在
	 * @param name
	 * @return a
	 */
	public int count(String name) {
		String sql = "select count(*) from gf_brand where brand_name = ?";
		int a = jdbcTemplate.queryForObject(sql, int.class,name);
		return a;
	}
	
	/**
	 * 下拉框查询
	 */
	public List<Brand> query() {
		String sql = "select * from gf_brand";
		RowMapper<Brand> map = new BeanPropertyRowMapper<>(Brand.class);
		List<Brand> list = jdbcTemplate.query(sql,map);
		System.out.println(list);
		return list;
	}
}
	
