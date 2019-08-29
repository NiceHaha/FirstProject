package service.advert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.advert.AdvertDao;
import entity.advert.AdvertEntity;
import entity.page.PageEntity;

@Service
public class AdvertService {
	@Autowired
	private AdvertDao advertDao;
	
	/**
	  * 添加广告
	 */
	public void insertAdvert(AdvertEntity advert) {
		advertDao.insertAdvert(advert);
	}
	
	/**
	  * 删除广告
	 */
	public int deleteAdvert(Integer id) {
		int mark = advertDao.deleteAdvert(id);
		return mark;
	}
	
	/**
	 * 修改广告
	 */
	public void updateAdvert(AdvertEntity advert) {
		advertDao.updateAdvert(advert);
	}

	/**
	 * 修改广告的展示状态
	 */
	public int updateAdvertShow(Integer advertShow,Integer id) {
		int mark = advertDao.updateAdvertShow(advertShow, id);
		return mark;
	}
	
	/**
	 * 根据商品id查询单条广告数据， 用于修改时回显
	 */
	public AdvertEntity queryOneAdvert(Integer id) {
		AdvertEntity advert = advertDao.queryOneAdvert(id);
		return advert;
	}
	
	/**
	  * 查询所有广告，用List接
	 */
	public List<AdvertEntity> queryAdvert() {
		List<AdvertEntity> listAdvert  = advertDao.queryAdvert();
		return listAdvert;
	}
	
	/**
	  * 分页查询，用List接
	 */
	public List<AdvertEntity> queryAdvertPage(PageEntity page) {
		List<AdvertEntity> listAdvert = advertDao.queryAdvertPage(page);
		return listAdvert;
	}
	
	
	
}
