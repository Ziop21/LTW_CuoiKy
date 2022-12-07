package iotstar.vn.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.Out;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.model.CategoryModel;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/admin/category/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

public class CategoryAddController extends HttpServlet 
{
	ICategoryService cateService = new ICategoryServiceImpl();
	public static final String SAVE_DIRECTORY = "Upload";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					category.setCatename(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("icon")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					category.setImages("category/" + fileName);	
				}
			}
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	@Override
	//Them category bằng anonation
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SecurityException {
		try {			
			CategoryModel category = new CategoryModel();
			
			String name = req.getParameter("name");
			Part part= req.getPart("icon");
			//String realPath = req.getServletContext().getRealPath("");
			
			
			
			String filename=System.currentTimeMillis() + Paths.get(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Paths.get(Constant.DIR))) {
			Files.createDirectory(Paths.get(Constant.DIR));
			}
			part.write(Constant.DIR+"/category/"+filename);
			
			category.setCatename(name);
			category.setImages("category/"+filename);
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
			
		} catch (Exception e) {
		}
	}*/
}
