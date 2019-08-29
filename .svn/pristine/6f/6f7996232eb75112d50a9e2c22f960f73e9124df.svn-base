package target;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import dao.agent.AgentDao;
import entity.agent.Agent;

public class Agtar extends SimpleTagSupport{
	private String id;
	private String agent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		AgentDao ag = new AgentDao();
		List<Agent> list = ag.agentquery();
		//输出一个下拉框
				out.print("<select name='ag' id='ag'>");	
				StringBuffer buff = new StringBuffer();
				for (Agent agent : list) {
					buff.append("<option value=").append(agent.getAgent_name()).append(">").append(agent.getAgent_name()).append("</option>");
				}
				out.print(buff.toString());
				out.print("</select>");
	}
}
