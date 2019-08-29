package dao.order;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.db.Dao;
import entity.order.OrderEntity;
import entity.order.OrderPage;

@Repository
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private ResourceBundleMessageSource messageSource;
	/**
	 * 模糊查询 分页查询
	 * 
	 * @param lisk
	 * @return
	 */
	public List<OrderEntity> lisk(String lisk, OrderPage page) {
		String a = "";
		if (lisk == null || lisk == "") {
			a = "";
		} else {
			a = "where concat(receiver,receiving_addr,order_code,order_date,shipping_addr,goods_num,goods_price,order_status,receipt_status,receipt_time) like '%"
					+ lisk + "%'";
		}
		String sqlj = "select count(*) from gf_order " + a + "";
		int aa = jdbctemplate.queryForObject(sqlj, Integer.class);
		int ras = aa / page.getPageSize();
		if (aa % page.getPageSize() != 0) {
			ras = ras + 1;
		}
		page.setPogeCount(ras);
		page.setSum(aa);

		String sql = "select * from gf_order " + a + " limit ?,?";
		int start = (page.getPageNo() - 1) * page.getPageSize();
		RowMapper<OrderEntity> rowMapper = new BeanPropertyRowMapper<>(OrderEntity.class);
		List<OrderEntity> list = jdbctemplate.query(sql, rowMapper, start, page.getPageSize());

		return list;
	}

	/**
	 * 前台添加定单
	 * 
	 * @param order
	 */
	public void insert(OrderEntity order) {
		String sql = "insert into gf_order(order_code,order_date,shipping_addr,receiving_addr,receiver,goods_num,goods_price,order_status,receipt_status,receipt_time,payment_status,logistics_code,express_code,payment,goods_name,user_code,deletes,goods_code,order_descride)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1','"
				+ order.getGoodsCode() + "','" + order.getOrderDescride() + "')";
		jdbctemplate.update(sql, order.getOrderCode(), new Date(order.getOrderDate().getTime()),
				order.getShippingAddr(), order.getReceivingAddr(), order.getReceiver(), order.getGoodsNum(),
				order.getGoodsPrice(), order.getOrderStatus(), order.getReceiptStatus(),
				new Date(order.getReceiptTime().getTime()), order.getPaymentStatus(), order.getLogisticsCode(),
				order.getExpressCode(), order.getPayment(), order.getGoodsName(), order.getUserCode());
	}

	/**
	 * 前台查询
	 * 
	 * @param name
	 * @return
	 */
	public List<OrderEntity> selectqt(String name) {
		String sql = "select * from gf_order where user_code=? and deletes= 1 ";
		RowMapper<OrderEntity> rowMapper = new BeanPropertyRowMapper<>(OrderEntity.class);
		List<OrderEntity> list = jdbctemplate.query(sql, rowMapper, name);
		return list;
	}

	/**
	 * 回显
	 * 
	 * @param id
	 * @return
	 */
	public OrderEntity get(Integer id) {
		String sql = "select * from gf_order where id=? ";
		RowMapper<OrderEntity> rowMapper = new BeanPropertyRowMapper<>(OrderEntity.class);
		OrderEntity entity = jdbctemplate.queryForObject(sql, rowMapper, id);
		return entity;
	}

	/**
	 * 修改
	 * 
	 * @param order
	 */
	public void update(OrderEntity order) {
		String sql = "update  gf_order set receiving_addr=?,receiver=? where id=?";
		jdbctemplate.update(sql, order.getReceivingAddr(), order.getReceiver(), order.getId());
	}

	/**
	 * 前台删除 修改状态让前台看不见
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		String sql = "update  gf_order set deletes=?  where id=? ";
		jdbctemplate.update(sql, 2, id);
	}

	/**
	 * 取消订单
	 * 
	 * @param id
	 * @param orderStatus
	 */
	public void OrderStatus(Integer id, String orderStatus) {
		String sql = "update  gf_order set order_status=?  where not receipt_status=1 and id=? ";
		jdbctemplate.update(sql, orderStatus, id);
	}

	/**
	 * 确认收货
	 * 
	 * @param id
	 */
	public void receiptStatus(Integer id) {
		String sql = "update  gf_order set receipt_status= 1  where not order_status=1 and id=? ";
		jdbctemplate.update(sql, id);
	}

	/**
	 * 往exc表中插值
	 */
	public void xz(HttpServletRequest reequert) {
		// 第一步，创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二部，在workbook中创建一个sheet对应excel中的sheet
		HSSFSheet sheet = workbook.createSheet("订单表");
		// 第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		HSSFRow row = sheet.createRow(0);
		Locale locale = (Locale) reequert.getSession().getAttribute("locale");
			String a=messageSource.getMessage("order.userCode", null, locale);
			String orderDate=messageSource.getMessage("order.orderDate", null, locale);
			String shippingAddr=messageSource.getMessage("order.shippingAddr", null, locale);
			String receivingAddr=messageSource.getMessage("order.receivingAddr", null, locale);
			String receiver=messageSource.getMessage("order.receiver", null, locale);
			String goodsName=messageSource.getMessage("order.goodsName", null, locale);
			String goodsNum=messageSource.getMessage("order.goodsNum", null, locale);
			String goodsPrice=messageSource.getMessage("order.goodsPrice", null, locale);
			String receiptStatus=messageSource.getMessage("order.receiptStatus", null, locale);
			String orderStatus=messageSource.getMessage("order.orderStatus", null, locale);
			String paymentStatus=messageSource.getMessage("order.paymentStatus", null, locale);
			String logisticsCode=messageSource.getMessage("order.logisticsCode", null, locale);
			String expressCode=messageSource.getMessage("order.expressCode", null, locale);
			String receiptTime=messageSource.getMessage("order.receiptTime", null, locale);
			String payment=messageSource.getMessage("order.payment", null, locale);
			String orderCode=messageSource.getMessage("order.orderCode", null, locale);
		// 第四步，创建单元格，设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(a);
		cell = row.createCell(1);
		cell.setCellValue(orderDate);
		cell = row.createCell(2);
		cell.setCellValue(shippingAddr);
		cell = row.createCell(3);
		cell.setCellValue(shippingAddr);
		cell = row.createCell(4);
		cell.setCellValue(receiver);
		cell = row.createCell(5);
		cell.setCellValue(goodsName);
		cell = row.createCell(6);
		cell.setCellValue(goodsNum);
		cell = row.createCell(7);
		cell.setCellValue(goodsPrice);
		cell = row.createCell(8);
		cell.setCellValue(receiptStatus);
		cell = row.createCell(9);
		cell.setCellValue(orderStatus);
		cell = row.createCell(10);
		cell.setCellValue(paymentStatus);
		cell = row.createCell(11);
		cell.setCellValue(logisticsCode);
		cell = row.createCell(12);
		cell.setCellValue(expressCode);
		cell = row.createCell(13);
		cell.setCellValue(receiptTime);
		cell = row.createCell(14);
		cell.setCellValue(payment);
		cell = row.createCell(15);
		cell.setCellValue(orderCode);

		// 第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
		String sql = "select * from gf_order ";
		RowMapper<OrderEntity> rowMapper = new BeanPropertyRowMapper<>(OrderEntity.class);
		List<OrderEntity> list = jdbctemplate.query(sql, rowMapper);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			OrderEntity order = list.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(order.getGoodsName());
			row1.createCell(1).setCellValue(order.getOrderDate());
			row1.createCell(2).setCellValue(order.getShippingAddr());
			row1.createCell(3).setCellValue(order.getReceivingAddr());
			row1.createCell(4).setCellValue(order.getReceiver());
			row1.createCell(5).setCellValue(order.getGoodsName());
			row1.createCell(6).setCellValue(order.getGoodsNum());
			row1.createCell(7).setCellValue(order.getGoodsPrice());
			row1.createCell(8).setCellValue(order.getReceiptStatus());
			row1.createCell(9).setCellValue(order.getOrderStatus());
			row1.createCell(10).setCellValue(order.getPaymentStatus());
			row1.createCell(11).setCellValue(order.getLogisticsCode());
			row1.createCell(12).setCellValue(order.getExpressCode());
			row1.createCell(13).setCellValue(order.getReceiptTime());
			row1.createCell(14).setCellValue(order.getPayment());
			row1.createCell(15).setCellValue(order.getOrderCode());
		}

		// 将文件保存到指定的位置
		try {
			FileOutputStream fos = new FileOutputStream("d:\\Users\\king\\Desktop\\src.xls");
			workbook.write(fos);
			System.out.println("写入成功");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载exc表
	 * 
	 * @param reequert
	 * @param response
	 */
	public void sar(HttpServletRequest reequert, HttpServletResponse response) {
		String name = "a.xls";
		String filepath = "d:\\Users\\king\\Desktop\\src.xls";
		response.setContentType("text/html;charset=utf-8");
		try {
			FileInputStream inputstream = new FileInputStream(filepath);
			response.setHeader("Content-disposition", "attachment; filename=" + name);// 设置文件名
			response.setHeader("Content-Length", String.valueOf(new File(filepath).length()));// 设置文件名
			BufferedOutputStream dataOutput = new BufferedOutputStream(response.getOutputStream());
			byte[] b = new byte[1024 * 1024 * 1];
			int len = 0;
			while ((len = inputstream.read(b)) != -1) {
				dataOutput.write(b, 0, len);
				dataOutput.flush();
			}
			dataOutput.close();
			inputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
