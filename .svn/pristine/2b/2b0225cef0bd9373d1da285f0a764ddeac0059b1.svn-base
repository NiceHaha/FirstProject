package servlet.brand;

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

import entity.brand.Brand;
import service.brand.BrandService;
@WebServlet("/branddelete")
public class BrandDeleteServlet extends HttpServlet{
	@Autowired
	private BrandService bs;
	//把Servlet变成一个bean
		 public void init(ServletConfig config) throws ServletException {
				//注入spring @Autowired Service
				SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
				super.init();
		 }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 在页面上拿到输入的值
		String id = req.getParameter("brid");
		Brand br = bs.get(Integer.parseInt(id));
		bs.deletegoods(br.getCode());
		bs.deleteag(br.getCode());
		bs.delete(Integer.parseInt(id));
		PrintWriter out =  resp.getWriter();
		out.println("{\"sta\":0}");
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
