package servlet.brand;

import java.io.File;
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

import dao.brand.BrandDao;
import dao.util.PathPropertiesUtil;
import entity.brand.Brand;
import service.brand.BrandService;
@WebServlet("/brandupdate")
@MultipartConfig
public class BrandUpdateServlet extends HttpServlet{
	@Autowired
	private BrandService bs;
	//把Servlet变成一个bean
		 public void init(ServletConfig config) throws ServletException {
				//注入spring @Autowired Service
				SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
				super.init();
		 }
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 在页面上拿到输入的值
		String name = req.getParameter("brName");
		Integer i = bs.count(name); // 查询用户名是存在, 0表示不存在

		if (i == 0) { // 如果数据库中没有此值表示可插入
			PrintWriter out = resp.getWriter();// 转成json格式
			out.println(0);// 放置一个0给页面
			out.flush();
			out.close();
		} else { // 不进行插入
			PrintWriter out = resp.getWriter();// 转成json格式
			out.println(1);// 放置一个1给页面
			out.flush();
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String savePath = PathPropertiesUtil.getPath("path");//获取存储路径
		//String savePath = "C:/Users/Administrator/Desktop/1";
		// 获取上传的文件集合
		/* Collection<Part> parts = request.getParts(); */
		// 从文件集合中获取出part对象
		Part part = req.getPart("brUrl");// 获取type为file的input的name名
		// 获取请求头的格式，f12可见，因为servlet没有直接获取文件名的方法，所以要从请求头中解析出来
		String header = part.getHeader("content-disposition");
		// 调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		// 把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(savePath+"/"+fileName);
		String name = req.getParameter("brName");
		String tel = req.getParameter("brTel");
		String id = req.getParameter("braid");
		Brand brand = new Brand();
		brand.setId(Integer.parseInt(id));
		brand.setBrand_name(name);
		brand.setBrand_tel(tel);
		brand.setBrand_url(savePath+"/"+fileName);
		bs.update(brand);
		resp.sendRedirect("admin/jsp/brand/brandList.jsp");
	}
}
