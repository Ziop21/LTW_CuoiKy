package iotstar.vn.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.model.CategoryModel;
import vn.iotstar.util.Constant;

@WebServlet("/uploadmulti")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadFileMultipart extends HttpServlet {
	public static final String SAVE_DIRECTORY = "uploads";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/uploadfilemulti.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SecurityException {
		try {
			String name = req.getParameter("name");
			Part part = req.getPart("image");
			String realPath = req.getServletContext().getRealPath("/uploads");
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Paths.get(realPath))) {
				Files.createDirectory(Paths.get(realPath));
			}
			part.write("C:\\UTEXLMS\\Nam3_2022_2023\\LTW"+ name);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}