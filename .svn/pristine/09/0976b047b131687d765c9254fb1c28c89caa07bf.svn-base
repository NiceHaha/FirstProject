package servlet.project;

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

import dao.project.Jdbclinks;
import dao.util.JsonUtils;
import javafx.print.JobSettings;
import service.project.ProjectService;

@WebServlet("/projectSelect")
public class projectSelect extends HttpServlet{
	
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
		
	@Autowired
	private ProjectService projectService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//循环查出正文内容
		resp.setContentType("application/json;charset=utf-8");
		String id = req.getParameter("id");
		
		String a = projectService.select(Integer.parseInt(id));
		
		PrintWriter out = resp.getWriter();
		out.println(a);
		out.flush();
		out.close();
		
		
	}
}
