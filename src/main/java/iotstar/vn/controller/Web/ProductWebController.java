package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.IProductService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.Service.Impl.IProductServiceImpl;
import iotstar.vn.model.ProductModel;

@MultipartConfig
@WebServlet(urlPatterns = { "/web/product", "/web/product/page", "/web/product/category", "/web/product/details", "/web/product/listImages",
		"/web/product/reset" })
public class ProductWebController extends HttpServlet {
	IProductService productService = new IProductServiceImpl();
	ICategoryService categoryService = new ICategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// kiểm tra url rồi chuyển đến hàm tương ứng

		// lấy url
		boolean getList = true;

		String url = request.getRequestURL().toString();

		ProductModel product = null;

		if (url.contains("reset")) {

			product = new ProductModel();

			request.setAttribute("product", product);

		} else if (url.contains("details")) {

			try {
				details(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			getList = false;
		} else if (url.contains("page")) {

			try {
				productPage(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			getList = false;
		} else if (url.contains("category")){
			try {
				listByCategoryId(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			getList = false;
		}

		// gọi hàm findAll để lấy thông tin từ entity
//		if (getList) {
//			findAll(request, response);
//
//			request.getRequestDispatcher("/views/web/product/list.jsp").forward(request, response);
//		}
		if (getList)
			productPage(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		try {
			// lấy url

			String url = request.getRequestURL().toString();

			// kiểm tra url rồi chuyển đến hàm tương ứng

			if (url.contains("reset")) {

				request.setAttribute("product", new ProductModel());

			}

			// gọi hàm findAll để lấy thông tin từ entity

			findAll(request, response);

			request.getRequestDispatcher("/views/web/product/list.jsp").forward(request, response);

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
		req.getRequestDispatcher("/views/web/product/list.jsp").forward(req, resp);
	}
	protected void listByCategoryId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String _id = request.getParameter("id");
			
			String categoryid = request.getParameter("categoryid");
			String indexPage = request.getParameter("index");
			String pageSize = request.getParameter("pageSize");
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
			request.setAttribute("pageSize", size);
			
			List<ProductModel> productListNew = productService.findByCategoryIdPage(Integer.parseInt(_id), size*(indexp - 1), size);
			productListNew.isEmpty();
			request.setAttribute("products", productListNew);
			request.setAttribute("countproductAll", countP);
//			// lay du lieu va day len view
//			List<CategoryModel> categoryList = categoryService.findAll();
//			req.setAttribute("categoryList", categoryList);
			// Truyền lên JSP
			request.setAttribute("endP", endPage);
			request.setAttribute("tag", indexp);
			
			
//			req.setAttribute("cateid", categoryid);
			request.getRequestDispatcher("/views/web/product/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void details(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String _id = request.getParameter("id");
			ProductModel product = productService.findBy_Id(Integer.parseInt(_id));
			String[] list = product.getListImages();
			request.setAttribute("listOfImages", list);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/views/web/product/details.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void listImages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String _id = request.getParameter("id");

		String[] list = productService.findBy_Id(Integer.parseInt(_id)).getListImages();

		request.setAttribute("listImages", list);

		request.getRequestDispatcher("/views/web/product/listImages.jsp").forward(request, response);

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

}
