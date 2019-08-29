package servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

//添加
@WebServlet("/projectInsert")
public class projectInsert extends HttpServlet{
	
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
		
		String ArticleCode = req.getParameter("ArticleCode");
		String ArticleTitle = req.getParameter("ArticleTitle");
		ArticleTitle  = new String (ArticleTitle.getBytes("iso-8859-1"),"utf-8");
		String ArticleText = req.getParameter("ArticleText");
		ArticleText  = new String (ArticleText.getBytes("iso-8859-1"),"utf-8");
//		String GoodsCode = req.getParameter("goods_code");
		
		ProjectEntity projectentity = new ProjectEntity();
		
		projectentity.setArticle_code(ArticleCode);
		projectentity.setArticle_title(ArticleTitle);
		projectentity.setArticle_text(ArticleText);
		
		
		projectService.insert(projectentity);
		
		resp.sendRedirect("admin\\jsp\\project\\projectQuery.jsp");
		
	}
	
	
	
	
	
}
