package servlet.csr;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * 下载文件
 * @author :lyy
 * @date :下午10:17:17 2019年5月14日
 *
 */
@WebServlet("/CsrDownLoadServlet")
public class CsrDownLoadServlet extends HttpServlet{

	
	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}

	
	
	/**
	 * 获取文件名
	 * @param header 
	 * @return
	 */
	public String getFileName(String header) {
		String[] tempArr1 = header.split("/");//根据反斜杠分
		String fileName  = tempArr1[tempArr1.length-1];//获取文件名，兼容各种浏览器的写法
		return fileName;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getParameter("csrPath");
		File file = new  File(path);
		FileInputStream InputStream = new FileInputStream(file);
		BufferedInputStream buff = new BufferedInputStream(InputStream);
		byte[] b = new byte[1024 * 1024 * 1];
		resp.setCharacterEncoding("utf-8");
		String filePath = getFileName(path);
		resp.setHeader("Content-Disposition", "attachment; filename="+filePath+"");//下载图片的路径，这是个死路径
		int a = 0;
		ServletOutputStream out = resp.getOutputStream();
		while((a = buff.read(b,0,b.length))!= -1) {
			out.write(b,0,a);
			out.flush();
		}
		out.close();
		buff.close();
		InputStream.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
