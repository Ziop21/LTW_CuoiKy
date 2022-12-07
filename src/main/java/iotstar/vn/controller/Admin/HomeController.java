package iotstar.vn.controller.Admin;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IProductWebService;
import iotstar.vn.Service.Impl.IProductWebServiceImpl;
import iotstar.vn.model.ProductModel;

@WebServlet(urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet{
	IProductWebService prodService = new IProductWebServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = prodService.findLastProductList();
		req.setAttribute("lastProducts", productList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(req, resp);
	}
}

