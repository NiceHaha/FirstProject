package servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.login.Flogindb;
import dao.util.EncryptUtils;
import entity.user.UserEntity;
import service.login.LoginService;



//@WebServlet("/register")
public class FregisterServlet extends HttpServlet{
	//这里是把servlet变成一个bean
		 public void init(ServletConfig servletConfig) throws ServletException {
			     super.init();
			     SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,servletConfig.getServletContext());
			      }
	@Autowired
	private  LoginService  loginService;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String useraccount=request.getParameter("useraccount");
		
		
		Flogindb flogindb=new Flogindb();
		int mark=flogindb.ajaxcha(useraccount);
		
		if(mark==0) {
			String str= "{\"ss\":0}";
			PrintWriter out=response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		}else {
			String str= "{\"ss\":1}";
			PrintWriter out=response.getWriter();
			out.print(str);
			out.flush();
			out.close(); 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 
	
				
		String useraccount=request.getParameter("useraccount");
		String userpassword=request.getParameter("userpassword");
		String username=request.getParameter("username");
		String age=request.getParameter("userage");
		int userage=Integer.parseInt(age);
		String sex=request.getParameter("usersex");
		int usersex=Integer.parseInt(sex);
		String usertel=request.getParameter("usertel");
		String useraddr=request.getParameter("useraddr");
				

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

		
		//Flogindb flogindb = new Flogindb();
		try {
			loginService.fzeng(userEntity);
			//flogindb.fzeng(userentity);
			// request.getRequestDispatcher("/cha").forward(request, response);
			response.sendRedirect("/GF/flogin/login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
