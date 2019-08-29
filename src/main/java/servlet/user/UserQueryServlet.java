package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import dao.util.JsonUtils;
import entity.page.Page;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.user.UserService;

/**
 * Servlet implementation class UserQuery
 */
@WebServlet("/userQueryServlet")
public class UserQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
       
	
	// 本身是spring容器里面的一个BEAN才能注入其它的Bean
	// 把Servlet变成一个bean
	public void init(ServletConfig config) throws ServletException {
		// 注入spring @Autowired Service
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("aplication/json; charset=utf-8");
		PageEntity pageEntity = new PageEntity();
		String userName = request.getParameter("userName");
		String pageNow = request.getParameter("pageNow");
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(userName == null) {
			userName = "";
		}
		int count = userService.count(userName);//得到总条数
		pageEntity.setCount(count);
		List<UserEntity> list = userService.query(userName, pageEntity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		PrintWriter out =  response.getWriter();
		String strList = JsonUtils.beanToJson(page);//将java对象List集合转换成json字符串
		out.println(strList);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
