package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.goods.GoodsDao;
import entity.goods.GoodsEntity;
import entity.page.PageEntity;

@Service
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	/**
	 * 新增
	 * @param goods
	 */
	public void add(GoodsEntity goods) {
		goodsDao.add(goods);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id) {
		goodsDao.delete(id);
	}
	/**
	 * 修改
	 * @param goods
	 */
	public void update(GoodsEntity goods) {
		goodsDao.update(goods);
	}
	
	/**
	 * 查询 分页 模糊查询
	 * @param dataName
	 * @param page
	 * @return
	 */
	public List<GoodsEntity> Query(String dataName,PageEntity page){
		return goodsDao.Query(dataName, page);
	}
	
	/**
	 * 总条数
	 * @param dataName
	 * @return
	 */
	public int pageCount(String dataName) {
		return goodsDao.pageCount(dataName);
	}
	
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	public GoodsEntity Query1(int id) {
		return goodsDao.Query1(id);
	}
	
	/**
	 * 判断名字是否存在
	 * @param name
	 * @param id
	 * @return
	 */
	public int Query(String name,int id) {
		return goodsDao.Query(name, id);
	}
	
	public List<GoodsEntity> Query(){
		return goodsDao.Query();
	}
	
}
