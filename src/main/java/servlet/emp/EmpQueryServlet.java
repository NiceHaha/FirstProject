package servlet.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.util.JsonUtils;
import entity.emp.EmpEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.emp.EmpService;

/**
 * Servlet implementation class EmpAddServlet
 */
@WebServlet("/empQueryServlet")
public class EmpQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	 
	 
	 @Autowired
	 private EmpService empService;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("aplication/json; charset=utf-8");
		PageEntity pageEntity = new PageEntity();
		PrintWriter out = response.getWriter();
		String empName = request.getParameter("empName");
		String pageNow = request.getParameter("pageNow");
		if(pageNow != null && !"".equals(pageNow)) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(empName == null) {
			empName = "";
		}
		int count = empService.count(empName);//得到共有多少数据
		pageEntity.setCount(count);
		List<EmpEntity> list = empService.query(empName, pageEntity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		String JosnList = JsonUtils.beanToJson(page);//将java对象List集合转换成json字符串
		out.println(JosnList);
		out.flush();
		out.close();
	}

}
