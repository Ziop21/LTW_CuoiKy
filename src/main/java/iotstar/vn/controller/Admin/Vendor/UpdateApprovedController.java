package iotstar.vn.controller.Admin.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.IVendorRegistrationService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.Service.Impl.VendorRegistrationServiceImpl;
@WebServlet("/admin2/vendor/approved")
public class UpdateApprovedController extends HttpServlet{

	IUserService userService = new IUserServiceImpl();
	IVendorRegistrationService vendorRegisService = new VendorRegistrationServiceImpl();
	IStoreService storeService = new StoreServiceImpl();   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		String id = req.getParameter("Id");
		vendorRegisService.delete(Integer.parseInt(id));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin2/vendor/list");
		dispatcher.forward(req, resp);
	}
}
