package controller.user;
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

import entity.user.UserEntity;
import service.user.UserService;

@Component
public class UserExcel extends AbstractXlsxView {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Locale locale = (Locale)request.getSession().getAttribute("locale");
		
	  	String fileName = "userExcel.xls";  
        response.setCharacterEncoding("UTF-8"); 
        response.setContentType("application/ms-excel");  
        response.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));  
        OutputStream outputStream = response.getOutputStream();
        // 产生Excel表头
        Sheet sheet = workbook.createSheet(messageSource.getMessage("EssentialInformation", null, locale));
        Row header = sheet.createRow(0);
        // 产生标题列
        //header.createCell(0).setCellValue(messageSource.getMessage("add.male", null, locale));

        header.createCell(0).setCellValue(messageSource.getMessage("depa.id", null, locale));
        header.createCell(1).setCellValue( messageSource.getMessage("user.name", null, locale));
        header.createCell(2).setCellValue(messageSource.getMessage("csr.empCode", null, locale));
        header.createCell(3).setCellValue(messageSource.getMessage("user.password", null, locale));
        header.createCell(4).setCellValue(messageSource.getMessage("user.account", null, locale));
        header.createCell(5).setCellValue(messageSource.getMessage("user.tel", null, locale));
        header.createCell(6).setCellValue(messageSource.getMessage("user.addr", null, locale));
        header.createCell(7).setCellValue( messageSource.getMessage("user.sex", null, locale));
        header.createCell(8).setCellValue(messageSource.getMessage("user.age", null, locale));
        header.createCell(9).setCellValue(messageSource.getMessage("user.root", null, locale));
        header.createCell(10).setCellValue(messageSource.getMessage("blacklist", null, locale));
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
	    int rowNumber = 1;
        List<UserEntity> list = userService.querys();
        
    	for (UserEntity userEntity : list) {
    		Row row = sheet.createRow(rowNumber++);
    		row.createCell(0).setCellValue(userEntity.getId());
            row.createCell(1).setCellValue(userEntity.getName());
            row.createCell(2).setCellValue(userEntity.getCode());
            row.createCell(3).setCellValue(userEntity.getPassword());
            row.createCell(4).setCellValue(userEntity.getAccount());
            row.createCell(5).setCellValue(userEntity.getTel());
            row.createCell(6).setCellValue(userEntity.getAddr());
            row.createCell(7).setCellValue(userEntity.getSex());
            row.createCell(8).setCellValue(userEntity.getAge());
            row.createCell(9).setCellValue(userEntity.getRoot());
            row.createCell(10).setCellValue(userEntity.getBlack());
    	}
        // 产生标题列
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
}