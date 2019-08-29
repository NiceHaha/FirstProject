package servlet.goods;

import java.io.IOException;
import java.sql.SQLException;

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
import dao.goods.GoodsDao;
import dao.goodsreciew.GoodsReciewDao;
import dao.util.PathPropertiesUtil;
import entity.goods.GoodsEntity;
import entity.goodsreciew.GoodsReciewEntity;
import service.goods.GoodsService;
import service.goodsreciew.GoodsreciewService;

/**
 * 修改商品
 * @author guoning
 *
 * 2019年5月30日下午3:44:59
 */
@WebServlet("/updateoktrialgoods")
@MultipartConfig
public class UpdateOkTrialGoods extends HttpServlet {
	@Autowired 
	private GoodsService goodsService;
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	/**
	 * 修改回显
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		 GoodsEntity goods= goodsService.Query1(Integer.parseInt(id));
		 req.setAttribute("goods", goods);
		 req.getRequestDispatcher("/admin/jsp/goods/updateOkTrialGoods.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//照片储存路径
		String savePath = PathPropertiesUtil.getPath("path1");
		
		//从文件集合中获取出part对象
		Part part = req.getPart("Goodsimg");
		
		//获取头路径
		String header = part.getHeader("content-disposition");
		
		//调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		
		//把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(savePath+"/"+fileName);
		
		
		
		//id
		String id=req.getParameter("id");
		
		//品牌名字
		String goodsp=req.getParameter("goodsp");
		if(goodsp !=null && !goodsp.equals(""))
		goodsp = new String(goodsp.getBytes("iso-8859-1"),"utf-8");
		
		//代理商名
		String goodsd=req.getParameter("goodsd");
		if(goodsd !=null && !goodsd.equals("")) 
		goodsd = new String(goodsd.getBytes("iso-8859-1"),"utf-8");
		
		//品牌编码
		BrandDao br=new BrandDao();
		String goodstype= br.selectcode(goodsp);
		
		//商品名字
		String goodsname= req.getParameter("goodsname");
		if(goodsname !=null && !goodsname.equals("")) 
		goodsname = new String(goodsname.getBytes("iso-8859-1"),"utf-8");
		
		//商品编码
		String goodsCode= req.getParameter("code");
		if(goodsCode !=null && !goodsCode.equals("")) 
		goodsCode = new String(goodsCode.getBytes("iso-8859-1"),"utf-8");
		
		//商品价格
		String goodsj= req.getParameter("goodsj");
		if(goodsj !=null && !goodsj.equals("")) 
		goodsj = new String(goodsj.getBytes("iso-8859-1"),"utf-8");
		
		//商品商品描述
		String goodsm= req.getParameter("goodsm");
		if(goodsm !=null && !goodsm.equals("")) 
		goodsm = new String(goodsm.getBytes("iso-8859-1"),"utf-8");
		
		//商品颜色
		String goodsy= req.getParameter("goodsy");
		if(goodsy !=null && !goodsy.equals("")) 
		goodsy = new String(goodsy.getBytes("iso-8859-1"),"utf-8");
		
		
		
		GoodsEntity goods=new GoodsEntity();
		goods.setTypeCode(goodstype);
		goods.setId(Integer.parseInt(id));
		goods.setCode(goodsCode);
		goods.setGoodsName(goodsname);
		goods.setGoodsPrice(Integer.parseInt(goodsj));
		goods.setGoodsDescribe(goodsm);
		goods.setGoodsColor(goodsy);
		goods.setGoodsPath(savePath+"/"+fileName);
		
		//GoodsDao dao=new GoodsDao();
		goodsService.update(goods);
		resp.sendRedirect("admin/jsp/goods/oktrialList.jsp");
	}
	
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
	
}
