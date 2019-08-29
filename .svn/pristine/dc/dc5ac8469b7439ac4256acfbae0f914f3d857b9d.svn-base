package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.user.UserEntity;
import service.user.UserService;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
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
		response.setContentType("aplication/json; charset=utf-8");
		String id = request.getParameter("id");
		UserEntity userEntity = userService.queryId(Integer.parseInt(id));
		request.setAttribute("user",userEntity);
		request.getRequestDispatcher("admin\\jsp\\user\\userUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserEntity userEntity = new UserEntity();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		if(name!= null) {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String account = request.getParameter("account");
		if(account != null) {
			account = new String(account.getBytes("iso-8859-1"),"utf-8");
		}
		String password = request.getParameter("password");
		if(password != null) {
			password = new String(password.getBytes("iso-8859-1"),"utf-8");
		}
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String privilege = request.getParameter("privilege");
		String black = request.getParameter("black");
		userEntity.setName(name);
		if(sex != null && !"".equals(sex)) {
			userEntity.setSex(Integer.parseInt(sex));
		}else {
			userEntity.setSex(0);
		}
		if(age != null && !"".equals(age)) {
			userEntity.setAge(Integer.parseInt(age));
		}else {
			userEntity.setAge(0);
		}
		userEntity.setAccount(account);
		userEntity.setPassword(password);
		userEntity.setTel(tel);
		userEntity.setAddr(addr);
		if(privilege != null && !"".equals(privilege)) {
			userEntity.setRoot(Integer.parseInt(privilege));
		}else {
			userEntity.setRoot(0);
		}
		if(black != null && !"".equals(black)) {
			userEntity.setBlack(Integer.parseInt(black));
		}else {
			userEntity.setBlack(0);
		}
		if(id != null && !"".equals(id)) {
			userService.update(userEntity,Integer.parseInt(id));
		}
		response.sendRedirect("admin\\jsp\\user\\userList.jsp");
	}

}
