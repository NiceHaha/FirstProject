package service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.login.Alogindb;
import dao.login.Flogindb;
import entity.user.UserEntity;

@Service
public class LoginService {
	@Autowired
	private Alogindb alogindb;
	
	@Autowired
	private Flogindb flogindb;
	
	public int acheckUser(String username,String password) {
		int mark=alogindb.checkUser(username, password);
		return mark;
		

	}
	public int fcheckUser(String username,String password) {
		int mark=flogindb.checkUser(username, password);
		return mark;
	}
	
	public int ajaxcha(String useraccount) {
		int mark=flogindb.ajaxcha(useraccount);
		return mark;
	}
	
	public void fzeng(UserEntity userentity) throws Exception {
		flogindb.fzeng(userentity);
	}
	
}
