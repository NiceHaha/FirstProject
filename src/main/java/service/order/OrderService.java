package service.order;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.order.OrderDao;
import entity.order.OrderEntity;
import entity.order.OrderPage;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderdao;

	/*
	 * 前台查询
	 */
	public List<OrderEntity> selectqt(String name) {
		List<OrderEntity> list = orderdao.selectqt(name);
		return list;
	}

	/*
	 * 修改
	 */
	public void update(OrderEntity order) {
		orderdao.update(order);
	}

	/*
	 * 删除
	 */
	public void delete(Integer id) {
		orderdao.delete(id);
	}

	/*
	 * 回显
	 */
	public OrderEntity get(Integer id) {
		OrderEntity order = orderdao.get(id);
		return order;
	}

	/**
	 * 取消订单
	 * 
	 * @param id
	 * @param orderStatus
	 */
	public void OrderStatus(Integer id, String orderStatus) {
		orderdao.OrderStatus(id, orderStatus);
	}

	/**
	 * 确认收货
	 * 
	 * @param id
	 */
	public void orderReceiptStatus(Integer id) {
		orderdao.receiptStatus(id);
	}

	/**
	 * 前台添加
	 * 
	 * @param order
	 */
	public void insert(OrderEntity order) {
		orderdao.insert(order);
	}

	/**
	 * 后台 模糊查询 分页查询
	 */
	public List<OrderEntity> lisk(String lisk, OrderPage page) {
		return orderdao.lisk(lisk, page);
	}

	/**
	 * 数据库查出值放入Excel表
	 */
	public void zx(HttpServletRequest requert) {
		orderdao.xz(requert);
	}

	public void ras(HttpServletRequest reequert, HttpServletResponse response) {
		orderdao.sar(reequert, response);
	}

}
