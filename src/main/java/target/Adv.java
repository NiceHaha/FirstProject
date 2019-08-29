package target;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import dao.brand.BrandDao;
import dao.goods.GoodsDao;
import entity.brand.Brand;
import entity.goods.GoodsEntity;

public class Adv extends RequestContextAwareTag{
private String advertGoodsCode;

public String getAdvertGoodsCode() {
	return advertGoodsCode;
}

public void setAdvertGoodsCode(String advertGoodsCode) {
	this.advertGoodsCode = advertGoodsCode;
}

public GoodsDao getGoodsdao() {
	GoodsDao goodsDao = (GoodsDao) this.getRequestContext().getWebApplicationContext().getBean("goodsDao");
	return goodsDao;
}


	@Override
	protected int doStartTagInternal() throws Exception {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		
		List<GoodsEntity> listGoods = getGoodsdao().Query();
		out.print("<select name='advertGoodsCode' id='advertGoodsCode'>");	
		StringBuffer buffer = new StringBuffer();
		for (GoodsEntity goods : listGoods) {
			buffer.append("<option value=").append(goods.getCode()).append(">").append(goods.getCode()).append("</option>");
		}
		out.print(buffer.toString());
		out.print("</select>");
		return EVAL_PAGE;
	}
}
