package controller.order;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.order.OrderEntity;
import entity.order.OrderPage;
import entity.order.OrderPageEntity;
import service.order.OrderService;

@SessionAttributes(value = "locale")
@Controller
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	public int inquetorder(@PathVariable Integer id) {
		orderservice.delete(id);
		Integer sc = 1;
		return sc;
	}

	/**
	 * 回显
	 * 
	 * @param id
	 * @param map
	 * @return8
	 */
	@RequestMapping(value = "/order/{id}")
	public String updateorder(@PathVariable Integer id, Map<String, Object> map) {
		OrderEntity list = orderservice.get(id);
		map.put("list", list);
		return "foreground/jsp/order/update";
	}

	@ModelAttribute
	public void ManagedAttribute(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("order", orderservice.get(id));
		}
	}

	/**
	 * 修改
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.PUT)
	public String update(@ModelAttribute("order") OrderEntity order) {
		orderservice.update(order);
		return "redirect:/order/as";
	}

	/**
	 * 修改前中转
	 * 
	 * @return
	 */
	@RequestMapping("/order/inset")
	public String bb() {
		return "foreground/jsp/order/insert";
	}

	/**
	 * 查询中转
	 * 
	 * @return
	 */
	@RequestMapping("/order/as")
	public String aa(Map<String, Object> map, Locale locale) {
		map.put("locale", locale.toString());
		return "foreground/order";
	}

	

	/**
	 * 前台查询
	 * 
	 * @param lisk
	 * @param pageNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/qtorder", method = RequestMethod.GET)
	public List<OrderEntity> qtlistorder() {
		String bb = "20";
		List<OrderEntity> list = orderservice.selectqt(bb);
		return list;
	}

	/**
	 * 添加
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String inputorder(@Valid OrderEntity order, Errors errors, Map<String, Object> map) {
		if (errors.getErrorCount() > 0) {
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fieldError : list) {
				System.out.println(fieldError.getField());
				System.out.println(fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			map.put("order", order);
			return "foreground/jsp/order/insert";
		}
		int max = 10000000, min = 1;
		int ran = (int) (Math.random() * (max - min) + min);
		int max1 = 100000000, min1 = 1;
		int ran1 = (int) (Math.random() * (max1 - min1) + min1);
		int max2 = 10, min2 = 1;
		int ran2 = (int) (Math.random() * (max2 - min2) + min2);
		order.setOrderCode(String.valueOf(ran));
		order.setOrderDate(new Date());
		order.setShippingAddr("深圳");
		order.setReceivingAddr(order.getReceivingAddr());
		order.setOrderStatus(2);
		order.setReceiptStatus(2);
		order.setReceiptTime(new Date());
		order.setPaymentStatus(2);
		order.setLogisticsCode((ran1));
		order.setExpressCode(1);
		order.setPayment(1);
		order.setUserCode("20");
		order.setGoodsCode(String.valueOf(ran2));
		order.setDeletes(1);
		orderservice.insert(order);
		return "redirect:/order/as";
	}

	/**
	 * 后台查询中转
	 * 
	 * @return
	 */
	@RequestMapping("/orders")
	public String cc() {
		return "admin/jsp/order/order";
	}
	
	/**
	 * 后台查询
	 * 
	 * @param lisk
	 * @param pageNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public OrderPageEntity<OrderEntity> listorder(String lisk, Integer pageNo) {
		OrderPage page = new OrderPage();
		page.setPageNo(Integer.valueOf(pageNo));
		List<OrderEntity> list = orderservice.lisk(lisk, page);
		OrderPageEntity<OrderEntity> pages = new OrderPageEntity<>();
		pages.setList(list);
		pages.setPage(page);
		return pages;
	}
	/**
	 * 文件下载 这里面包含了数据库查出值放入excel表，并下载excel表
	 * @param reequert
	 * @param response
	 * @return
	 */
	@RequestMapping("uiop")
	public String zx(HttpServletRequest requert,HttpServletResponse response) {
		orderservice.zx(requert);
		orderservice.ras(requert, response);
		return "redirect:/orders";
	}
	
	
}
