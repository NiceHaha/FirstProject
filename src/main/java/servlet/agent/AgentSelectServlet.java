package servlet.agent;

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
import entity.agent.Agent;
import entity.page.Page;
import entity.page.PageEntity;
import service.Agent.AgentService;

@WebServlet("/agentselect")
public class AgentSelectServlet extends HttpServlet {
	@Autowired
	private AgentService as;
	
	//把Servlet变成一个bean
		 public void init(ServletConfig config) throws ServletException {
				//注入spring @Autowired Service
				SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
				super.init();
		 }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/text;charset=utf-8");
		PageEntity pageEntity = new PageEntity();
		String str = req.getParameter("str");
		String pageNow = req.getParameter("pageNow");
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if (str == null) {
			str = "";
		}
		int count = as.agentCount(str); //得到总条数
		pageEntity.setCount(count);
		int pageCount = as.pageCount(count,pageEntity.getPageSize());//得到总页数
		pageEntity.setPageCount(pageCount);
		List<Agent> ag = as.select(str, pageEntity);
		Page<?> page = new Page<>();
		page.setList(ag);
		page.setPageEntity(pageEntity);
		String ser = JsonUtils.beanToJson(page);
		PrintWriter out = resp.getWriter();
		out.println(ser);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
