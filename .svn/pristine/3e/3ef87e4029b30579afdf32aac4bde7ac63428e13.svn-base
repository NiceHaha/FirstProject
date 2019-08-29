package servlet.depa;

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

import service.depa.DepaService;

/**
 * Servlet implementation class DepaDeleteServlet
 */
@WebServlet("/depaDeleteServlet")
public class DepaDeleteServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		try {
			depaService.delete(Integer.parseInt(id));
			out.println("{\"depa\":1}");
		}catch (Exception e) {
			out.println("{\"depa\":0}");
		}finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
