package iotstar.vn.controller.Admin;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//import org.apache.commons.beanutils.BeanUtils;

import iotstar.vn.model.CategoryModel;
import iotstar.vn.utils.Constant;
import iotstar.vn.utils.UploadUtils;
import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin/category", "/admin/category/page", "/admin/category/reset", "/admin/category/create",
		"/admin/category/update", "/admin/category/edit", "/admin/category/delete" })
public class CategoryAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICategoryService categoryService = new ICategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// kiểm tra url rồi chuyển đến hàm tương ứng

		// lấy url

		String url = request.getRequestURL().toString();

		CategoryModel category = null;

		if (url.contains("create")) {

			request.getRequestDispatcher("/views/admin/category/add.jsp").forward(request, response);

		} else if (url.contains("delete")) {

			delete(request, response);
			
		} else if (url.contains("page")) {
			
			categoryPage(request, response);

		} else if (url.contains("edit")) {

			edit(request, response);

		} else if (url.contains("reset")) {

			category = new CategoryModel();

			request.setAttribute("category", category);

		}

		// gọi hàm findAll để lấy thông tin từ entity

		//findAll(request, response);
		
		categoryPage(request, response);

		request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		try {
			// lấy url

			String url = request.getRequestURL().toString();

			// kiểm tra url rồi chuyển đến hàm tương ứng

			if (url.contains("create")) {

				insert(request, response);

			} else if (url.contains("update")) {

				update(request, response);

			} else if (url.contains("delete")) {

				delete(request, response);

			} else if (url.contains("reset")) {

				request.setAttribute("category", new CategoryModel());

			}

			// gọi hàm findAll để lấy thông tin từ entity
			categoryPage(request, response);
			//findAll(request, response);

			request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void categoryPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String categoryid = req.getParameter("categoryid");
		String indexPage = req.getParameter("index");
		String pageSize = req.getParameter("pageSize");
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		int size = 4;
		if (pageSize != "0" && pageSize != "" && pageSize != null )
			size = Integer.parseInt(pageSize);
		// Get data từ DAO
		int countP = categoryService.countAll();
		// chia trang cho count
		int endPage = countP / size;
		if (countP % size != 0) {
			endPage++;
		}
		req.setAttribute("pageSize", size);
		List<CategoryModel> categories = categoryService.findAllPage(size * (indexp - 1), size);
		req.setAttribute("categories", categories);
		req.setAttribute("countproductAll", countP);
//		// lay du lieu va day len view
//		List<CategoryModel> categoryList = categoryService.findAll();
//		req.setAttribute("categoryList", categoryList);
		// Truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
//		req.setAttribute("cateid", categoryid);
		req.getRequestDispatcher("/views/admin/category/list.jsp").forward(req, resp);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws Exception {

		CategoryModel category = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					category.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("categoryId")) {
					if (!item.getString().isEmpty())
						category.setCategoryId(Integer.parseInt(item.getString()));
				}
				if (item.getFieldName().equals("icon")) {
					if (!item.getName().isEmpty()) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file);
						category.setImage("category/" + fileName);
					}

				}
			}
			categoryService.insert(category);
//			request.getRequestDispatcher("/views/admin/category/list.jsp").forward(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<CategoryModel> list = categoryService.findAll();

			// thông báo

			request.setAttribute("categories", list);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			String _id = request.getParameter("id");

			CategoryModel category = categoryService.findBy_id(Integer.parseInt(_id));

			request.setAttribute("category", category);

			request.getRequestDispatcher("/views/admin/category/edit.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// lấy dữ liệu trong jsp

			String _id = request.getParameter("id");

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			categoryService.deleteBy_id(Integer.parseInt(_id));

			// thông báo

			request.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		CategoryModel newCategory = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("_id")) {
					newCategory = categoryService.findBy_id(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					newCategory.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("categoryId")) {
					if (!item.getString().isEmpty())
						newCategory.setCategoryId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isDeleted")) {
					if (!item.getString().isEmpty())
						newCategory.setIsDeleted(item.getString().equals("true") ? 1 : 0);
				} else if (item.getFieldName().equals("icon")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file);
						newCategory.setImage("category/" + fileName);
					} else {
						newCategory.setImage(null);
					}
				}
			}
			if (newCategory.getImage() == null) {
				newCategory.setImage("noimage.jpg");
			}
			newCategory.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			categoryService.edit(newCategory);
			// response.sendRedirect(request.getContextPath() + "/admin/category");
		} catch (

		FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
