package controller.login;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.util.EncryptUtils;
import service.login.LoginService;

@Controller
public class FloginHandler {
	@Autowired
	private  LoginService  loginService;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String flogin(String username,String password,String code,String mark,HttpServletRequest request, HttpServletResponse response) {
		String view ="";
		EncryptUtils encryptUtils=new EncryptUtils();
		String passwordmd5=encryptUtils.encryptToMD5(password);
		mark = mark.equals("") ? "0" : mark;
		
		//Flogindb logindb=new Flogindb(); 
		
		
		if(!mark.equals("0")){
			String sRand = (String) request.getSession().getAttribute("rand");
			
			if(sRand.equalsIgnoreCase(code)){
				//如果返回1表示在数据库验证成功，如果返回0表示没有验证成功
				int mark1=loginService.fcheckUser(username, passwordmd5);
				//int mark=0;
				
				if (mark1==0) {
					//重新跳转到登录页面
					request.setAttribute("mark", 1);
					//request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
					view="/flogin/login";
					
				}else {
					//用来记住信息
					String cok=request.getParameter("cok");
					if (cok!=null && cok.equals("1")) {
						Cookie cookUserName=new Cookie("cookUserName", username);
						Cookie cookPassWord=new Cookie("cookPassWord", passwordmd5);//保存到cookie
						cookUserName.setMaxAge(60*60*24*10);
						cookPassWord.setMaxAge(60*60*24*10);
						
						response.addCookie(cookUserName);
						response.addCookie(cookPassWord);
					}
					
					request.getSession().setAttribute("username", username);
					//跳转到列表查询页面
					//response.sendRedirect("/GF/foreground/index.jsp");
					view="foreground/index";
					
				}
				
			}else {
				request.setAttribute("mark", 1);
				//request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
				view="/flogin/login";
				
			}
		}else {
		
			
		//如果返回1表示在数据库验证成功，如果返回0表示没有验证成功
		int mark1=loginService.fcheckUser(username, passwordmd5);          
		//int mark=0;
		
		if (mark1==0) {
			//重新跳转到登录页面
			request.setAttribute("mark", 1);
			
			//request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
			view = "/flogin/login";
			
			
		}else {
			//用来记住信息
			String cok=request.getParameter("cok");
			if (cok!=null && cok.equals("1")) {
				Cookie cookUserName=new Cookie("cookUserName", username);
				Cookie cookPassWord=new Cookie("cookPassWord", passwordmd5);//保存到cookie
				cookUserName.setMaxAge(60*60*24*10);
				cookPassWord.setMaxAge(60*60*24*10);
				//request.setAttribute("auto", 1);
				response.addCookie(cookUserName);
				response.addCookie(cookPassWord);
			}
			
			request.getSession().setAttribute("username", username);
			//跳转到列表查询页面
			//response.sendRedirect("/GF/foreground/index.jsp");
			view = "/foreground/index";
		}
		
		
	}
		
		return view;
	
	}
	
	
	@RequestMapping(value="/fdl", method=RequestMethod.GET)
	public String test() {
		return "/flogin/login";
	}
	
	//语言国际化
	@RequestMapping(value="/changelogin",method = RequestMethod.GET)
	public String changelogin(Map<String, Object> map,Locale locale,HttpServletRequest request) {
		request.getSession().setAttribute("locale", locale);
		//map.put("locale", locale.toString());//把接收到的参数放入request
		return "flogin/login";
	}
}
