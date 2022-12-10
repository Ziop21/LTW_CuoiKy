package iotstar.vn.controller.Admin.Cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICartService;
import iotstar.vn.Service.Impl.CartServiceImpl;
import iotstar.vn.model.CartModel;
@WebServlet(urlPatterns = { "/admin2/cart/list"})
public class ListCartController extends HttpServlet {
	
	ICartService cartService = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartModel> cartList = cartService.findAll();
		req.setAttribute("cartList", cartList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/list-cart.jsp");
		dispatcher.forward(req, resp);
	}

}
