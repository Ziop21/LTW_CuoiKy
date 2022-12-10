package iotstar.vn.controller.Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.model.UserModel;
@WebServlet(urlPatterns = { "/register"})
public class RegisterController extends HttpServlet{
	IUserService userService = new IUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String pass = req.getParameter("password");
		String confirmPass = req.getParameter("confirmPassword");
		String email = req.getParameter("email");
		
		try {
			UserModel checkEmailExist = userService.getByEmail(email);
			if(pass.compareTo(confirmPass)==0 && checkEmailExist==null)
			{
				UserModel userNew = new UserModel();
				userNew.setFirstname(firstname);
				userNew.setLastname(lastname);
				userNew.setEmail(email);
				userNew.setRole("User");
				userNew.setHashed_password(pass);
				userService.insert(userNew);
			}
			UserModel user =userService.login(email, pass);
			if(user!=null)
			{
				Cookie userNameCookieRegister = new Cookie("usernameRegister", email);
				Cookie userIdCookieRegister = new Cookie("userIdRegister",Integer.toString(user.get_id()));
				// thiết lập thời gian tồn tại 30s của cookie
				userNameCookieRegister.setMaxAge(60 * 60);
				userIdCookieRegister.setMaxAge(60 * 60);
				// thêm cookie vào response
				resp.addCookie(userNameCookieRegister);
				resp.addCookie(userIdCookieRegister);
				// chuyển sang trang HelloServlet
				resp.sendRedirect(req.getContextPath()+ "/login");
			}
			else {
				// chuyển sang trang LoginServlet
				resp.sendRedirect(req.getContextPath()+ "/register");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
