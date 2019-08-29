package servlet.depa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import entity.depa.DepaEntity;
import entity.depa_reciew.DepaReciewEntity;
import service.depa.DepaService;
import service.depa_reciew.DepaReciewService;

@WebServlet("/depaAddServlet")

//@MultipartConfig
//文件上传下载时用的注解
public class DepaAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepaReciewService depaReciewService;
	@Autowired
	private DepaService depaService;
	
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	 
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		DepaReciewService depaReciewService = new DepaReciewService();
		String id = req.getParameter("id");
		DepaReciewEntity list = depaReciewService.queryId(Integer.parseInt(id));
		depaReciewService.delete(Integer.parseInt(id));
		DepaEntity depaEntity = new DepaEntity();
		depaEntity.setCode(list.getCode());
		depaEntity.setName(list.getName());
		depaService.insert(depaEntity);
		resp.sendRedirect("admin\\jsp\\depaReciew\\depaReciewList.jsp");
	}
}
