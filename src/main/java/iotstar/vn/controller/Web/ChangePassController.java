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
@WebServlet(urlPatterns = { "/forgetpass/changepass" })
public class ChangePassController extends HttpServlet{
	IUserService userService = new IUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		String emailForget =null;
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ((cookies[i].getName()).compareTo("emailForget") == 0) {
					emailForget = cookies[i].getValue();
				}
			}
		}
		req.setAttribute("emailForget",emailForget);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/changepass.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String email = req.getParameter("email");
		String old_password = req.getParameter("old_password");
		String new_password = req.getParameter("new_password");
		String confirmPassword = req.getParameter("confirmPassword");
		UserModel user = userService.getByEmail(email);
		if(user.getHashed_password().compareTo(old_password)==0 &&user!=null) {
			if(new_password.compareTo(confirmPassword)==0)
			{
				userService.updatePass(email, confirmPassword);
			}
		}
		req.setAttribute("mess", null);
		req.getRequestDispatcher("/login").forward(req, resp);		
	}	
}
