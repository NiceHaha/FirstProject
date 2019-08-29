package servlet.csrRecord;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.csr.CsrService;
import service.csrRecord.CsrRecordService;

/**
 * 删除客服记录
 * @author :lyy
 * @date :下午3:41:02 2019年5月10日
 *	
 *
 *
 *
 *	该功能未实现！！！
 */
@WebServlet("/CsrRecordDeleServlet")
public class CsrRecordDeleServlet extends HttpServlet{
	
	
	CsrRecordService  csrRecordService = new CsrRecordService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CsrRecordService csrRecordService = new CsrRecordService();
		String empCode = csrRecordService.queryCsrId(Integer.parseInt(id));
		csrRecordService.deleCsr(Integer.parseInt(id));//Integer.valueOf(userId)把字符串转换成Integer类型
		req.setAttribute("empCode",empCode);
		req.getRequestDispatcher("CsrRecordQueryServlet").forward(req, resp);
//		resp.sendRedirect("CsrRecordQueryServlet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
