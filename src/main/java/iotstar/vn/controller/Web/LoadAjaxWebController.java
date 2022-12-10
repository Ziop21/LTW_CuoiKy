package iotstar.vn.controller.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.IProductService;
import iotstar.vn.Service.Impl.IProductServiceImpl;
import iotstar.vn.model.ProductModel;

@WebServlet("/LoadAjaxWebController")
public class LoadAjaxWebController extends HttpServlet {
	IProductService prodService = new IProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");	
		// tam thoi load ra 3 san pham truoc
		String amount = request.getParameter("exits");
		int iamount = Integer.parseInt(amount);
		List<ProductModel> list = prodService.getNext3Product(iamount);
		PrintWriter out = response.getWriter();
		for (ProductModel o : list) {
			out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n" + "<div class=\"card\">\n"
					+ "<img class=\"card-img-top\" src=\"<c:url value=\"/image?fname=" + o.getImages() + "/>\" alt=\"imag\">\n"
					+ "<div class=\"card-body\">\n" + "<h4 class=\"card-title show_txt\"><a	href=\"detail?pid="
					+ o.getProductId() + "\" title=\"View Product\">" + o.getProductName() + "</a></h4>\n"
					+ "<p class=\"card-text show_txt\">" + o.getProductName() + "</p>\n" + "<div class=\"row\">\n"
					+ "<div class=\"col\">\n" + "<p class=\"btn btn-danger btn-block\">" + o.getPrice() + " $</p>\n"
					+ "</div>\n" + "<div class=\"col\">\n"
					+ "<a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\n" + "</div>\n" + "</div>\n"
					+ "</div>\n" + "</div>\n" + "</div>");
		}
	}

}
