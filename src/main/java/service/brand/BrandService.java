package service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.brand.BrandDao;
import entity.brand.Brand;
import entity.page.PageEntity;
@Service
public class BrandService {
	@Autowired
	private BrandDao brd;
	/**
	 * 品牌查询
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List<Brand> select(String str,PageEntity pageEntity) {
		List<Brand> list = brd.select(str,pageEntity);
		return list;
	}
	/**
	 * 品牌添加
	 * @param brand
	 */
	@Transactional
	public void insert(Brand brand) {
		brd.insert(brand);
	}
	/**
	 * 品牌修改
	 * @param brand
	 */
	@Transactional
	public void update(Brand brand) {
		brd.update(brand);
	}
	/**
	 * 品牌删除
	 * @param brand
	 */
	@Transactional
	public void delete(int id) {
		brd.delete(id);
	}
	/**
	 * 数据回显
	 * @param id
	 * @return brand
	 */
	@Transactional(readOnly = true)
	public Brand get(int id) {
		Brand brand = brd.get(id);
		return brand;
	}
	/**
	 * 查询是否有相同的品牌存在
	 * @param name
	 * @return a
	 */
	@Transactional(readOnly = true)
	public int count(String name) {
		int cou =brd.count(name);
		return cou;
	}
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	@Transactional(readOnly = true)
	public int brandCount(String name) {
		int count = brd.brandCount(name);
		return count;
	}
	/**
	 * 总页数
	 * @param pageCount  总条数
	 * @param pageSize	每页显示页数
	 */
	@Transactional(readOnly = true)
	public int pageCount(int count,int pageSize) {
		int pagecount = brd.pageCount(count, pageSize);
		return pagecount;
	}
	/**
	 * 删除品牌并且删除品牌下的商品
	 * @param code
	 */
	@Transactional
	public void deletegoods(String code) {
		brd.deletegoods(code);
	}
	@Transactional
	public void deleteag(String code) {
		brd.deleteag(code);
	}
	
	public String selectcode(String name) {
		return  brd.selectcode(name);
	}
}
