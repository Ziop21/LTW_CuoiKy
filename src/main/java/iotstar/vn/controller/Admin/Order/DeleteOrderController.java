package iotstar.vn.controller.Admin.Order;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IOrderService;
import iotstar.vn.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/admin2/order/delete"})
public class DeleteOrderController extends HttpServlet{
	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("orderId");
		orderService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+ "/admin2/order/list");
	}
}
