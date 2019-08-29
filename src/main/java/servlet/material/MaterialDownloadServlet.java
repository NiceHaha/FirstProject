package servlet.material;

import java.io.BufferedInputStream;
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

@WebServlet("/materialDownloadServlet")
public class MaterialDownloadServlet extends HttpServlet{
	//把Servlet变成一个bean
		public void init(ServletConfig config) throws ServletException {
			// 注入spring @Autowired Service
			SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
			super.init();
		}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*获取图片路径*/
		String materialUrl = request.getParameter("materialUrl");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(materialUrl));
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		byte[] bs = new byte[1024];
		response.setCharacterEncoding("utf-8");  
		int reads=0;
		while((reads=bufferedInputStream.read(bs, 0, bs.length)) != -1) {
			servletOutputStream.write(bs,0, reads);
			servletOutputStream.flush();
		}
		
		servletOutputStream.close();
		bufferedInputStream.close();
		}
	

}
