package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.IProductService;
import iotstar.vn.Service.IProductWebService;
import iotstar.vn.Service.IStoreService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.Service.Impl.IProductServiceImpl;
import iotstar.vn.Service.Impl.StoreServiceImpl;
import iotstar.vn.model.ProductModel;
@WebServlet(urlPatterns = { "/myprofile/vendor/product/list","/myprofile/vendor/category/list","/myprofile/vendor/store/list","/myprofile/vendor/product/add"
		,"/myprofile/vendor/category/add","/myprofile/vendor/store/add","/myprofile/vendor/product/edit","/myprofile/vendor/category/edit","/myprofile/vendor/store/edit"
		,"/myprofile/vendor/product/delete","/myprofile/vendor/category/delete","/myprofile/vendor/store/delete"})
public class VendorController extends HttpServlet{
	IProductService proService = new IProductServiceImpl();
	ICategoryService cateService = new ICategoryServiceImpl();
	IStoreService storeService = new StoreServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("myprofile/vendor/product/list")) {
			listProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/list")) {
			listCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/list")) {
			listStore(req, resp);
		}
		if (url.contains("myprofile/vendor/product/add")) {
			addProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/add")) {
			addCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/add")) {
			addStore(req, resp);
		}
		if (url.contains("myprofile/vendor/product/edit")) {
			editProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/edit")) {
			editCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/edit")) {
			editStore(req, resp);
		}
		if (url.contains("myprofile/vendor/product/delete")) {
			deleteProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/delete")) {
			deleteCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/delete")) {
			deleteStore(req, resp);
		}
	}
	protected void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cateId");
		req.getRequestDispatcher("/views/profile/vendor/list-product.jsp").forward(req, resp);
	}
	
	
	protected void listCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeId");
		req.getRequestDispatcher("/views/profile/vendor/list-category.jsp").forward(req, resp);
	}
	
	
	protected void listStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		req.getRequestDispatcher("/views/profile/vendor/list-store.jsp").forward(req, resp);
	}
	
	
	protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-product.jsp").forward(req, resp);
	}
	
	
	protected void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-category.jsp").forward(req, resp);
	}
	
	
	protected void addStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-store.jsp").forward(req, resp);
	}
	
	
	protected void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("productId");
		req.getRequestDispatcher("/views/profile/vendor/edit-product.jsp").forward(req, resp);
	}
	
	
	protected void editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cateId");
		req.getRequestDispatcher("/views/profile/vendor/edit-category.jsp").forward(req, resp);
	}
	
	
	protected void editStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeId");
		req.getRequestDispatcher("/views/profile/vendor/edit-store.jsp").forward(req, resp);
	}
	
	
	protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("productId");
		proService.deleteBy_id(Integer.parseInt(id));
		req.getRequestDispatcher("/views/profile/vendor/edit-product.jsp").forward(req, resp);
	}
	
	
	protected void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cateId");
		cateService.delete(Integer.parseInt(id));
		req.getRequestDispatcher("/views/profile/vendor/edit-category.jsp").forward(req, resp);
	}
	
	
	protected void deleteStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("storeId");
		storeService.delete(Integer.parseInt(id));
		req.getRequestDispatcher("/views/profile/vendor/edit-store.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("myprofile/vendor/product/list")) {
			PostlistProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/list")) {
			PostlistCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/list")) {
			PostlistStore(req, resp);
		}
		if (url.contains("myprofile/vendor/product/add")) {
			PostaddProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/add")) {
			PostaddCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/add")) {
			PostaddStore(req, resp);
		}
		if (url.contains("myprofile/vendor/product/edit")) {
			PosteditProduct(req, resp);
		}
		if (url.contains("/myprofile/vendor/category/edit")) {
			PosteditCategory(req, resp);
		}
		if (url.contains("/myprofile/vendor/store/edit")) {
			PosteditStore(req, resp);
		}
	}
	protected void PostlistProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/list-product.jsp").forward(req, resp);
	}
	protected void PostlistCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/list-category.jsp").forward(req, resp);
	}
	protected void PostlistStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/list-store.jsp").forward(req, resp);
	}
	protected void PostaddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-product.jsp").forward(req, resp);
	}
	protected void PostaddCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-category.jsp").forward(req, resp);
	}
	protected void PostaddStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/add-store.jsp").forward(req, resp);
	}
	protected void PosteditProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/edit-product.jsp").forward(req, resp);
	}
	protected void PosteditCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/edit-category.jsp").forward(req, resp);
	}
	protected void PosteditStore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/profile/vendor/edit-store.jsp").forward(req, resp);
	}
}
