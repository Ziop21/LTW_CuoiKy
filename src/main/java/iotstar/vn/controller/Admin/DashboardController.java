package iotstar.vn.controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import iotstar.vn.Service.IOrderService;
import iotstar.vn.Service.Impl.OrderServiceImpl;

/**
 * Servlet implementation class admin2
 */
@WebServlet("/admin2/dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderService orderService = new OrderServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = null;
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ((cookies[i].getName()).compareTo("username") == 0) {
					userName = cookies[i].getValue();
				}
			}
		}
		int TongSLBan = 0;
		int TongDoanhThuBan = 0;
		for (int i = 1; i <= 12; i++) {
			TongDoanhThuBan += orderService.TinhDoanhThuTheoThang(i);
			TongSLBan += orderService.SoLuongBanTheoThang(i);
			request.setAttribute("SL"+Integer.toString(i), orderService.SoLuongBanTheoThang(i));
			request.setAttribute("DT"+Integer.toString(i), orderService.TinhDoanhThuTheoThang(i));
        }
		request.setAttribute("orderList", orderService.findAll());
		request.setAttribute("TongDoanhThuBan", TongDoanhThuBan);
		request.setAttribute("TongSLBan", TongSLBan);
		request.setAttribute("email", userName);
		response.setContentType("text/html");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin2/dashboard.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
