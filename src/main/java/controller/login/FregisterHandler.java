package controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.login.Flogindb;
import dao.util.EncryptUtils;
import entity.user.UserEntity;
import service.login.LoginService;

@Controller
public class FregisterHandler {
	@Autowired
	private  LoginService  loginService;
	@RequestMapping(value="/fregister", method=RequestMethod.POST)
	public String fregister(String useraccount,String userpassword,String username,Integer userage,Integer usersex,String usertel,String useraddr,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String view="";
		UserEntity userEntity=new UserEntity();
		userEntity.setAccount(useraccount);
		EncryptUtils encryptUtils=new EncryptUtils();
		String userpasswordmd5=encryptUtils.encryptToMD5(userpassword);
		userEntity.setPassword(userpasswordmd5);
		userEntity.setName(username);
		userEntity.setAge(userage);
		userEntity.setSex(usersex);
		userEntity.setTel(usertel);
		userEntity.setAddr(useraddr);

	
		loginService.fzeng(userEntity);
			
		
		view="/flogin/login";

		return view;

	}
	
	@RequestMapping(value="/fzc", method=RequestMethod.GET)
	public String test() {
		return "flogin/register";
	}
}
		


