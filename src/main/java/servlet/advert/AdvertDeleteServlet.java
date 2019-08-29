package servlet.advert;

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

import dao.advert.AdvertDao;
import dao.material.MaterialDao;
import service.advert.AdvertService;
@WebServlet("/advertDeleteServlet")
public class AdvertDeleteServlet extends HttpServlet{
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
		
		PrintWriter out = response.getWriter();
		String deleteId = request.getParameter("id");
		int id = Integer.parseInt(deleteId);
		try { //删除成功
			
			//advertDao.deleteAdvert(id);
			advertService.deleteAdvert(id);
			String advDelStatus="{\"advDelStatus\":0}";//删除成功返回0
			out.print(advDelStatus);//返回数据信息
			out.flush();
			out.close();
			
		} catch (Exception e) {//删除失败
			// TODO: handle exception
			String advDelStatus="{\"advDelStatus\":1}";
			out.print(advDelStatus);//返回数据信息
			out.flush();
			out.close();
		}
	}
	
}
