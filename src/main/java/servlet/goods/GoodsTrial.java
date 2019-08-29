package servlet.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.goods.GoodsDao;
import dao.goodsreciew.GoodsReciewDao;
import entity.goods.GoodsEntity;
import entity.goodsreciew.GoodsReciewEntity;
import service.goods.GoodsService;
import service.goodsreciew.GoodsreciewService;

@WebServlet("/GoodsTrial")
public class GoodsTrial extends HttpServlet{
	@Autowired 
	private GoodsreciewService goodsreciewService;
	@Autowired
	private GoodsService goodsService;
	//把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		List<GoodsReciewEntity> list =goodsreciewService.query(Integer.parseInt(id));
		for (GoodsReciewEntity goodse : list) {
			//品牌编号
			String typecode=goodse.getTypeCode();
			//代理商编号
			String goodsagetntcode=goodse.getAgentCode();
			//商品编号
			String goodscode= goodse.getGoodsCode();
			//商品名字
			String goodsname= goodse.getGoodsName();
			//商品图片
			String goodspate=goodse.getGoodsPath();
			//商品价格
			int goodsprice=goodse.getGoodsPrice();
			//商品颜色
			String goodscolor=goodse.getGoodsColor();
			//商品描述
			String goodsdescride=goodse.getGoodsDescribe();
			
			GoodsEntity goods=new GoodsEntity();
			//商品编号
			goods.setCode(goodscode);
			//商品名字
			goods.setGoodsName(goodsname);
			//商品的品牌编号
			goods.setTypeCode(typecode);
			//商品代理商的编号
			goods.setAgentCode(goodsagetntcode);
			//商品的颜色
			goods.setGoodsColor(goodscolor);
			//商品的描述
			goods.setGoodsDescribe(goodsdescride);
			//商品的价格
			goods.setGoodsPrice(goodsprice);
			//商品的图片
			goods.setGoodsPath(goodspate);
			//GoodsDao goodsdao=new GoodsDao();
			goodsService.add(goods);
		}
		//审核通过之后把未审核那里给删了
		goodsreciewService.delete(Integer.parseInt(id));
		resp.sendRedirect("admin/jsp/goods/trialList.jsp");
	}
}
