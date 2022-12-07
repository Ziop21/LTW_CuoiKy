package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.model.CategoryModel;

/**
 * Servlet implementation class CategoryListWebController
 */
@WebServlet("/category/list")
public class CategoryListWebController extends HttpServlet {
	ICategoryService cateService = new ICategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> cateList = cateService.findAll();
		req.setAttribute("cateList", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/list-category.jsp");
		dispatcher.forward(req, resp);
	}

}
