package iotstar.vn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.model.CategoryModel;
import vn.iotstar.util.Constant;
import iotstar.vn.Service.ICategoryService;

	
//List Categories
@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryListController extends HttpServlet {
	ICategoryService cateService = new ICategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> cateList = cateService.findAll();
		req.setAttribute("cateList", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-category.jsp");
		dispatcher.forward(req, resp);
	}
}
