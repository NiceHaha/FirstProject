package servlet.project;

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

import dao.project.Jdbclinks;
import dao.util.JsonUtils;
import entity.project.ProjectEntity;
import service.project.ProjectService;

//举报回显,前台文章查询
@WebServlet("/projectjubao")
public class projectJubao extends HttpServlet{
	
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
		
		req.getRequestDispatcher("/foreground/jsp/project/report.jsp").forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//前台文章查询
		resp.setContentType("application/json;charset=utf-8");
		
		List<ProjectEntity> list = projectService.query();
		
		String ser = JsonUtils.listToJson(list);
		
		PrintWriter out = resp.getWriter();
		out.println(ser);
		out.flush();
		out.close();
		
		
	}
	
	
}
