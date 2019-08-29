package servlet.goods;

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

import dao.agent.AgentDao;
import dao.util.JsonUtils;
import entity.agent.Agent;
import service.Agent.AgentService;


@WebServlet("/Agentdata")
public class AgentQuery extends HttpServlet{
	@Autowired
	private AgentService AgentService;
	//把Servlet变成一个bean
		public void init(ServletConfig config) throws ServletException {
			// 注入spring @Autowired Service
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
			super.init();
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		String goodsp= req.getParameter("goodsp");
		List<Agent> list=AgentService.Query(goodsp);
		String JosnList = JsonUtils.beanListToJson(list);
		out.println(JosnList);
		out.flush();
		out.close();
	}
}
