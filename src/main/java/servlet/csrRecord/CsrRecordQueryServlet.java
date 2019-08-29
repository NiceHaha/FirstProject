package servlet.csrRecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.util.JsonUtils;
import entity.csr.CsrEntity;
import entity.csrRecord.CsrRecordEntity;
import entity.page.Page;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.csr.CsrService;
import service.csrRecord.CsrRecordService;


/**
 * 查询客服记录
 * @author :lyy
 * @date :下午3:41:12 2019年5月10日
 *	
 *
 *
 *	该功能未实现！！！
 */
@WebServlet("/CsrRecordQueryServlet")
public class CsrRecordQueryServlet extends HttpServlet{
	
	CsrRecordService csrRecordService = new CsrRecordService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//根据编号查询出客服的聊天记录
		resp.setContentType("aplication/json; charset=utf-8");
		CsrRecordService csrRecordService = new CsrRecordService();
		PageEntity pageEntity = new PageEntity();//分页实体类
		String csrName = req.getParameter("csrName");
		String pageNow = req.getParameter("pageNow");//当前多少页
//		String pageSize = req.getParameter("pageSize"); //每页显示多少条数据
		
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		int count = csrRecordService.count(); //得到总条数
		pageEntity.setCount(count);
		List<CsrRecordEntity> list = csrRecordService.queryCsr(csrName,pageEntity);
		req.setAttribute("pageEntity", pageEntity);	
		req.setAttribute("list",list);
		req.getRequestDispatcher("admin\\jsp\\csrRecord\\csrRecordList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("aplication/json; charset=utf-8");
//		//查询客服数据
//		List<CsrRecordEntity> list = csrRecordService.queryCsr();
//		PrintWriter out = resp.getWriter();
//		String strList = JsonUtils.beanListToJson(list);////将java对象list集合转换成json字符串
//		out.println(strList);
//		out.close();
	}
}
