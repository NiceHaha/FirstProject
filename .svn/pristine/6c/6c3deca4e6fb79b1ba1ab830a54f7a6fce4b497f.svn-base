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
import dao.util.JsonUtils;
import entity.goods.GoodsEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.goods.GoodsService;

@WebServlet("/okgoods")
public class OkGoods extends HttpServlet{
	
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
		
		//Json的编码格式
		resp.setContentType("aplication/json; charset=utf-8");
		//输出对象
		PrintWriter out =  resp.getWriter();
		//模糊查询名字
		String dataName=req.getParameter("dataName");
		//当前第几页
		List<GoodsEntity> list= null;
		String pageNow=req.getParameter("pageNow");
		PageEntity pageEntity=new PageEntity();
		if(pageNow !=null && !"".equals(pageNow))
		pageEntity.setPageNow(Integer.parseInt(pageNow));
		//得到总条数
		int conut=goodsService.pageCount(dataName);
		pageEntity.setCount(conut);
		//查询方法
		list=goodsService.Query(dataName, pageEntity);
		
		//泛型
		Page page=new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		
		String Josn = JsonUtils.beanToJson(page);//将java转换成一个集合
		out.print(Josn);
		out.flush();
		out.close();
	}
}
