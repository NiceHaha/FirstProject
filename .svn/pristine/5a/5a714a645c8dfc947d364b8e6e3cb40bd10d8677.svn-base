package servlet.agent;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.agent.Agent;
import service.Agent.AgentService;

@WebServlet("/agentGet")
public class AgentGetServlet extends HttpServlet{
@Autowired
private AgentService as;

	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
			//注入spring @Autowired Service
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
			super.init();
	 }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Agent agent = as.get(Integer.parseInt(id));
		request.setAttribute("obj", agent);
		request.getRequestDispatcher("admin/jsp/agent/agentUpdate.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
