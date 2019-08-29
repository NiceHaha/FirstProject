package controller.csr;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import entity.csr.CsrEntity;
import entity.page.PageEntity;
import service.csr.CsrService;

/**
 * 	自定义视图
 * 	导出excel表
 * @author :lyy
 * @date :下午2:33:47 2019年6月8日
 *
 */
@Component
public class ExcelViewResolver extends AbstractXlsView {
	
	@Autowired
	private CsrService csrService;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;//用于国际化
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Locale locale = (Locale)request.getSession().getAttribute("locale");
		
		
		String fileName = "客服Excel表.xls";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/ms-excel");
		response.setHeader("Content-Disposition", "inline; filename=" + new String(fileName.getBytes(), "iso8859-1"));
		OutputStream outputStream = response.getOutputStream();

		// 产生Excel表头
		Sheet sheet = workbook.createSheet("基本信息");
		Row header = sheet.createRow(0);
		
		// 产生标题列
		header.createCell(0).setCellValue(messageSource.getMessage("depa.id", null, locale));
        header.createCell(1).setCellValue(messageSource.getMessage("csr.csrName", null, locale));
        header.createCell(2).setCellValue(messageSource.getMessage("csr.csrSex", null, locale));
        header.createCell(3).setCellValue(messageSource.getMessage("csr.csrAge", null, locale));
        header.createCell(4).setCellValue(messageSource.getMessage("csr.csrTel", null, locale));
        header.createCell(5).setCellValue(messageSource.getMessage("csr.csrPath", null, locale));
        header.createCell(6).setCellValue(messageSource.getMessage("csr.csrStatus", null, locale));
        header.createCell(7).setCellValue(messageSource.getMessage("csr.empCode", null, locale));
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
		int rowNumber = 1;
		List<CsrEntity> list = csrService.queryCsr("",new PageEntity());
		for (CsrEntity csrEntity : list) {
			
			Row row = sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(csrEntity.getId());
			row.createCell(1).setCellValue(csrEntity.getCsrName());
			row.createCell(2).setCellValue(csrEntity.getCsrSex());
			row.createCell(3).setCellValue(csrEntity.getCsrAge());
			row.createCell(4).setCellValue(csrEntity.getCsrTel());
			row.createCell(5).setCellValue(csrEntity.getCsrPath());
			row.createCell(6).setCellValue(csrEntity.getCsrStatus());
			row.createCell(7).setCellValue(csrEntity.getEmpCode());
		}
		// 产生标题列
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}
}
