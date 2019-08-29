package target;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import dao.brand.BrandDao;
import entity.brand.Brand;

public class Mygoodsp extends RequestContextAwareTag {
	private String id;
	private String brand;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BrandDao getAgentdao() {
		BrandDao brandDao = (BrandDao) this.getRequestContext().getWebApplicationContext().getBean("brandDao");
		return brandDao;
	}
	
	@Override
	protected int doStartTagInternal() throws Exception {
		JspWriter out = pageContext.getOut();
		List<Brand> list = getAgentdao().query();
		// 输出一个下拉框
		out.print("<select name='goodsp' id='goodsp'>");
		StringBuffer buff = new StringBuffer();
		for (Brand brand : list) {
			buff.append("<option value=").append(brand.getBrand_name()).append(">").append(brand.getBrand_name())
					.append("</option>");
		}
		out.print(buff.toString());
		out.print("</select>");
		return EVAL_PAGE;
	}
}
