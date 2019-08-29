package servlet.emp;

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

import entity.emp.EmpEntity;
import entity.empReciew.EmpRecorEntity;
import service.emp.EmpService;
import service.empReciew.EmpReciewService;

/**
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/empAddServlet")
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmpReciewService empReciewService;
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
		EmpRecorEntity empRecorEntity = empReciewService.queryId(Integer.parseInt(id));
		int code = (int)Math.round(Math.random()*9999999);
			EmpEntity empEntity = new EmpEntity();
			empEntity.setName(empRecorEntity.getName());
			empEntity.setTel(empRecorEntity.getTel());
			empEntity.setAddr(empRecorEntity.getAddr());
			empEntity.setAccount(empRecorEntity.getAccount());
			empEntity.setPassword(empRecorEntity.getPassword());
			empEntity.setDepaCode(empRecorEntity.getDepaCode());
			String depaName = null;
			if(empRecorEntity.getDepaCode() != null) {
				depaName = empReciewService.queryCode(empRecorEntity.getDepaCode());//根据code查出部门名字
				empEntity.setPosition(empRecorEntity.getPosition());
			}
			empEntity.setEmpCode("EMP-" + code);
			empEntity.setSex(empRecorEntity.getSex());
			empEntity.setAge(empRecorEntity.getAge());
			empEntity.setState(empRecorEntity.getState());
			empService.insert(empEntity);
			empReciewService.delete(Integer.parseInt(id));
		response.sendRedirect("admin/jsp/empReciew/empReciewList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
