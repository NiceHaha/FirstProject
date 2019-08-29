package servlet.depa_reciew;

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

import service.depa_reciew.DepaReciewService;

@WebServlet("/depaReciewDeleteServlet")
public class DepaReciewDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepaReciewService depaReciewSerice;
	
	
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		PrintWriter out = resp.getWriter();
		try {
			depaReciewSerice.delete(Integer.parseInt(id));
			out.println("{\"depaReciew\":1}");
		}catch (Exception e) {
			out.println("{\"depaReciew\":0}");
		}finally {
			out.flush();
			out.close();
		}
	}
}
