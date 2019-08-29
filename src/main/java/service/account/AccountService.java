package service.account;

import java.sql.SQLException;
import java.util.List;

import dao.account.AccountDao;
import entity.account.AccountEntity;

public class AccountService {
	AccountDao accountDao = new AccountDao();
	/**
	 * 添加账号
	 * 
	 * @throws SQLException
	 */
	public void insert(AccountEntity accountEntity) {
		accountDao.insert(accountEntity);
	}
	
	/**
	 * 查询账号
	 */
	public List<AccountEntity> query() {
		return accountDao.query();
	}
	
	/**
	 * 删除部门账号
	 */
	public void delete(int code) {
		accountDao.delete(code);
	}
	
	/**
	 * 修改账号数据
	 * 
	 * @throws SQLException
	 */
	public void update(AccountEntity accountEntity, int id) {
		accountDao.update(accountEntity, id);
	}
}
