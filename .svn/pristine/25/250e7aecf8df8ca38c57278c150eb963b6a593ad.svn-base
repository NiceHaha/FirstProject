package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.user.UserService;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/userDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Autowired
	private UserService userService;

	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try {
			userService.delete(Integer.parseInt(id));
			out.println("{\"user\":1}");
		}catch (Exception e) {
			out.println("{\"user\":0}");
		}finally {
			out.flush();			
			out.close();
		}
	}
}
