package servlet.goods;

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

import dao.goods.GoodsDao;
import dao.goodsreciew.GoodsReciewDao;
import service.goods.GoodsService;
import service.goodsreciew.GoodsreciewService;

@WebServlet("/judegaddname")
public class JudgeAddName extends HttpServlet {
	@Autowired 
	private GoodsreciewService goodsreciewService;
	@Autowired
	private GoodsService goodsService;
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	//判断名字是否重复
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		String id=req.getParameter("id");
		String name=req.getParameter("goodsName");
		int num=0;
		if(id==null || id.equals("")) {
			num= goodsreciewService.query4(name);
		}else {
			num= goodsreciewService.query4(name,Integer.parseInt(id));
		}
		String bool= "{\"bool\":"+num+"}";
		out.print(bool);
		out.flush();
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		String id=req.getParameter("id");
		String name=req.getParameter("goodsName");
		int num=0;	
		num= goodsService.Query(name, Integer.parseInt(id));
		String bool= "{\"bool\":"+num+"}";
		out.print(bool);
		out.flush();
		out.close();
	}
}
