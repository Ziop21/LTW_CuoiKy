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
@WebServlet(urlPatterns = { "/admin2/order/detail"})
public class DetailOrderController extends HttpServlet{

	IOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("orderId");
		OrderModel order = orderService.getById(Integer.parseInt(id));
		req.setAttribute("order", order);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/order/detail-order.jsp");
		dispatcher.forward(req, resp);
	}
}
