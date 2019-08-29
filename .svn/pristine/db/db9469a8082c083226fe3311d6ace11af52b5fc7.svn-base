package servlet.depa_reciew;

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

import dao.util.JsonUtils;
import entity.depa_reciew.DepaReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.depa_reciew.DepaReciewService;

@WebServlet("/depaReciewQueryServlet")
public class DepaReciewQueryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Autowired
	private DepaReciewService depaReciewSerice;
	
	//本身是spring容器里面的一个BEAN才能注入其它的Bean
	//把Servlet变成一个bean
	 public void init(ServletConfig config) throws ServletException {
		//注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	 }

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		PageEntity pageEntity = new PageEntity();
		String depaName = req.getParameter("depaName");
		String pageNow = req.getParameter("pageNow");//页面传来的当前页
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(depaName == null) {
			depaName = "";
		}
		int count = depaReciewSerice.count(depaName);//总条数
		pageEntity.setCount(count);
		List<DepaReciewEntity> list= depaReciewSerice.query(depaName, pageEntity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		
		String strList = JsonUtils.beanToJson(page);//将java对象List集合转换成json字符串
		PrintWriter out = resp.getWriter();
		out.println(strList);
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
