package iotstar.vn.controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;
import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;

@MultipartConfig
@WebServlet(urlPatterns = {"/web/category", "/web/category/page"})
public class CategoryWebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICategoryService categoryService = new ICategoryServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		// kiểm tra url rồi chuyển đến hàm tương ứng

		// lấy url

		String url = request.getRequestURL().toString();
		boolean getAll = true;
		
		if (url.contains("page"))
		{
			categoryPage(request, response);
			getAll = true;
		}

		if(getAll)
		{
			//findAll(request, response);
			
			categoryPage(request, response);

			request.getRequestDispatcher("/views/web/category/list.jsp").forward(request, response);
		}
//		

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
		req.getRequestDispatcher("/views/web/category/list.jsp").forward(req, resp);
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

}
