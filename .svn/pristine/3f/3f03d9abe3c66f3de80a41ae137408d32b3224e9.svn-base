package servlet.depa_reciew;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.depa_reciew.DepaReciewEntity;
import service.depa_reciew.DepaReciewService;

@WebServlet("/depaReciewAddServlet")
public class DepaReciewAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepaReciewService depaReciewService;

	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DepaReciewEntity depaReciewEntity = new DepaReciewEntity();
		String name = req.getParameter("name");
		String code = "DEPA-"+(int)Math.round(Math.random()*9999999);
		depaReciewEntity.setName(name);
		depaReciewEntity.setCode(code);
		depaReciewService.insert(depaReciewEntity);
		resp.sendRedirect("admin\\jsp\\depa\\depaList.jsp");
	}
}
