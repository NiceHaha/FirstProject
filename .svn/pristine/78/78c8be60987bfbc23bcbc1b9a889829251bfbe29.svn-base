package servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import dao.util.JsonUtils;
import entity.goodsreciew.GoodsReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.goodsreciew.GoodsreciewService;


@WebServlet("/ListGoods")
public class ListGoods extends HttpServlet{
	
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
		//Json的编码格式
		resp.setContentType("aplication/json; charset=utf-8");
		PrintWriter out =  resp.getWriter();
		List<GoodsReciewEntity> list=null;
		PageEntity pageentity=new PageEntity(); 
		String dateName= req.getParameter("dataName");
		String pageNow=req.getParameter("pageNow");
		//将值设到page对象里面
		if(pageNow !=null && !"".equals(pageNow))
		pageentity.setPageNow(Integer.parseInt(pageNow));
		
		//得到总条数
//		int conut=dao.pageCount(dateName);
		int conut=goodsreciewService.pageCount(dateName);
		pageentity.setCount(conut);
		
		//得到List对象
		//list=dao.query3(dateName,pageentity);
		list = goodsreciewService.query3(dateName, pageentity);
		
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageentity);
		
		String pageJosn = JsonUtils.beanToJson(page);
		out.print(pageJosn);
		out.flush();
		out.close();
	}
	
}
