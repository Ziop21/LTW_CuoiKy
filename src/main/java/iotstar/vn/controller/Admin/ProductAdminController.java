package iotstar.vn.controller.Admin;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.IProductService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.Service.Impl.IProductServiceImpl;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;
import iotstar.vn.utils.Constant;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin/product", "/admin/product/page", "/admin/product/listImages", "/admin/product/reset",
		"/admin/product/create", "/admin/product/update", "/admin/product/edit", "/admin/product/delete" })
public class ProductAdminController extends HttpServlet {
	IProductService productService = new IProductServiceImpl();
	ICategoryService categoryService = new ICategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// kiểm tra url rồi chuyển đến hàm tương ứng

		// lấy url
		boolean getList = true;

		String url = request.getRequestURL().toString();

		ProductModel product = null;

		if (url.contains("create")) {
			getList = false;
			request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
		} else if (url.contains("listImages")) {

			try {
				listImages(request, response);
				getList = false;

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (url.contains("page")) {

			try {
				productPage(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			getList = false;
		} else if (url.contains("delete")) {

			delete(request, response);

		} else if (url.contains("edit")) {

			edit(request, response);

		} else if (url.contains("reset")) {

			product = new ProductModel();

			request.setAttribute("product", product);

		}

		// gọi hàm findAll để lấy thông tin từ entity
//		if (getList) {
//			findAll(request, response);
//
//			request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);
//		}
		productPage(request, response);

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

				request.setAttribute("product", new ProductModel());

			}

			// gọi hàm findAll để lấy thông tin từ entity

			findAll(request, response);

			request.getRequestDispatcher("/views/admin/product/list.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void productPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String categoryid = req.getParameter("categoryid");
		String indexPage = req.getParameter("index");
		String pageSize = req.getParameter("pageSize");
		// phân trang, khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int size = 4;
		int indexp = Integer.parseInt(indexPage);
		if (pageSize != "0" && pageSize != "" && pageSize != null )
			size = Integer.parseInt(pageSize);
		// Get data từ DAO
		int countP = productService.countAll();
		// chia trang cho count
		int endPage = countP / size;
		if (countP % size != 0) {
			endPage++;
		}
		req.setAttribute("pageSize", size);
		
		List<ProductModel> productListNew = productService.findAllPage(size*(indexp - 1), size);
		req.setAttribute("products", productListNew);
		req.setAttribute("countproductAll", countP);
//		// lay du lieu va day len view
//		List<CategoryModel> categoryList = categoryService.findAll();
//		req.setAttribute("categoryList", categoryList);
		// Truyền lên JSP
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		
		
//		req.setAttribute("cateid", categoryid);
		req.getRequestDispatcher("/views/admin/product/list.jsp").forward(req, resp);
	}

	protected void listImages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String _id = request.getParameter("id");

		String[] list = productService.findBy_Id(Integer.parseInt(_id)).getListImages();

		request.setAttribute("listImages", list);

		request.getRequestDispatcher("/views/admin/product/listImages.jsp").forward(request, response);

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)

			throws Exception {

		ProductModel product = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			String tempListImage = "";
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					if (!item.getString().isEmpty())
						product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					if (!item.getString().isEmpty())
						product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					if (!item.getString().isEmpty())
						product.setPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("promotionalPrice")) {
					if (!item.getString().isEmpty())
						product.setPromotionalPrice(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("quantity")) {
					if (!item.getString().isEmpty())
						product.setQuantity(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("categoryId")) {
					if (!item.getString().isEmpty()) {
						product.setCategoryId(Integer.parseInt(item.getString()));
						product.setCategory(categoryService.findBy_id(product.get_id()));
					}
				} else if (item.getFieldName().equals("storeId")) {
					if (!item.getString().isEmpty())
						product.setStoreId(Integer.parseInt(item.getString()));
				}
				if (item.getFieldName().equals("icon")) {
					if (!item.getName().isEmpty()) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);
						tempListImage = tempListImage.concat("product/" + fileName + ",");
					}
				}
			}
			if (tempListImage != "") {
				tempListImage = (String) tempListImage.subSequence(0, tempListImage.lastIndexOf(","));
				product.setListImages(tempListImage);
			}
			if (product.getListImages() == null) {
				product.setListImages("noimage.jpg");
			}
			productService.insert(product);

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			// khởi tạo DAO

			// khai báo danh sách và gọi hàm findAll() trong dao

			List<ProductModel> list = productService.findAll();

			// thông báo

			request.setAttribute("products", list);

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			String _id = request.getParameter("id");

			ProductModel product = productService.findBy_Id(Integer.parseInt(_id));

			String[] list = productService.findBy_Id(Integer.parseInt(_id)).getListImages();

			request.setAttribute("listImages", list);

			request.setAttribute("product", product);

			request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);

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

			productService.deleteBy_id(Integer.parseInt(_id));

			// thông báo

			request.setAttribute("message", "Đã xóa thành công");

		} catch (Exception e) {

			e.printStackTrace();

			request.setAttribute("error", "Eror: " + e.getMessage());

		}

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		ProductModel newProduct = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			String tempListImage = "";
			for (FileItem item : items) {
				if (item.getFieldName().equals("_id")) {
					newProduct = productService.findBy_Id(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					newProduct.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					newProduct.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					newProduct.setPrice(Float.parseFloat(item.getString()));
				} else if (item.getFieldName().equals("promotionalPrice")) {
					newProduct.setPromotionalPrice(Float.parseFloat(item.getString()));
				} else if (item.getFieldName().equals("quantity")) {
					if (!item.getString().isEmpty())
						newProduct.setQuantity(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isActive")) {
					if (!item.getString().isEmpty())
						newProduct.setIsActive(item.getString().equals("true") ? 1 : 0);
				} else if (item.getFieldName().equals("isSelling")) {
					if (!item.getString().isEmpty())
						newProduct.setIsSelling(item.getString().equals("true") ? 1 : 0);
				} else if (item.getFieldName().equals("categoryId")) {
					if (!item.getString().isEmpty()) {
						newProduct.setCategoryId(Integer.parseInt(item.getString()));
						newProduct.setCategory(categoryService.findBy_id(newProduct.getCategoryId()));
					}

				} else if (item.getFieldName().equals("storeId")) {
					if (!item.getString().isEmpty())
						newProduct.setStoreId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("rating")) {
					if (!item.getString().isEmpty())
						newProduct.setRating(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("icon")) {
					if (item.getFieldName().equals("icon")) {
						if (!item.getName().isEmpty()) {
							String originalFileName = item.getName();
							int index = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(index + 1);
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.DIR + "/product/" + fileName);
							item.write(file);
							tempListImage = tempListImage.concat("product/" + fileName + ",");
						}
					}
				}
			}
			if (tempListImage != "") {
				tempListImage = (String) tempListImage.subSequence(0, tempListImage.lastIndexOf(","));
				newProduct.setListImages(tempListImage);
			}
			if (newProduct.getListImages() == null) {
				newProduct.setListImages("noimage.jpg");
			}
			newProduct.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			productService.edit(newProduct);
			// response.sendRedirect(request.getContextPath() + "/admin/category");

		} catch (

		FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
