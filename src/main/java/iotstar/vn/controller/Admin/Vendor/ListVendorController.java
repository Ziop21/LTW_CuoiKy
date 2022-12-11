package iotstar.vn.controller.Admin.Vendor;

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
import iotstar.vn.Service.IVendorRegistrationService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.Service.Impl.VendorRegistrationServiceImpl;
import iotstar.vn.model.StoreModel;
import iotstar.vn.model.UserModel;
import iotstar.vn.model.VendorRegistrationModel;

@WebServlet("/admin2/vendor/list")
public class ListVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new IUserServiceImpl();
	IVendorRegistrationService vendorRegisService = new VendorRegistrationServiceImpl();
	IStoreService storeService = new StoreServiceImpl();   
    public ListVendorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VendorRegistrationModel> vendorRegiss = vendorRegisService.findAll();
		for(VendorRegistrationModel item:vendorRegiss) {
			UserModel user = userService.get(item.getUserId());
			item.setUser(user);
		}
		List<UserModel> users = userService.findAll();
		List<UserModel> vendors = new ArrayList<UserModel>();
		StoreModel store = new StoreModel();
		for(UserModel user:users)
		{
			store = storeService.getByOwnerId(user.get_id());
			user.setStore(store);
			if(user.getRole().compareTo("Vendor")==0)
			{
				vendors.add(user);
			}
		}
		request.setAttribute("vendorCheck", "1");
		request.setAttribute("vendors", vendors);
		request.setAttribute("vendorRegiss", vendorRegiss);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin2/vendor/list-vendor.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
