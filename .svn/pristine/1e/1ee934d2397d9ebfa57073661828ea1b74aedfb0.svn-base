package servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.goods.GoodsDao;
import service.goods.GoodsService;
@WebServlet("/deleteokgooods")
/**
 * 删除商品
 * @author guoning
 *
 * 2019年5月30日下午3:31:44
 */
public class DeleteOkGoods extends HttpServlet{
	@Autowired 
	private GoodsService goodsService;
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		String id=req.getParameter("id");
		goodsService.delete(Integer.parseInt(id));
		String aa="{'aa'=0}";
		out.print(aa);
		out.flush();
		out.close();
	}
}
