package iotstar.vn.controller.Web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICartItemService;
import iotstar.vn.Service.IOrderService;
import iotstar.vn.Service.Impl.CartItemServiceImpl;
import iotstar.vn.Service.Impl.OrderServiceImpl;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.OrderItemModel;
import iotstar.vn.model.OrderModel;
import iotstar.vn.model.ProductModel;
@WebServlet(urlPatterns = { "/order/checkout"})
public class OrderController extends HttpServlet{
	IOrderService orderService = new OrderServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cartId = 1;
		float thanhtien = 0;
		List<CartItemModel> cartItemList = cartItemService.findAllByCartId(cartId);
		List<ProductModel> products = new ArrayList<ProductModel>();
		for (CartItemModel item : cartItemList) {
			ProductModel product = cartItemService.get(item.getProductId());
			products.add(product);
			thanhtien+=product.getPrice()*item.getCount();
		}
		req.setAttribute("cartItemList", cartItemList);
		req.setAttribute("products", products);
		req.setAttribute("thanhtien", thanhtien);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/checkout.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String traTienMat = req.getParameter("traTienMat");
		int cartId = 1;
		int userId = 1;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		OrderModel order = new OrderModel();
		List<CartItemModel> cartItemList = cartItemService.findAllByCartId(cartId);
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			if(cartItemList!= null)
			{
				float thanhtien =0;
				for(CartItemModel item: cartItemList) {
					ProductModel product = cartItemService.get(item.getProductId());
					thanhtien+=item.getCount()*product.getPrice();
				}
				order.setUserId(userId);
				order.setCartId(cartId);
				order.setAddress(address);
				order.setPhone(phone);	     
				order.setCreatedAt(currentTime);
				order.setPaidBefore(Boolean.parseBoolean(traTienMat));
				order.setAmountFromUser(thanhtien);
				orderService.insert(order);
				OrderModel orderNew = orderService.getOrderNew();
				for(CartItemModel item: cartItemList) {
					OrderItemModel orderItem = new OrderItemModel();
					ProductModel product = cartItemService.get(item.getProductId());
					orderItem.setOrderId(orderNew.get_id());
					orderItem.setProductId(item.getProductId());
					orderItem.setCount(item.getCount());
					orderItem.setCreatedAt(currentTime);
					orderService.taoOrderItem(orderItem);
					orderService.updateSoldProduct(product.getQuantity()-item.getCount(), item.getCount(), product.get_id());
					cartItemService.delete(item.get_id());					
				}
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+ "/cartitem/list");
	}
	
}
