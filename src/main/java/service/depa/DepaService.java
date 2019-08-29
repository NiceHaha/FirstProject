package service.depa;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.depa.DepaDao;
import entity.depa.DepaEntity;
import entity.page.PageEntity;

@Service
public class DepaService {
	@Autowired
	private DepaDao depaDao;
//	DepaDao depaDao = new DepaDao();
	/**
	 * 添加部门
	 * 
	 * @throws SQLException
	 */
	public void insert(DepaEntity depaEntity) {
		depaDao.insert(depaEntity);
	}
	
	/**
	 * 查询部门
	 */
	public List<DepaEntity> query(String depaName,PageEntity pageEntity) {
		return depaDao.query(depaName,pageEntity);
	}
	
	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		depaDao.delete(code);
	}
	
	/**
	 * 修改用户数据
	 * 
	 * @throws SQLException
	 */
	public void update(DepaEntity depaEntity, int id) {
		depaDao.update(depaEntity, id);
	}
	/**
	 * 查出所有部门名称
	 * @param pageEntity
	 * @return
	 */
	public List<DepaEntity> query() {
		return depaDao.query();
	}
	/**
	 * 根据部门名字查出部门部门编号
	 */
	public String queryName(String name) {
		return depaDao.queryName(name);
	}
	/**
	 * 根据id查出部门
	 */
	public DepaEntity queryId(int id) {
		return depaDao.queryId(id);
	}
	/**
	 * 根据部门code查出部门名称
	 */
	public String queryCode(String code) {
		String depaName = depaDao.queryCode(code);
		return depaName;
	}
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	public int count(String empName) {
		return depaDao.count(empName);
	}

}
