package iotstar.vn.controller.Admin.Store;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.Impl.StoreServiceImpl;

@WebServlet(urlPatterns = { "/admin2/store/delete" })
public class DeleteStoreController extends HttpServlet {

	IStoreService storeService = new StoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeId");
		storeService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin2/store/list");
	}
}
