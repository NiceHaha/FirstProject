package servlet.depa;

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
import entity.depa.DepaEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.depa.DepaService;

/**
 * Servlet implementation class DepaQueryServlet
 */
@WebServlet("/depaQueryServlet")
public class DepaQueryServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("aplication/json; charset=utf-8");
		PageEntity pageEntity = new PageEntity();
//		DepaService depaService = new DepaService();
		PrintWriter out =  response.getWriter();
		String depaName = request.getParameter("depaName");
		String pageNow = request.getParameter("pageNow");
		
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(depaName == null ) {
			depaName = "";
		}
		int count = depaService.count(depaName); //得到总条数
		pageEntity.setCount(count);
//		int pageCount = pageDao.pageCount(count,pageEntity.getPageSize());//得到总页数
//		pageEntity.setPageCount(pageCount);
		List<DepaEntity> list = depaService.query(depaName,pageEntity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		String strList = JsonUtils.beanToJson(page);//将java对象List集合转换成json字符串
		out.println(strList);
		out.flush();
		out.close();
	}
}
