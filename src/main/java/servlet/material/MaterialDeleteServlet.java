package servlet.material;

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

import dao.material.MaterialDao;
import entity.material.MaterialEntity;
import service.material.MaterialService;

@WebServlet("/materialDeleteServlet")
public class MaterialDeleteServlet extends HttpServlet{
	
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
	private MaterialService materialService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");//解决乱码
		
		PrintWriter out = response.getWriter();
		String strMaterialId = request.getParameter("materialId");
		int materialId = Integer.parseInt(strMaterialId);
		System.out.println(materialId);
		try { //删除成功
			materialService.deleteMaterial(materialId);
			String mtrDelStatus="{\"mtrDelStatus\":0}";//删除成功返回0
			out.print(mtrDelStatus);//返回数据信息
			out.flush();
			out.close();
		} catch (Exception e) {//删除失败
			// TODO: handle exception
			String mtrDelStatus="{\"mtrDelStatus\":1}";
			out.print(mtrDelStatus);//返回数据信息
			out.flush();
			out.close();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
