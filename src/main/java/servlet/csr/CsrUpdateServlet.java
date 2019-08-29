package servlet.csr;

import java.io.File;
import java.io.IOException;
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

import entity.csr.CsrEntity;
import service.csr.CsrService;

/**
 * 修改客服数据
 * @author :lyy
 * @date :下午8:21:33 2019年5月9日
 *
 */
@WebServlet("/CsrUpdateServlet")
@MultipartConfig//文件上传
public class CsrUpdateServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CsrService csrService;
	
	
	
	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}
	
	
	/**
	 * 回显数据
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CsrEntity csrEntity = csrService.queryCsrId(Integer.valueOf(id));
		req.setAttribute("csrEntity",csrEntity);//"list"这个传到request里面用于jsp
		req.getRequestDispatcher("admin/jsp/csr/csrUpdate.jsp").forward(req, resp);
	}
	
	
	/**
	 * 头像修改
	 * @param header
	 * @return
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 * E:\snmp4j--api.zip
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

	
	/**
	 * 修改数据写在这个里面
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//----------------------------------
		
//		String path = req.getParameter("path");
//		path = new String(path.getBytes("iso-8859-1"),"utf-8");
		Part part = req.getPart("fileName");// 通过表单file控件(<input type="file" name="file1">)的名字直接获取Part对象
		
		String header = part.getHeader("content-disposition");
		
		String savePath = "d:/Users/king/Desktop/文件上传";//文件上传的路径
		 
		// 获取文件名
		String fileName = getFileName(header);
		// 把文件写到指定路径
		part.write(savePath + File.separator + fileName);
		String id = req.getParameter("id");
		String name = req.getParameter("csrName");//获取页面客服name的值
		name = new String(name.getBytes("iso-8859-1"),"utf-8");

		String sex = req.getParameter("csrSex");
		String age = req.getParameter("csrAge");
		String tel = req.getParameter("csrTel");
		String status = req.getParameter("csrStatus");//客服是否在线
		int empCode = (int)Math.round(Math.random()*9999999);//客服编码（产生随机数）
		
		CsrEntity csrEntity = new CsrEntity();
		String pathName = savePath + "/" + fileName;//获取文件路径
		csrEntity.setCsrName(name);//名字
		csrEntity.setCsrSex(Integer.parseInt(sex));//性别Integer.parseInt强转
		csrEntity.setCsrAge(Integer.parseInt(age));//年龄Integer.parseInt强转
		csrEntity.setCsrTel(tel);//电话
		csrEntity.setCsrStatus(Integer.parseInt(status));//客服是否在线
		csrEntity.setCsrPath(pathName);//头像
		csrEntity.setEmpCode("KFB-CSR-"+empCode);//客服编号
//		CsrService csrService = new CsrService();
		csrService.updateCsr(csrEntity,Integer.valueOf(id));
		resp.sendRedirect("admin/jsp/csr/csrList.jsp");
		
	}
}
