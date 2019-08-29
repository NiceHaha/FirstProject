package controller.goods;

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

import entity.goodsreciew.GoodsReciewEntity;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.goodsreciew.GoodsreciewService;
import service.user.UserService;


@Component
public class GetExecel extends AbstractXlsxView{
	@Autowired
	private GoodsreciewService goodsreciewService;
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook work, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
			String fileName = "GoodsExcel.xls";  
			resp.setCharacterEncoding("UTF-8"); 	
			resp.setContentType("application/ms-excel");  
			resp.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));  
	        OutputStream outputStream = resp.getOutputStream();
	     // 产生Excel表头
	        Locale locale= (Locale) req.getSession().getAttribute("locale");
	        Sheet sheet = work.createSheet(messageSource.getMessage("EssentialInformation", null, locale));
	        Row header = sheet.createRow(0);
	        // 产生标题列
	        header.createCell(0).setCellValue(messageSource.getMessage("Code", null, locale));
	        header.createCell(1).setCellValue(messageSource.getMessage("NameOfCommodity", null, locale));
	        header.createCell(2).setCellValue(messageSource.getMessage("commodityPrice", null, locale));
	        header.createCell(3).setCellValue(messageSource.getMessage("CommodityDescription", null, locale));
	        header.createCell(4).setCellValue(messageSource.getMessage("CommodityColour", null, locale));
	        CellStyle cellStyle = work.createCellStyle();
	        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
		    int rowNumber = 1;
	        List<GoodsReciewEntity> list= goodsreciewService.query();
	        
	    	for (GoodsReciewEntity goodsReciewEntity : list) {
	    		Row row = sheet.createRow(rowNumber++);
	    		row.createCell(0).setCellValue(goodsReciewEntity.getGoodsCode());
	            row.createCell(1).setCellValue(goodsReciewEntity.getGoodsName());
	            row.createCell(2).setCellValue(goodsReciewEntity.getGoodsPrice());
	            row.createCell(3).setCellValue(goodsReciewEntity.getGoodsDescribe());
	            row.createCell(4).setCellValue(goodsReciewEntity.getGoodsColor());
			}
	        // 产生标题列
	        work.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
	        
	}
	
}
