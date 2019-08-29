package servlet.emp;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.emp.EmpEntity;
import service.emp.EmpService;

/**
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/empUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmpService empService;
	
	
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	 
	 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmpEntity empEntity = empService.queryid(Integer.parseInt(id));
		request.setAttribute("empEntity",empEntity);
		request.getRequestDispatcher("admin\\jsp\\emp\\empUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		if(name!=null && !"".equals(name)) {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String addr = request.getParameter("addr");
		if(addr != null && "".equals(addr)) {
			addr = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String tel = request.getParameter("tel");
		String position = request.getParameter("position");
		if(position != null && !"".equals(position)) {
			position = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String account = request.getParameter("account");
		if(account != null && !"".equals(account)) {
			account = new String(account.getBytes("iso-8859-1"),"utf-8");
		}
		String password = request.getParameter("password");
		if(password != null && !"".equals(password)) {
			password = new String(password.getBytes("iso-8859-1"),"utf-8");
		}
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String state = request.getParameter("state");
		String depaName = request.getParameter("depaName");
		if(depaName != null && !"".equals(depaName)) {
			depaName = new String(depaName.getBytes("iso-8859-1"),"utf-8");
		}
		EmpEntity empEntity = new EmpEntity();
		empEntity.setName(name);
		empEntity.setAddr(addr);
		empEntity.setTel(tel);
		empEntity.setPosition(position);
		empEntity.setAccount(account);
		empEntity.setPassword(password);
		if(sex != null && !"".equals(sex)) {
			empEntity.setSex(Integer.parseInt(sex));
		}else {
			empEntity.setSex(0);			
		}
		if(age != null && !"".equals(age)) {
			empEntity.setAge(Integer.parseInt(age));
		}else {
			empEntity.setAge(0);
		}
		if(state != null && !"".equals(state)) {
			empEntity.setState(Integer.parseInt(state));
		}else {
			empEntity.setState(0);
		}
		
		if(depaName != null) {
			empEntity.setDepaName(depaName);
			empEntity.setDepaCode(empService.queryName(depaName));
		}
		empService.update(empEntity, Integer.parseInt(id));
		response.sendRedirect("admin\\jsp\\emp\\empList.jsp");
	}

}
