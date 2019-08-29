package service.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.user.UserDao;
import entity.page.PageEntity;
import entity.user.UserEntity;

@Service
public class UserService {
	
	@Autowired
	private  UserDao userDao;
	
	
	/**
	 * 添加
	 */
	public void insert(UserEntity userEntity) {
		userDao.insert(userEntity);
	}
	
	/**
	 * 查询用户
	 */
	public List<UserEntity> query(String userName,PageEntity pageEntity) {
		 return userDao.query(userName,pageEntity);
	}
	/**
	 * 所有
	 */
	public List<UserEntity> querys() {
		return userDao.querys();
	}
	/**
	 * 删除用户数据
	 */
	public void delete(int code) {
		userDao.delete(code);
	}
	
	/**
	 * 修改用户数据
	 * 
	 * @throws SQLException
	 */
	public void update(UserEntity userEntity, int id) {
		userDao.update(userEntity, id);
	}
	
	/**
	 * 根据id查出用户所有信息
	 */
	public UserEntity queryId(int id) {
		return userDao.queryId(id);
	}
	
	/**
	 * 查出所有记录数
	 */
	public int count(String userName) {
		return userDao.count(userName);
	}
}
