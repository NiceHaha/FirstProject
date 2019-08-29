package service.csr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.csr.CsrDao;
import entity.csr.CsrEntity;
import entity.csrRecord.CsrRecordEntity;
import entity.page.PageEntity;

/**
 * service 处理业务逻辑层
 * @author :lyy
 * @date :下午7:40:40 2019年5月9日
 *
 */
@Service
public class CsrService {
	
	@Autowired
	private CsrDao csrDao;
//	CsrDao csrDao = new CsrDao();
	
	
	
	/**
	 * 添加
	 */
	public void insertCsr(CsrEntity csrEntity) {
		csrDao.insert(csrEntity);
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<CsrEntity> queryCsr(String csrName,PageEntity pageEntity){
		return csrDao.queryCsr(csrName,pageEntity);
	}
	
	/**
	 * 删除
	 */
	public void deleCsr(int code) {
		csrDao.deleCsr(code);
	}
	
	/**
	 * 修改
	 * @param csrEntity
	 * @param id
	 */
	public void updateCsr(CsrEntity csrEntity,int id) {
		csrDao.updateCsr(csrEntity, id);
	}
	
	
	/**
	 * 根据编号查询客服聊天记录
	 * @param code
	 */
	public List<CsrRecordEntity> queryEmpCode(String code) {
		return csrDao.queryEmpCode(code);
	}
	
	/**
	 * 根据id 回显客服数据
	 * @param id
	 * @return
	 */
	public CsrEntity queryCsrId(int id){
		return csrDao.queryCsrId(id);
		
	}
	
	
	/**
	 * 搜索框  ----->模糊查询
	 * 根据名字搜索客服
	 * @param csrName
	 * @return
	 */
//	public List<CsrEntity> queryCsrName(String csrName){
//		return csrDao.queryCsrName(csrName);
//	}
	
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int pageCount(String csrName) {
		return csrDao.pageCount(csrName);
	}
	/**
	 * 总页数
	 * @param pageCount  总条数
	 * @param pageSize	每页显示页数
	 */
	public int pageCount(int count,int pageSize) {
		return csrDao.pageCount(count, pageSize);
	}
	
	
}
