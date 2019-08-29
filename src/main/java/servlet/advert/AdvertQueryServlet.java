package servlet.advert;

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

import dao.advert.AdvertDao;
import dao.material.MaterialDao;
import dao.util.JsonUtils;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.advert.AdvertService;


@WebServlet("/advertQueryServlet")
public class AdvertQueryServlet extends HttpServlet{
	//将一个servlet变成bean
		public void init(ServletConfig config){ 
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
			try {
				super.init();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Autowired
		private AdvertService advertService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");//解决乱码
		//String pageSize = request.getParameter("pageSize");
		PageEntity page = new PageEntity();
		String pageNow = request.getParameter("pageNow");
		if (pageNow != null && !pageNow.equals("")) {
			page.setPageNow(Integer.parseInt(pageNow));
		}
		
		List<AdvertEntity> listAdvert = advertService.queryAdvertPage(page);
		
		Page<AdvertEntity> pageT = new Page<>();
		pageT.setList(listAdvert);
		pageT.setPageEntity(page);
		
		String data= JsonUtils.beanToJson(pageT);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");//解决乱码
		PrintWriter out = response.getWriter();
		List<AdvertEntity> listAdvert = advertService.queryAdvert();
		String data = JsonUtils.listToJson(listAdvert);
		out.print(data);
		out.flush();
		out.close();
	}
}
