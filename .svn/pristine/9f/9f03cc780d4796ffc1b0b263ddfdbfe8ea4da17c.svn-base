package controller.material;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import entity.material.MaterialEntity;
import service.material.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

@Component 
public class ExcelView extends AbstractXlsView {//基于POI API
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<MaterialEntity> materialList = materialService.queryMaterial();
		
		 String fileName = "素材Excel表.xls";  
	        response.setCharacterEncoding("UTF-8");  
	        response.setContentType("application/ms-excel");  
	        response.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"UTF-8"));  
	        OutputStream outputStream = response.getOutputStream();
	        
	        // 产生Excel表头
	        Locale locale = (Locale) request.getSession().getAttribute("locale");
	        
	        String sheetName = messageSource.getMessage("excel.sheetName", null, locale);
	        String materialCode = messageSource.getMessage("material.materialCode", null, locale);
	        String picture = messageSource.getMessage("material.materialUrl", null, locale);
	        String materialName = messageSource.getMessage("material.materialName", null, locale);
	        
	        Sheet sheet = workbook.createSheet(sheetName);
	        Row header = sheet.createRow(0);
	        // 产生标题列
	        header.createCell(0).setCellValue(materialCode);
	        header.createCell(1).setCellValue(picture);
	        header.createCell(2).setCellValue(materialName);
	        
	        //List<MaterialEntity> materialList = (List<MaterialEntity>) model.get("materialList");
	        
	        int rowNumber = 1;
	        for (MaterialEntity material : materialList) {
				Row row = sheet.createRow(rowNumber++);
				//产生标题列
				row.createCell(0).setCellValue(material.getMaterialCode());
	            row.createCell(1).setCellValue(material.getMaterialUrl());
	            row.createCell(2).setCellValue(material.getMaterialName());
			}
            
	        workbook.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
	}
}



















