package servlet.project;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.project.Jdbclinks;
import entity.project.ProjectReport;
import service.project.ProjectService;

//举报添加
@WebServlet("/projectshehe")
public class projectShehe extends HttpServlet{
	
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
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String articletitle = req.getParameter("ArticleTitle");
		articletitle  = new String (articletitle.getBytes("iso-8859-1"),"utf-8");
		String reporting = req.getParameter("reporting");
		reporting  = new String (reporting.getBytes("iso-8859-1"),"utf-8");
		
		ProjectReport projectreport = new ProjectReport();
		projectreport.setArticletitle(articletitle);
		projectreport.setReporting(reporting);
		
		projectService.insert1(projectreport);
		
		
		resp.sendRedirect("foreground\\goods.jsp");
		
		
	}
	
	
	
}
