package servlet.advert;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import dao.util.JsonUtils;
import dao.util.PathPropertiesUtil;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import service.advert.AdvertService;

@WebServlet("/advertUpdateServlet")
@MultipartConfig
public class AdvertUpdateServlet extends HttpServlet{
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
		String id = request.getParameter("advertId");//获取修改时的参数
		//先回显
		//AdvertEntity advert = advertDao.queryOneAdvert(Integer.parseInt(id));
		AdvertEntity advert = advertService.queryOneAdvert(Integer.parseInt(id));
		request.setAttribute("advert", advert);
		request.getRequestDispatcher("admin/jsp/advert/advertUpdate.jsp").forward(request, response);
	}
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
				AdvertEntity advert = new AdvertEntity();
				String savePath = PathPropertiesUtil.getPath("path");//获取存储路径
				Part part = request.getPart("advertUrl");//获取type为file的input的name名
				String header = part.getHeader("content-disposition");
				String fileName = getFileName(header);
				part.write(savePath+"/"+fileName);
				
				String id = request.getParameter("advertId");
				int advertUpdId = Integer.parseInt(id);
				String goodsUpdCode = request.getParameter("goodsCode");
				String updDescride = request.getParameter("descride");
				advert.setId(advertUpdId);
				advert.setGoodsCode(goodsUpdCode);
				advert.setAdvertUrl(savePath+"/"+fileName);
				advert.setDescride(updDescride);
				advertService.updateAdvert(advert);
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
