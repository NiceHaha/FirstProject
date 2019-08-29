package controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CokHandler {
	
	@RequestMapping(value="/cookieHandler", method=RequestMethod.GET)
	public String cok(HttpServletRequest request, HttpServletResponse response) {
		String view="";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("cookUserName")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie); 
			}
			if(cookie.getName().equals("cookUserPassWord")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		request.setAttribute("auto", 0);
		
		HttpSession session = request.getSession(false);//防止创建Session
		if(session == null){
			//request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
			view="flogin/login";
			return view;
		}
		
		session.removeAttribute("username");
		//request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
		view="flogin/login";
		return view;
	}
	}

