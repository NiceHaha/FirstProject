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
import entity.project.ProjectEntity;
import service.project.ProjectService;

//修改
@WebServlet("/projectUqdate")
public class projectUqdate extends HttpServlet{
	
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
		String id = req.getParameter("id");
		
		ProjectEntity projectentity = projectService.update1(Integer.parseInt(id));
		
		//从jsp页面获取id
		req.setAttribute("projectentity",projectentity);
		
		//回显
		req.setAttribute("ArticleTitle",projectentity.getArticle_title());
		req.setAttribute("ArticleText",projectentity.getArticle_text());
		
		req.getRequestDispatcher("/admin/jsp/project/projectUqdate.jsp").forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8");
		String id = req.getParameter("id");
		String ArticleTitle = req.getParameter("ArticleTitle");
		ArticleTitle  = new String (ArticleTitle.getBytes("iso-8859-1"),"utf-8");
		String ArticleText = req.getParameter("ArticleText");
		ArticleText  = new String (ArticleText.getBytes("iso-8859-1"),"utf-8");
		
		ProjectEntity projectentity = new ProjectEntity();
		projectentity.setId(Integer.parseInt(id));
		projectentity.setArticle_title(ArticleTitle);
		projectentity.setArticle_text(ArticleText);
		
		projectService.update(projectentity);
		
		resp.sendRedirect("admin\\jsp\\project\\projectQuery.jsp");
	}
	
	
}
