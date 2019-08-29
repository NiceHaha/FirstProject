package servlet.material;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.material.MaterialDao;
import dao.util.PathPropertiesUtil;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import service.material.MaterialService;
@WebServlet("/materialUpdateServlet")
@MultipartConfig
public class MaterialUpdateServlet extends HttpServlet{

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
	String materialId = request.getParameter("materialId");//获取修改时的参数
	//先回显
	MaterialEntity material = materialService.queryOneMaterial(Integer.parseInt(materialId));
	
	request.setAttribute("material", material);
	request.getRequestDispatcher("admin/jsp/material/materialUpdate.jsp").forward(request, response);
}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MaterialEntity material = new MaterialEntity();
		
		String savePath = PathPropertiesUtil.getPath("path");//获取存储路径
		System.out.println(savePath);
		//从文件集合中获取出part对象
		Part part = request.getPart("materialUrl");//获取type为file的input的name名
		//获取请求头的格式，f12可见，因为servlet没有直接获取文件名的方法，所以要从请求头中解析出来
		String header = part.getHeader("content-disposition");
		//调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		//把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(savePath+"/"+fileName);
		
		String materialUpdCode = request.getParameter("materialCode");
		String materialId = request.getParameter("materialId");
		int materialUpdId = Integer.parseInt(materialId);
		String materialUpdName = request.getParameter("materialName");
		material.setMaterialId(materialUpdId);
		material.setMaterialCode(materialUpdCode);
		/*material.setMaterialUrl(materialUpdUrl);*/
		material.setMaterialUrl(savePath+"/"+fileName); 
		material.setMaterialName(materialUpdName);
		materialService.updateMaterial(material);
		response.sendRedirect("admin/jsp/material/materialList.jsp");
	}
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
}
