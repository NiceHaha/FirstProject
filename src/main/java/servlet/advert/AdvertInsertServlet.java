package servlet.advert;

import java.io.File;
import java.io.IOException;

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

import dao.advert.AdvertDao;
import dao.material.MaterialDao;
import dao.util.PathPropertiesUtil;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import service.advert.AdvertService;

@WebServlet("/advertInsertServlet")
@MultipartConfig
public class AdvertInsertServlet extends HttpServlet{
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		AdvertEntity advert = new AdvertEntity();
		/*广告图片*/
		String savePath = PathPropertiesUtil.getPath("path");//获取存储路径
		//获取上传的文件集合
		/*Collection<Part> parts = request.getParts();*/
		//从文件集合中获取出part对象
		Part part = request.getPart("advertUrl");//获取type为file的input的name名
		//获取请求头的格式，f12可见，因为servlet没有直接获取文件名的方法，所以要从请求头中解析出来
		String header = part.getHeader("content-disposition");
		//调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		//把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(savePath+"/"+fileName);
		
		/*商品编号*/
		String advertGoodsCode = request.getParameter("advertGoodsCode");
		/*广告描述*/
		String descride = request.getParameter("descride");
		/*图片路径*/
		advert.setAdvertUrl(savePath+"/"+fileName);
		/*点击次数，默认为0*/
		advert.setAdvertClick(0);
		/*展示状态，默认为0，不展示。1为展示*/
		advert.setAdvertShow(0);
		
		
		//点击次数，默认为0
		/*String advertClick = request.getParameter("advertClick");
		System.out.println(advertClick);
		
		advert.setAdvertClick(Integer.parseInt(advertClick));*/
		//展示状态，默认为0，不展示。1为展示
		/*String advertShow = request.getParameter("advertShow");
		System.out.println(advertShow);
		
		advert.setAdvertShow(Integer.parseInt(advertShow));*/
		
		advert.setDescride(descride);
		advert.setGoodsCode(advertGoodsCode);
		
		
		//advertDao.insertAdvert(advert);
		advertService.insertAdvert(advert);
		response.sendRedirect("admin/jsp/advert/advertList.jsp");
	}
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
}
