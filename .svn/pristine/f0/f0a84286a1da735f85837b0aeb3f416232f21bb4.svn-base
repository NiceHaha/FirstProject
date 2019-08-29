package servlet.csr;

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
import entity.csr.CsrEntity;
import entity.depa.DepaEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.csr.CsrService;


/**
 * 查询客服数据
 * @author :lyy
 * @date :下午8:21:50 2019年5月9日
 *
 */
@WebServlet("/CsrQueryServlet")
public class CsrQueryServlet extends HttpServlet{
	
//	CsrService csrService = new CsrService();
	@Autowired
	private CsrService csrService;
	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("aplication/json; charset=utf-8");
		
//		CsrService csrService = new CsrService();
		String csrName = req.getParameter("csrName");

		PageEntity pageEntity = new PageEntity();//分页实体类
		PrintWriter out = resp.getWriter();
		String pageNow = req.getParameter("pageNow");//当前多少页
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(csrName == null) {
			csrName = "";
		}
		int count = csrService.pageCount(csrName); //得到总条数
		pageEntity.setCount(count);
		int pageCount = csrService.pageCount(count,pageEntity.getPageSize());//得到总页数
		pageEntity.setPageCount(pageCount);
		List<CsrEntity> list = csrService.queryCsr(csrName,pageEntity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		String strList = JsonUtils.beanToJson(page);//将java对象List集合转换成json字符串
		out.println(strList);
		out.flush();
		out.close();
	}
}
