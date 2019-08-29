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
import service.project.ProjectService;

//删除
@WebServlet("/projectDelete")
public class projectDelete extends HttpServlet{
	
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
		resp.setContentType("application/json;charset=utf-8");
		String ida = req.getParameter("id");
		int id = Integer.parseInt(ida);
				
		projectService.delete(id);
		
		PrintWriter out = resp.getWriter();
		out.print("\"status\":0}");
		out.flush();
		out.close();
		
		req.getRequestDispatcher("/admin/jsp/project/projectQuery.jsp").forward(req,resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
}
