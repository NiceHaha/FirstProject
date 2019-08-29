package target;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import dao.goods.GoodsDao;
import dao.material.MaterialDao;
import entity.goods.GoodsEntity;
import entity.material.MaterialEntity;

public class Imgs extends SimpleTagSupport {

private String chooseMaterialUrl;

	public String getChooseMaterialUrl() {
	return chooseMaterialUrl;
}

public void setChooseMaterialUrl(String chooseMaterialUrl) {
	this.chooseMaterialUrl = chooseMaterialUrl;
}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		MaterialDao materialDao = new MaterialDao();
		List<MaterialEntity> listMaterial = materialDao.queryMaterial();
		out.print(
               "<div id='mtrBody'>"+
		"<div class='sitTable ' >"+
			"<div id='date'>");
				
				
		StringBuffer buffer = new StringBuffer();
		for (MaterialEntity material : listMaterial) {
			buffer.append("<div class='dateDiv' ><div class='imgDiv '><img src='<%=request.getContextPath()%>/materialDownloadServlet?materialUrl=").append(material.getMaterialUrl()).append("' style='width:100px;'/></div>").append("<p>").append(material.getMaterialName()).append("</p><div class='btnDiv'>" + 
					"<button class='btn btn-danger btn-xs'  name='addMaterial' materialId='"+material.getMaterialId()+"'>确定</button>").append("</div></div>");
		};
		out.print(buffer.toString());
		out.print("</div></div></div>");
	}
}
