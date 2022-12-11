package iotstar.vn.controller.Admin.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet(urlPatterns = { "/admin2/user/list"})
public class ListUserController extends HttpServlet{
	IUserService userService = new IUserServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserModel> userList = userService.findAll();
		List<UserModel> users = new ArrayList<UserModel>();
		StoreModel store = new StoreModel();
		for(UserModel user:userList) {
			store = storeService.getByOwnerId(user.get_id());
			user.setStore(store);
			if(user.getRole().contains("User")) {
				users.add(user);
			}
		}
		req.setAttribute("userCheck", "1");
		req.setAttribute("userList", users);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/user/list-user.jsp");
		dispatcher.forward(req, resp);
	}
}
