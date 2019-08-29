package servlet.goods;

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

import dao.agent.AgentDao;
import dao.brand.BrandDao;
import dao.goodsreciew.GoodsReciewDao;
import dao.util.PathPropertiesUtil;
import entity.goodsreciew.GoodsReciewEntity;
import service.Agent.AgentService;
import service.brand.BrandService;
import service.goodsreciew.GoodsreciewService;


@WebServlet("/addgoods")
@MultipartConfig
public class AddGoods extends HttpServlet{
	@Autowired 
	private GoodsreciewService goodsreciewService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private BrandService brandService;
	
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//照片储存路径
		String savePath = PathPropertiesUtil.getPath("path1");
		System.out.println(savePath);
		
		//从文件集合中获取出part对象
		Part part = req.getPart("Goodsimg");
		
		//获取头路径
		String header = part.getHeader("content-disposition");
		
		//调用getFileName方法来获取文件名
		String fileName = getFileName(header);
		
		//把文件写到指定位置，文件名为 文件路径+斜杆+文件名
		part.write(savePath+"/"+fileName);
		
		
			

		//商品品牌
		String goodsp= req.getParameter("goodsp");
		if(goodsp !=null && !goodsp.equals(""))
		goodsp = new String(goodsp.getBytes("iso-8859-1"),"utf-8");
		//商品代理商
		String gooodsd=req.getParameter("goodsd");
		if(gooodsd !=null && !gooodsd.equals(""))
		gooodsd = new String(gooodsd.getBytes("iso-8859-1"),"utf-8");	
		
		//得到代理商编号
		String ageetcode= agentService.agentcode(gooodsd);
		
		
		//商品名字
		String goodsname= req.getParameter("goodsname");
		if(goodsname !=null && !goodsname.equals("")) {
		goodsname = new String(goodsname.getBytes("iso-8859-1"),"utf-8");
		}
		//得到品牌的编码
		String goodstype= brandService.selectcode(goodsp);
		
		//商品价格
		String goodsj= req.getParameter("goodsj");
		
		//商品描述
		String goodsm= req.getParameter("goodsm");
		if(goodsm !=null && !goodsm.equals("")) {
		goodsm = new String(goodsm.getBytes("iso-8859-1"),"utf-8");
		}
		//商品颜色
		String goodsy=null;
		if(req.getParameter("goodsy") !=null && !req.getParameter("goodsy").equals("")) {
			goodsy= req.getParameter("goodsy");
		}else {
			goodsy="";
		}
		if(goodsy !=null && !goodsy.equals("")) {
		goodsy = new String(goodsy.getBytes("iso-8859-1"),"utf-8");
		}
		//表名加随机数成一个编码
		int code = (int)Math.round(Math.random()*888888);
		
		//默认给审核状态填入一个0 0代表未审核
		int to=0;
		
		//设值
		GoodsReciewEntity goods=new GoodsReciewEntity();
		goods.setGoodsCode("Goods"+code);
		goods.setGoodsName(goodsname);
		if(goodsj !=null && !goodsj.equals("")) {
		goods.setGoodsPrice(Integer.parseInt(goodsj));
		}else {
			goods.setGoodsPrice(0);
		}
		goods.setGoodsDescribe(goodsm);
		goods.setGoodsColor(goodsy);
		goods.setTypeCode(goodstype);
		goods.setGoodsTo(to);
		//商品图片
		goods.setGoodsPath(savePath+"/"+fileName);
		goods.setAgentCode(ageetcode);
		
		goodsreciewService.add(goods);
	
		resp.sendRedirect("admin/jsp/goods/goodsList.jsp");
	}
	
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
}
