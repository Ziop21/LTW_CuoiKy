package iotstar.vn.controller.Admin.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.model.UserModel;
@WebServlet(urlPatterns = { "/admin2/user/list"})
public class ListUserController extends HttpServlet{
	IUserService userService = new IUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> userList = userService.findAll();
		req.setAttribute("userCheck", "1");
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/user/list-user.jsp");
		dispatcher.forward(req, resp);
	}
}
