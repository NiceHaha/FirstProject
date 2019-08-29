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
import service.advert.AdvertService;
@WebServlet("/advertUpdateShowServlet")
public class AdvertUpdateShowServlet extends HttpServlet{
	
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("application/json;charset=utf-8");//解决乱码
	String advertShow = request.getParameter("advertShow");//获取展示状态的值，0为可展示，点击变为1取消展示
	String id = request.getParameter("id");
	PrintWriter out = response.getWriter();
	//int mark  = advertDao.updateAdvertShow(Integer.parseInt(advertShow),Integer.parseInt(id));
	int mark = advertService.updateAdvertShow(Integer.parseInt(advertShow),Integer.parseInt(id));
	
	if (mark == 1) {//修改成功，改变效果
		String status="{\"status\":0}";
		out.print(status);//返回数据信息
		out.flush();
		out.close();
	}else {//修改失败，不改变效果
		String status="{\"status\":1}";
		out.print(status);//返回数据信息
		out.flush();
		out.close();
	}
}
	
}
