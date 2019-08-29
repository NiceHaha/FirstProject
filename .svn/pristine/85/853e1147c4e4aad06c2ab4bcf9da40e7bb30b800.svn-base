package servlet.csr;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.csr.CsrService;

/**
 * 删除客服数据
 * @author :lyy
 * @date :下午8:22:00 2019年5月9日
 *
 */
@WebServlet("/CsrDeleSerlvet")
public class CsrDeleSerlvet extends HttpServlet{
	
	@Autowired
	private CsrService csrService;
	
	
	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		csrService.deleCsr(Integer.valueOf(id));//Integer.valueOf(userId)把字符串转换成Integer类型
		req.getRequestDispatcher("CsrQueryServlet").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
