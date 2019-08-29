package service.emp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.depa.DepaDao;
import dao.emp.EmpDao;
import entity.emp.EmpEntity;
import entity.page.PageEntity;

@Service
public class EmpService {
	@Autowired
	private EmpDao empDao;
//	EmpDao empDao = new EmpDao();
	@Autowired
	private DepaDao depaDao;
	
	/**
	 * 添加用户数据
	 * 
	 * @throws SQLException
	 */
	public void insert(EmpEntity empEntity) {
		empDao.insert(empEntity);
	}
	
	/**
	 * 根据部门名字查出部门部门编号
	 */
	public String queryName(String name) {
		return depaDao.queryName(name);
	}
	
	
	/**
	 * 模糊查询
	 */
	public List<EmpEntity> query(String empName,PageEntity pageEntity) {
		return empDao.query(empName,pageEntity);
	}
	
	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		empDao.delete(code);
	}
	
	/**
	 * 修改用户数据
	 * 
	 * @throws SQLException
	 */
	public void update(EmpEntity empEntity, int id) {
		empDao.update(empEntity, id);
	}

	/**
	 * 根据ID查出所对应的数据
	 */
	public EmpEntity queryid(int id) {
		return empDao.queryid(id);
	}
	
	/**
	 * 查出共有都少条
	 * @return
	 */
	public int count(String empName) {
		return empDao.count(empName);
	}
}
