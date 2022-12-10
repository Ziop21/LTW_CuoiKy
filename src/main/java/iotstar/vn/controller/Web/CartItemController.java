package iotstar.vn.controller.Web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICartItemService;
import iotstar.vn.Service.ICartService;
import iotstar.vn.Service.Impl.CartItemServiceImpl;
import iotstar.vn.Service.Impl.CartServiceImpl;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.CartModel;
import iotstar.vn.model.ProductModel;

@WebServlet(urlPatterns = { "/cartitem/list", "/cartitem/delete", "/cartitem/add" })
public class CartItemController extends HttpServlet {
	ICartItemService cartItemService = new CartItemServiceImpl();
	ICartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("cartitem/list")) {
			listCartItem(req, resp);
		}
		if (url.contains("cartitem/delete")) {
			deleteCartItem(req, resp);
		}
		if (url.contains("cartitem/add")) {
			addCartItem(req, resp);
		}
	}

	protected void listCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = 0;
		String userName = null;
		String countCartItem =null;
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ((cookies[i].getName()).compareTo("username") == 0) {
					userName = cookies[i].getValue();
				}
				if ((cookies[i].getName()).compareTo("userId") == 0) {
					userId = Integer.parseInt(cookies[i].getValue());
				}
				if ((cookies[i].getName()).compareTo("countCartItem") == 0) {
					countCartItem = cookies[i].getValue();
				}
			}
		}
		if (userName == null && userId == 0) {
			req.getRequestDispatcher("/login").forward(req, resp);
		}
		CartModel cart = cartService.get(userId);
		if (cart == null) {
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			CartModel newcart = new CartModel();
			newcart.setUserId(userId);
			newcart.setCreatedAt(currentTime);
			cartService.insert(newcart);
			cart = cartService.get(userId);
		}
		List<CartItemModel> cartItemList = cartItemService.findAllByCartId(cart.get_id());
		List<ProductModel> products = new ArrayList<ProductModel>();
		List<ProductModel> allproducts = cartItemService.findAllProduct();
		for (CartItemModel item : cartItemList) {
			ProductModel product = cartItemService.get(item.getProductId());
			products.add(product);
		}
		req.setAttribute("cartItemList", cartItemList);
		req.setAttribute("products", products);
		req.setAttribute("allproducts", allproducts);
		req.setAttribute("username", userName);
		req.setAttribute("countCartItem", countCartItem);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/list-cartItem.jsp");
		dispatcher.forward(req, resp);
	}

	protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		cartItemService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/cartitem/list");
	}

	protected void addCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = 0;
		String quantity = null;//req.getParameter("quantity");
		String userName = null;
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ((cookies[i].getName()).compareTo("username") == 0) {
					userName = cookies[i].getValue();
				}
				if ((cookies[i].getName()).compareTo("userId") == 0) {
					userId = Integer.parseInt(cookies[i].getValue());
				}
			}
		}
		CartModel cart = cartService.get(userId);
		if (cart == null) {
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			CartModel newcart = new CartModel();
			newcart.setUserId(userId);
			newcart.setCreatedAt(currentTime);
			cartService.insert(newcart);
			cart = cartService.get(userId);
		}
		int productId = Integer.parseInt(req.getParameter("productId"));
		CartItemModel cartItem = new CartItemModel();
		ProductModel product = cartItemService.get(productId);
		//if(product.getQuantity()>Integer.parseInt(quantity)) {}
		List<CartItemModel> cartItemList = cartItemService.findAllByCartId(cart.get_id());
		boolean inCart = false;
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		for (CartItemModel item : cartItemList) {
			if (item.getProductId() == product.get_id()) {
				item.setCount(item.getCount() + 1);
				cartItemService.editCount(item);
				inCart = true;
			}
		}
		if (inCart == false) {
			cartItem.setCount(1);
			cartItem.setProductId(productId);
			cartItem.setCartId(cart.get_id());
			cartItem.set_id(cartItemService.countAll() + 1);
			cartItem.setCreatedAt(currentTime);
			cartItemService.insert(cartItem);
		}

		resp.sendRedirect(req.getContextPath() + "/cartitem/list");
	}

}
