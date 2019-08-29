package service.goodsreciew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.goodsreciew.GoodsReciewDao;
import entity.goodsreciew.GoodsReciewEntity;
import entity.page.PageEntity;
import service.base.BaseService;

/**
 * 
 * @author guoning
 *
 * 2019年5月29日下午9:14:07
 */
@Service
public class GoodsreciewService  {
	
	@Autowired
	private GoodsReciewDao goodsReciewDao;
	
	/**
	 * 新增
	 * @param goodsr
	 */
	public void add(GoodsReciewEntity goodsr) {
		goodsReciewDao.add(goodsr);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id){
		goodsReciewDao.delete(id);
	}
	
	/**
	 * 修改
	 */
	public void update(GoodsReciewEntity goodsr) {
		goodsReciewDao.update(goodsr);
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<GoodsReciewEntity> query(){
		return goodsReciewDao.query();
	}
	
	/**
	 * 模糊查询加分页
	 * @param dataName
	 * @param page
	 * @return
	 */
	public List<GoodsReciewEntity> query3(String  dataName,PageEntity page){
		return goodsReciewDao.query3(dataName, page);
	}
	
	/**
	 * 得到总条数
	 * @param dataName
	 * @return
	 */
	public int pageCount(String  dataName) {
		return goodsReciewDao.pageCount(dataName);
	}
	
	/**
	 * 传入一个id 得到一个List
	 * @param id
	 * @return
	 */
	public List<GoodsReciewEntity> query(int id){
		return goodsReciewDao.query(id);
	}
	
	/**
	 * 传入一个id得到一个对象
	 * @param id
	 * @return
	 */
	public GoodsReciewEntity query1(int id) {
		return goodsReciewDao.query1(id);
	}
	
	/**
	 * 传入一个名字 判断他是否存在 返回一个数量
	 * @param name
	 * @return
	 */
	public int query4(String  name) {
		return goodsReciewDao.query4(name);
	}
	
	/**
	 * 判断名字是否重复
	 * @param name
	 * @param id
	 * @return
	 */
	public int query4(String name ,int id) {
		return goodsReciewDao.query4(name,id);
	}
}
