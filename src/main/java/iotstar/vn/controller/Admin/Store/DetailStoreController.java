package iotstar.vn.controller.Admin.Store;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.model.StoreModel;
@WebServlet(urlPatterns = { "/admin2/store/detail"})
public class DetailStoreController extends HttpServlet {

	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeId");
		StoreModel store = storeService.getById(Integer.parseInt(id));
		req.setAttribute("store", store);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin2/store/detail-store.jsp");
		dispatcher.forward(req, resp);
	}
}
