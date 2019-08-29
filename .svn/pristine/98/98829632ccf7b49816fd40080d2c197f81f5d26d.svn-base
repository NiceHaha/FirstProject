package filter;


import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter2 implements Filter{


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// TODO Auto-generated method stub
		HttpServletRequest request1=(HttpServletRequest) request;//把ServletRequest强转为HttpServletRequest，为了获取session
		HttpServletResponse response1=(HttpServletResponse) response;
		
		
		String url=request1.getRequestURI();//得到请求路径
		
		
		if(url.endsWith("alogin.jsp") || url.endsWith("cha2") || url.endsWith("register.jsp")  || url.endsWith("login.jsp")) {//判断是否以什么结尾,会放行
			chain.doFilter(request, response);//继续执行
			return;
		}else {//加上else不然死循环
			String name=(String) request1.getSession().getAttribute("username");
		if (name==null || name.equals("")) {
			response1.sendRedirect("/GF/flogin/alogin.jsp");//跳到后台登录页面
			
		}else {
			chain.doFilter(request, response);//继续执行
			return;
		}
		
		}
	}
	
}
