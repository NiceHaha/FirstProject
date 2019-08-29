package servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cookieservlet")
public class CokServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
			return;
		}
		
		session.removeAttribute("username");
		

		
		request.getRequestDispatcher("flogin/login.jsp").forward(request, response);
	}
}

