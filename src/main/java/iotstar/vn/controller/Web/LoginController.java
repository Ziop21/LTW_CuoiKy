package iotstar.vn.controller.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICartItemService;
import iotstar.vn.Service.ICartService;
import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.CartItemServiceImpl;
import iotstar.vn.Service.Impl.CartServiceImpl;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.model.CartModel;
import iotstar.vn.model.UserModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	IUserService userService = new IUserServiceImpl();
	ICartItemService cartItemService = new CartItemServiceImpl();
	ICartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		try {
			UserModel user = userService.login(username, pass);
			if (user != null) {
				CartModel cart = new CartModel();
				if(user.getRole().compareTo("User")==0)
				{
					cart = cartService.get(user.get_id());
				}				
				int countCartItem = cartItemService.countAllByCartId(cart.get_id());
				Cookie userNameCookie = new Cookie("username", username);
				Cookie userIdCookie = new Cookie("userId", Integer.toString(user.get_id()));
				Cookie countCartItemCok = new Cookie("countCartItem",Integer.toString(countCartItem));
				// thiết lập thời gian tồn tại 30s của cookie
				userNameCookie.setMaxAge(60 * 60 * 24);
				userIdCookie.setMaxAge(60 * 60 * 24);
				countCartItemCok.setMaxAge(60 * 60 * 24);
				// thêm cookie vào response
				resp.addCookie(userNameCookie);
				resp.addCookie(userIdCookie);
				resp.addCookie(countCartItemCok);
				// chuyển sang trang HelloServlet
				if(user.getRole().contains("User"))
				{
					resp.sendRedirect(req.getContextPath()+ "/cartitem/list");
				}
				else if(user.getRole().contains("Admin"))
				{
					resp.sendRedirect(req.getContextPath()+ "/admin2/dashboard");
				}
				resp.sendRedirect(req.getContextPath()+ "/cartitem/list");
			} else {
				// chuyển sang trang LoginServlet
				req.setAttribute("mess", "Lỗi mật khẩu hoặc email");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
