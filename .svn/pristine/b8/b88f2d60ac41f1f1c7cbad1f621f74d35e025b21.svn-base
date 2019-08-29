package service.empReciew;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.depa.DepaDao;
import dao.empRecorw.EmpReciewDao;
import entity.empReciew.EmpRecorEntity;
import entity.page.PageEntity;
@Service
public class EmpReciewService {
	@Autowired
	private EmpReciewDao empReciewDao;
	@Autowired
	private DepaDao depaDao;
	
	
	/**
	 * 根据部门code查出部门名称
	 */
	public String queryCode(String code) {
		String depaName = depaDao.queryCode(code);
		return depaName;
	}
	
	/**
	 * 添加用户时保存到这里
	 * 
	 * @throws SQLException
	 */
	public void insert(EmpRecorEntity empRecorEntity) {
		empReciewDao.insert(empRecorEntity);
	}
	
	/**
	 * 根据部门名字查出部门部门编号
	 */
	public String queryName(String name) {
		return depaDao.queryName(name);
	}
	/**
	 * 查询用户
	 */
	public List<EmpRecorEntity> query(String empName,PageEntity pageEntity) {
		return empReciewDao.query(empName,pageEntity);
	}
	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		empReciewDao.delete(code);
	}

	/**
	 *根据id查出所对应的数据
	 */
	public EmpRecorEntity queryId(int id) {
		return empReciewDao.queryId(id);
	}
	/**
	 * 查出总条数
	 */
	public int count(String empName) {
		return empReciewDao.count(empName);
	}
}
