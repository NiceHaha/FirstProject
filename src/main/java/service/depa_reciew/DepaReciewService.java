package service.depa_reciew;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.depaReciew.DepaReciewDao;
import entity.depa_reciew.DepaReciewEntity;
import entity.page.PageEntity;

@Service
public class DepaReciewService {
	@Autowired
	private DepaReciewDao depaReciewDao;
	
	/**
	 * 添加部门 如果同意添加则把该条数据添加到部门表中 
	 *  不管通不通过数据都会在本表有记录
	 * 
	 * @throws SQLException
	 */
	public void insert(DepaReciewEntity depaReciewEntity) {
		depaReciewDao.insert(depaReciewEntity);
	}
	/**
	 *根据部门id获取对应的信息 
	 */
	public DepaReciewEntity queryId(int id) {
		return depaReciewDao.queryId(id);
	}
	
	/**
	 *查询所有部门申请 
	 */
	public List<DepaReciewEntity> query(String depaName,PageEntity pageEntity) {
		return depaReciewDao.query(depaName,pageEntity);
	}
	
	/**
	 * 删除部门申请  （不会删除部门表中的数据）
	 */
	public void delete(int code) {
		depaReciewDao.delete(code);
	}
	
	/**
	 * 修改部门申请状态  比如没有通过的可以改为通过
	 * 
	 * @throws SQLException
	 */
	public void update(DepaReciewEntity depaReciewEntity, int id) {
		depaReciewDao.update(depaReciewEntity, id);
	}
	/**
	 *总条数
	 * @return
	 */
	public int count(String depaName) {
		return depaReciewDao.count(depaName);
	}
}
