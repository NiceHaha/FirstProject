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
import service.depa.DepaService;

/**
 * Servlet implementation class DepaUpdeteServlet
 */
@WebServlet("/depaUpdeteServlet")
public class DepaUpdeteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
	private DepaService depaService;
   
	
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		DepaService depaService = new DepaService();
		DepaEntity depaEntity = depaService.queryId(Integer.parseInt(id));
//		DepaEntity depa = new DepaEntity();
//		for (DepaEntity depaEntity : list) {
//			depa.setName(depaEntity.getName());
//			depa.setCode(depaEntity.getCode());
//			depa.setId(depaEntity.getId());
//		}
		request.setAttribute("depa",depaEntity);
		request.getRequestDispatcher("admin\\jsp\\depa\\depaUpdete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		if(name != null && "".equals(name)) {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}
//		DepaService depaService = new DepaService();
		DepaEntity depaEntity = new DepaEntity();
		depaEntity.setName(name);
		depaEntity.setCode(code);
		depaService.update(depaEntity, Integer.parseInt(id));
		response.sendRedirect("admin\\jsp\\depa\\depaList.jsp");
	}

}
