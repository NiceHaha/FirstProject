package servlet.empReciew;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.empReciew.EmpRecorEntity;
import service.empReciew.EmpReciewService;

/**
 * Servlet implementation class empReciewServlet
 */
@WebServlet("/empReciewServlet")
public class EmpReciewAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmpReciewService empReciewService;
	
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
		
	 }
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		if(name != null && !"".equals(name)) {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String addr = request.getParameter("addr");
		if(addr != null && !"".equals(addr)) {
			addr = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String tel = request.getParameter("tel");
		String position = request.getParameter("position");
		if(position != null && !"".equals(position)) {
			position = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String state = request.getParameter("state");
		String depaName = request.getParameter("depaName");
		if(depaName != null && !"".equals(depaName)) {
			depaName = new String(depaName.getBytes("iso-8859-1"),"utf-8");
		}
		
		EmpRecorEntity empRecorEntity = new EmpRecorEntity();
		empRecorEntity.setName(name);
		empRecorEntity.setAddr(addr);
		empRecorEntity.setTel(tel);
		empRecorEntity.setPosition(position);
		empRecorEntity.setAccount(account);
		empRecorEntity.setPassword(password);
		if(sex != null && !"".equals(sex)) {
			empRecorEntity.setSex(Integer.parseInt(sex));
		}else {
			empRecorEntity.setSex(0);
		}
		if(age != null && !"".equals(age)) {
			empRecorEntity.setAge(Integer.parseInt(age));
		}else {
			empRecorEntity.setAge(0);
		}
		if(state != null && !"".equals(state)) {
			empRecorEntity.setState(Integer.parseInt(state));
		}else {
			empRecorEntity.setState(0);
		}
		if(depaName != null) {
			empRecorEntity.setDepaCode(empReciewService.queryName(depaName));
		}
		empReciewService.insert(empRecorEntity);
		response.sendRedirect("admin\\jsp\\emp\\empList.jsp");
	}
}
