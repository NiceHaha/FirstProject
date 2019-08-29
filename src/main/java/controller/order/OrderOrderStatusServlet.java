package controller.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import service.order.OrderService;
import servlet.Public.Servlet;

@WebServlet("/orderOrderStatusServlet")
public class OrderOrderStatusServlet extends Servlet {
	@Autowired
	private OrderService orderservice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String orderStatus = "1";
		PrintWriter out = resp.getWriter();
		orderservice.OrderStatus(Integer.valueOf(id), orderStatus);
		out.println(1);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
