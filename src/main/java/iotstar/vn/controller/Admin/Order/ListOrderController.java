package iotstar.vn.controller.Admin.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IOrderService;
import iotstar.vn.Service.Impl.OrderServiceImpl;
import iotstar.vn.model.OrderModel;
@WebServlet(urlPatterns = { "/admin2/order/list"})
public class ListOrderController extends HttpServlet{
	
	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderModel> orderList = orderService.findAll();
		req.setAttribute("orderCheck", "1");
		req.setAttribute("orderList", orderList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/order/list-order.jsp");
		dispatcher.forward(req, resp);
	}

}
