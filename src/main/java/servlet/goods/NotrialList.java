package servlet.goods;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.goodsreciew.GoodsReciewDao;
import service.goodsreciew.GoodsreciewService;

@WebServlet("/notrial")
public class NotrialList extends HttpServlet{
	@Autowired 
	private GoodsreciewService goodsreciewService;
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		goodsreciewService.delete(Integer.parseInt(id));
		resp.sendRedirect("admin/index.jsp");
	}

}
