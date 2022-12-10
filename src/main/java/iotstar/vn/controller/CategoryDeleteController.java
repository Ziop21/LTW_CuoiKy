package iotstar.vn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;

public class CategoryDeleteController extends HttpServlet {
	ICategoryService cateService = new ICategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		cateService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
