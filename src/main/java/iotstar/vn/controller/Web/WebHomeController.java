package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IProductService;
import iotstar.vn.Service.Impl.IProductServiceImpl;
import iotstar.vn.model.ProductModel;



@WebServlet(urlPatterns = {"/home"})
public class WebHomeController extends HttpServlet{
	
	IProductService prodService = new IProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = prodService.findLastProductList();
		req.setAttribute("lastProducts", productList);
		
		List<ProductModel> topProducts = prodService.findTopProductList();
		req.setAttribute("topProducts", topProducts);
		
		ProductModel topproduct = prodService.findTopProduct();
		req.setAttribute("topProduct", topproduct);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/webhome.jsp");
		rd.forward(req, resp);
		
	}
}

