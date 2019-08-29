package servlet.agent;

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

import dao.agent.AgentDao;
import dao.brand.BrandDao;
import entity.agent.Agent;
import service.Agent.AgentService;

@WebServlet("/agentinsert")
public class AgentInsertServlet extends HttpServlet {
	@Autowired
	private AgentService as;
	//把Servlet变成一个bean
		 public void init(ServletConfig config) throws ServletException {
				//注入spring @Autowired Service
				SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
				super.init();
		 }
	public String getFileName(String header) {
		String[] tempArr1 = header.split(";");
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 在页面上拿到输入的值
		String name = req.getParameter("agName");
		Integer i = as.count(name); // 查询用户名是存在, 0表示不存在

		if (i == 0) { // 如果数据库中没有此值表示可插入
			PrintWriter out = resp.getWriter();// 转成json格式
			out.println(0);// 放置一个0给页面
			out.flush();
			out.close();
		} else { // 不进行插入
			PrintWriter out = resp.getWriter();// 转成json格式
			out.println(1);// 放置一个1给页面
			out.flush();
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		
		int code = (int)Math.round(Math.random()*9999999);
		String name = req.getParameter("agName");
		String city = req.getParameter("agcity");
		String tel = req.getParameter("agtel");
		String braname = req.getParameter("goodsp");
		String bracode = req.getParameter("goodsp");
		String b= as.selectcode(bracode);
		Agent agent = new Agent();
		agent.setAgent_name(name);
		agent.setAgent_tel(tel);
		agent.setAgent_city(city);
		agent.setBrand_code(b);
		agent.setBrand_name(braname);
		agent.setAgent_code("agent_"+code);
		as.insert(agent);
		resp.sendRedirect("admin/jsp/agent/agentList.jsp");
	}
}
