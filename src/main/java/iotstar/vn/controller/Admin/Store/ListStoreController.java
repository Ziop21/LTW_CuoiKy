package iotstar.vn.controller.Admin.Store;

import java.io.IOException;
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

@WebServlet(urlPatterns = { "/admin2/store/list"})
public class ListStoreController extends HttpServlet{

	IStoreService storeService = new StoreServiceImpl();
	IUserService userService = new IUserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StoreModel> storeList = storeService.findAll();
		for(StoreModel store:storeList) {
			UserModel user = userService.get(store.getOwnerId());
			store.setUser(user);
		}
		req.setAttribute("storeCheck", "1");
		req.setAttribute("storeList", storeList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/store/list-store.jsp");
		dispatcher.forward(req, resp);
	}

}
