package iotstar.vn.controller.Admin.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.model.StoreModel;
import iotstar.vn.model.UserModel;
@WebServlet(urlPatterns = { "/admin2/user/edit"})
public class EditUserController extends HttpServlet{

	IUserService userService = new IUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		UserModel user = userService.get(Integer.parseInt(id));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/user/edit-user.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
