package target;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import entity.depa.DepaEntity;
import service.depa.DepaService;

public class Emp extends RequestContextAwareTag{
	private String name;
	
	//得到Bean
	public DepaService getDepaEntity() {
		DepaService depaDao = (DepaService)this.getRequestContext().getWebApplicationContext().getBean(DepaService.class);
		return depaDao;
	}


	@Override
	protected int doStartTagInternal() throws Exception {
		JspWriter out = pageContext.getOut();
		DepaService depaService = getDepaEntity();
		List<DepaEntity> list = depaService.query();
		// 输出一个下拉框
		out.print("<select name='depaName' id='depaName'>");
		StringBuffer buff = new StringBuffer();
		for (DepaEntity depaEntity : list) {
			buff.append("<option value=").append(depaEntity.getName()).append(" ${empEntity.depaName=='"+depaEntity.getName()+"'?'selected':''}>").append(depaEntity.getName())
					.append("</option>");
		}
		out.print(buff.toString());
		out.print("</select>");
		return EVAL_PAGE;
	}
}
