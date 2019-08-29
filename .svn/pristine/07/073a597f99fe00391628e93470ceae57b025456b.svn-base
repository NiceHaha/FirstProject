package controller.project;
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
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import entity.project.ProjectEntity;
import service.project.ProjectService;

@Component
public class ViewExcel extends AbstractXlsxView {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	  	String fileName = "ViewExcel.xls";
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("application/ms-excel");  
        response.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));  
        OutputStream outputStream = response.getOutputStream();
        // 产生Excel表头
        Sheet sheet = workbook.createSheet("基本信息");
        Row header = sheet.createRow(0);
        
        Locale locale = (Locale) request.getSession().getAttribute("locale");
        
        // 产生标题列
        header.createCell(0).setCellValue(messageSource.getMessage("project.articleCode",null,locale));
        header.createCell(1).setCellValue(messageSource.getMessage("project.articleTitle",null,locale));
        header.createCell(2).setCellValue(messageSource.getMessage("project.articleText",null,locale));
        header.createCell(3).setCellValue(messageSource.getMessage("project.see",null,locale));
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
	    int rowNumber = 1;
        List<ProjectEntity> list = projectService.excel();
        
    	for (ProjectEntity projectEntity : list) {
    		Row row = sheet.createRow(rowNumber++);
    		row.createCell(0).setCellValue(projectEntity.getId());
            row.createCell(1).setCellValue(projectEntity.getArticle_code());
            row.createCell(2).setCellValue(projectEntity.getArticle_title());
            row.createCell(3).setCellValue(projectEntity.getArticle_text());
    	}
        // 产生标题列
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
}