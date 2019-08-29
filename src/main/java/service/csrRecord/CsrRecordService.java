package service.csrRecord;

import java.util.List;

import dao.csrRecord.CsrRecordDao;
import entity.csrRecord.CsrRecordEntity;
import entity.page.PageEntity;

/**
 * 客服记录
 * @author :lyy
 * @date :下午3:35:45 2019年5月10日
 *	
 *
 *
 *
 *
 *	该功能未实现！！！
 */
public class CsrRecordService {

	CsrRecordDao csrRecordDao = new CsrRecordDao();
	
	/**
	 * 添加
	 */
	public void insertCsr(CsrRecordEntity csrRecordEntity) {
		csrRecordDao.insert(csrRecordEntity);
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<CsrRecordEntity> queryCsr(String csrName,PageEntity pageEntity){
		 return csrRecordDao.queryCsr(csrName,pageEntity);
	}
	
	/**
	 * 根据ID查出客服编号
	 */
	public String queryCsrId(int id){
		return csrRecordDao.queryCsrId(id);
	}
	
	/**
	 * 删除
	 */
	public void deleCsr(int code) {
		csrRecordDao.deleCsr(code);
	}
	
	/**
	 * 修改
	 * @param csrEntity
	 * @param id
	 */
	public void updateCsr(CsrRecordEntity csrRecordEntity,int id) {
		csrRecordDao.updateCsr(csrRecordEntity, id);
	}
	

	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count() {
		return csrRecordDao.count();
	}

}
