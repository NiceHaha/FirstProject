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
import entity.project.ProjectReport;
import service.project.ProjectService;

//举报后台模糊查询,普通查询
@WebServlet("/projectmhcx")
public class projectmhcx extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
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
		
		String projectFuzzy = req.getParameter("projectFuzzy");
		
		
		List<ProjectReport> list = null;
		//如果前台返回的数据不是空和null(也就是有值)就调用模糊查询,查出特定的值
		if(projectFuzzy != null && !"".equals(projectFuzzy)) {
			list = projectService.jbmhcx(projectFuzzy);
		}else {
			//如果前台没有返回数据就调用普通查询,查出所有值
			list = projectService.chaxun();
		}
		
		String ser = JsonUtils.beanListToJson(list);
		PrintWriter out = resp.getWriter();
		out.println(ser);
		out.flush();
		out.close();
		
		
	}
}
