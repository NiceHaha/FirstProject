 package controller.login;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.login.Alogindb;
import dao.login.Flogindb;
import service.login.LoginService;


@Controller
public class AloginHandler {
	@Autowired
	private  LoginService  loginService;
	
	@RequestMapping(value="/alogin", method=RequestMethod.POST)
	public String alogin(String username,String password,String code,String mark,HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
		String view ="";
		mark = mark.equals("") ? "0" : mark;
		
		//Alogindb alogindb=new Alogindb();
		
		
		if(!mark.equals("0")){
			String sRand = (String) request.getSession().getAttribute("rand");
			
			if(sRand.equalsIgnoreCase(code)){
				//如果返回1表示在数据库验证成功，如果返回0表示没有验证成功
				int mark1=loginService.acheckUser(username, password);
				//int mark=0;
				
				if (mark1==0) {
					//重新跳转到登录页面
					request.setAttribute("mark", 1);
					//request.getRequestDispatcher("flogin/alogin.jsp").forward(request, response);
					view="/flogin/alogin";
					
				}else {
					//用来记住信息
					String cok=request.getParameter("cok");
					if (cok!=null && cok.equals("1")) {
						Cookie cookUserName=new Cookie("cookUserName", username);
						Cookie cookPassWord=new Cookie("cookPassWord", password);//保存到cookie
						cookUserName.setMaxAge(60*60*24*10);
						cookPassWord.setMaxAge(60*60*24*10);
						request.setAttribute("auto", 1);
						response.addCookie(cookUserName);
						response.addCookie(cookPassWord);
					}
					
					request.getSession().setAttribute("username", username);
					//跳转到列表查询页面
//					response.sendRedirect("/GF/admin/index.jsp");
					view="/admin/index";
				}
				
			}else {
				request.setAttribute("mark", 1);
//				request.getRequestDispatcher("flogin/alogin.jsp").forward(request, response);
				view="/flogin/alogin";
			}
		}else {
		
			
		//如果返回1表示在数据库验证成功，如果返回0表示没有验证成功
		int mark1=loginService.acheckUser(username, password);          
		//int mark=0;
		
		if (mark1==0) {
			//重新跳转到登录页面
			request.setAttribute("mark", 1);
			
//			request.getRequestDispatcher("flogin/alogin.jsp").forward(request, response);
			view = "/flogin/alogin";
		}else {
			//用来记住信息
			String cok=request.getParameter("cok");
			if (cok!=null && cok.equals("1")) {
				Cookie cookUserName=new Cookie("cookUserName", username);
				Cookie cookPassWord=new Cookie("cookPassWord", password);//保存到cookie
				cookUserName.setMaxAge(60*60*24*10);
				cookPassWord.setMaxAge(60*60*24*10);
				//request.setAttribute("auto", 1);
				response.addCookie(cookUserName);
				response.addCookie(cookPassWord);
			}
			
			request.getSession().setAttribute("username", username);
			//跳转到列表查询页面
			view = "/admin/index";
			
		}
		
		}
		return view;
		
	}
	
	
	@RequestMapping(value="/adl", method=RequestMethod.GET)
	public String test() {
		return "/flogin/alogin";
	}
}

