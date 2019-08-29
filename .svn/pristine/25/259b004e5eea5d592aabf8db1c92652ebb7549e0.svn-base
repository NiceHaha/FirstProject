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
import entity.depa.DepaEntity;
import entity.page.Page;
import entity.page.PageEntity;
import entity.project.ProjectEntity;
import service.depa.DepaService;
import service.project.ProjectService;

//主页面查询,分页,模糊查询
@WebServlet("/projectFuzzy")
public class projectFuzzy extends HttpServlet{
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
		String projectFuzzy = req.getParameter("projectFuzzy");  //模糊查询
		System.out.println(projectFuzzy);
		String pageNow = req.getParameter("pageNow");          //当前页
		
		Jdbclinks jdbclinks = new Jdbclinks();
		PageEntity pageEntity = new PageEntity();
		
		//分页
		if(pageNow != null && !"".equals(pageNow)) {
			//将得到的当前页放入实体类中
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
//		int count = jdbclinks.zshuju(projectFuzzy); //得到总条数
		int count = projectService.zshuju(projectFuzzy);  //得到总条数
		pageEntity.setCount(count);     //将得到的总条数放入实体类中
		
//		List<ProjectEntity> list = jdbclinks.query(projectFuzzy, pageEntity);
		List<ProjectEntity> list = projectService.query(projectFuzzy, pageEntity);
		
		Page<?> page=new Page<>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		
		String ser = JsonUtils.beanToJson(page);
		PrintWriter out = resp.getWriter();
		out.println(ser);
		out.flush();
		out.close();
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
