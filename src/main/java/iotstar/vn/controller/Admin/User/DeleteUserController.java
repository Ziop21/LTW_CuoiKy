package iotstar.vn.controller.Admin.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.IUserServiceImpl;

@WebServlet(urlPatterns = { "/admin2/user/delete" })
public class DeleteUserController extends HttpServlet {
	IUserService userService = new IUserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		userService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin2/user/list");
	}
}
