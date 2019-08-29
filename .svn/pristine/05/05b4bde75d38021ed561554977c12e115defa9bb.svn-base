package controller.agent;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import entity.agent.Agent;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.Agent.AgentService;

@Component
public class AgentExcel extends AbstractXlsxView {
	
	@Autowired
	private AgentService agentService;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Locale locale = (Locale)request.getSession().getAttribute("locale");
	  	String fileName = "agentExcel.xls";  
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("application/ms-excel");  
        response.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));  
        OutputStream outputStream = response.getOutputStream();
        // 产生Excel表头
        Sheet sheet = workbook.createSheet(messageSource.getMessage("EssentialInformation", null, locale));
        Row header = sheet.createRow(0);
        // 产生标题列
        header.createCell(0).setCellValue(messageSource.getMessage("agent.id", null, locale));
        header.createCell(1).setCellValue(messageSource.getMessage("agent.name", null, locale));
        header.createCell(2).setCellValue(messageSource.getMessage("agent.city", null, locale));
        header.createCell(3).setCellValue(messageSource.getMessage("agent.tel", null, locale));
        header.createCell(4).setCellValue(messageSource.getMessage("brand.name", null, locale));
//        CellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
	    int rowNumber = 1;
        List<Agent> list = agentService.select("",new PageEntity());
        
    	for (Agent agent : list) {
    		Row row = sheet.createRow(rowNumber++);
    		row.createCell(0).setCellValue(agent.getId());
    		row.createCell(1).setCellValue(agent.getAgent_name());
    		row.createCell(2).setCellValue(agent.getAgent_city());
    		row.createCell(3).setCellValue(agent.getAgent_tel());
    		row.createCell(4).setCellValue(agent.getBrand_name());
    	}
        // 产生标题列
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
}