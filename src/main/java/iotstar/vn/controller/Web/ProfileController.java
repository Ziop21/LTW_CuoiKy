package iotstar.vn.controller.Web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IOrderService;
import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.IUserService;
import iotstar.vn.Service.IVendorRegistrationService;
import iotstar.vn.Service.Impl.IUserServiceImpl;
import iotstar.vn.Service.Impl.OrderServiceImpl;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.Service.Impl.VendorRegistrationServiceImpl;
import iotstar.vn.model.OrderModel;
import iotstar.vn.model.UserModel;
import iotstar.vn.model.VendorRegistrationModel;

@WebServlet(urlPatterns = { "/myprofile/info", "/myprofile/listorder", "/myprofile/edit","/myprofile/status-regisvendor","/myprofile/regisvendor","/myprofile/delete-regisvendor" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new IUserServiceImpl();
	IOrderService orderService = new OrderServiceImpl();
	IVendorRegistrationService vendorRegisService = new VendorRegistrationServiceImpl();
	IStoreService storeService = new StoreServiceImpl();   
    public ProfileController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("myprofile/info")) {
			Info(request, response);
		}
		if (url.contains("myprofile/listorder")) {
			ListOrder(request, response);
		}
		if (url.contains("myprofile/edit")) {
			EditInfo(request, response);
		}
		if (url.contains("myprofile/regisvendor")) {
			RegisVendor(request, response);
		}
		if (url.contains("myprofile/delete-regisvendor")) {
			DeleteRegisVendor(request, response);
		}
		if (url.contains("myprofile/status-regisvendor")) {
			StatusRegisVendor(request, response);
		}
	}
	protected void ListOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		List<OrderModel> orderList = orderService.findAllByUserId(Integer.parseInt(id));
		UserModel user = userService.get(Integer.parseInt(id));
		req.setAttribute("user", user);
		req.setAttribute("orderCheck", "1");
		req.setAttribute("orderList", orderList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/profile/list-order.jsp");
		dispatcher.forward(req, resp);
	}
	protected void DeleteRegisVendor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("Id");
		String userId = req.getParameter("userId");
		vendorRegisService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/myprofile/status-regisvendor?userId="+userId);
	}
	protected void StatusRegisVendor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		UserModel user = userService.get(Integer.parseInt(userId));
		List<VendorRegistrationModel> vendorRegisList = vendorRegisService.findAllByUserId(user.get_id());
		for(VendorRegistrationModel o:vendorRegisList)
		{
			o.setUser(user);
		}
		req.setAttribute("user", user);
		req.setAttribute("vendorRegisList", vendorRegisList);
		req.getRequestDispatcher("/views/profile/regisstatus.jsp").forward(req, resp);
	}
	protected void RegisVendor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		UserModel user = userService.get(Integer.parseInt(id));
		VendorRegistrationModel vendorRegis = new VendorRegistrationModel();
		List<VendorRegistrationModel> vendorRegisList = new ArrayList<VendorRegistrationModel>();
		try {
			vendorRegisList = vendorRegisService.findAllByUserId(user.get_id());
			if(vendorRegisList.isEmpty())
			{
				vendorRegis.setUserId(Integer.parseInt(id));
				vendorRegis.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				vendorRegisService.insert(vendorRegis);
				req.setAttribute("user", user);
				req.setAttribute("vendorRegisList", vendorRegisList);
				req.getRequestDispatcher("/myprofile/status-regisvendor?userId="+id).forward(req, resp);
			}
			req.getRequestDispatcher("/myprofile/status-regisvendor?userId="+id).forward(req, resp);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void Info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = null;
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		String id = request.getParameter("userId");
		String email = null;
		UserModel user = new UserModel();
		if(id==null)
		{
			email = request.getParameter("email");
			if(email!=null)
			{
				user = userService.getByEmail(email);
			}
			else
			{
				response.setContentType("text/html");
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if ((cookies[i].getName()).compareTo("username") == 0) {
							userName = cookies[i].getValue();
						}
					}
				}
				user = userService.getByEmail(userName);
			}
		}
		else {
			user = userService.get(Integer.parseInt(id));
		}
		request.setAttribute("user", user);
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/profile/info.jsp");
		dispatcher.forward(request, response);
	}
	protected void EditInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		UserModel user = userService.get(Integer.parseInt(id));
		request.setAttribute("user", user);
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/profile/editprofile.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}
