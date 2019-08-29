package servlet.material;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.Collection;

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
import dao.util.PropertiesUtil;
import entity.material.MaterialEntity;
import service.material.MaterialService;

@WebServlet("/materialInsertServlet")
@MultipartConfig
public class MaterialInsertServlet extends HttpServlet{
	
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
		
		PrintWriter out = response.getWriter();
		String materialInsertName = request.getParameter("materialInsertName");
		int mark = 0;
		if (materialInsertName == null || materialInsertName.equals("")) { //如果新增的名字是空，说明进来的是修改的名字
			String materialUpdateName = request.getParameter("materialUpdateName");
			String strMaterialId = request.getParameter("materialUpdateId"); 
			mark = materialService.checkUpdateMaterialName(materialUpdateName, Integer.parseInt(strMaterialId));
		}else {//新增的名字不为空，则进来的是新增的名字
			mark = materialService.checkMaterialName(materialInsertName);
		}
		
		if (mark == 0) {//用户名不存在，可以添加
			String status="{\"status\":0}";
			out.print(status);//返回数据信息
			out.flush();
			out.close();
		}else {//用户名存在，不可以添加
			String status="{\"status\":1}";
			out.print(status);//返回数据信息
			out.flush();
			out.close();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//存储路径
		String savePath = PathPropertiesUtil.getPath("path");//获取存储路径
		//从文件集合中获取出part对象
		Part part = request.getPart("materialUrl");//获取type为file的input的name名
		//获取请求头的格式，f12可见，因为servlet没有直接获取文件名的方法，所以要从请求头中解析出来
		String header = part.getHeader("content-disposition");
		//调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		String wholeFileName = savePath+"/"+fileName; 
		//把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(wholeFileName);
		//设路径给数据库
		
		MaterialEntity material = new MaterialEntity();
		/*素材名称*/
		String materialName = request.getParameter("materialName");
		/*素材编号*/
		int code = (int) Math.round(Math.random()*777777);
		String materialCode = "material"+String.valueOf(code);
		material.setMaterialCode(materialCode);
		material.setMaterialName(materialName);
		material.setMaterialUrl(wholeFileName); 
		materialService.insertMaterial(material);
		
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
