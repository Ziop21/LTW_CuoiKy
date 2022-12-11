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

/**
 * Servlet implementation class DeleteVendorRegisController
 */
@WebServlet("/admin2/vendor/delete")
public class DeleteVendorRegisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new IUserServiceImpl();
	IVendorRegistrationService vendorRegisService = new VendorRegistrationServiceImpl();
	IStoreService storeService = new StoreServiceImpl();   
    public DeleteVendorRegisController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("Id");
		vendorRegisService.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath() + "/admin2/vendor/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
