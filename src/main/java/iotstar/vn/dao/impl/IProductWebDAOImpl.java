package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IProductWebDAO;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;

public class IProductWebDAOImpl extends DBConnection  implements IProductWebDAO{

	@Override
	public List<ProductModel> findAll() {
		return null;
	}

	@Override
	public List<ProductModel> findLastProductList() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT TOP(4) * FROM product ORDER BY productId DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getInt("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	public List<ProductModel> findTopProductList()
	{
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT TOP(4) * FROM product ORDER BY amount DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getInt("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public ProductModel findTopProduct() {
		ProductModel products = new ProductModel();
		String sql = "SELECT TOP(1) * FROM product ORDER BY amount DESC";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getInt("productCode"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getString("images"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				
				products = product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public ProductModel findById(int id) {
		String sql = "Select Product.productId,Product.productName,Product.productCode,"
				+ "Product.description,Product.amount,Product.price,"
				+ "Product.images,Product.createDate,Product.stock,\r\n"
				+ "Product.wishlist,Product.status, Category.categoryId,Category.categoryName\r\n" + "from Product\r\n"
				+ "INNER JOIN Category ON Product.categoryId = Category.categoryId\r\n" + "where productId =?";
		try {
			Connection conn = super.getConnection();
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ICategoryService cateService = new ICategoryServiceImpl();
				
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productid"));
				product.setProductCode(rs.getInt("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				
				CategoryModel category = cateService.findById(rs.getInt("categoryid"));
				
				product.setCategory(category);
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	
	@Override
	public List<ProductModel> findAllPage(int indexp) {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		String sql = "select Product.productId,Product.productName,Product.productCode,Product.description,Product.amount,Product.price,Product.images,Product.createDate,Product.stock,\r\n"
				+ " Product.wishlist,Product.status, Category.categoryId,Category.categoryName\r\n" + "from Product\r\n"
				+ "INNER JOIN Category ON Product.categoryId = Category.categoryId\r\n"
				+ "ORDER BY productid DESC OFFSET ? rows fetch next 3 rows only";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findById(rs.getInt("categoryid"));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productid"));
				product.setProductCode(rs.getInt("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
		}
	
		@Override
		// Hàm đếm số Product
		public int countAll() {
			String sql = "select count(*) from product";
			try {
				Connection conn = new DBConnection().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
			}
			return 0;
		}
		public List<ProductModel> getTop3Product() {
			List<ProductModel> productList = new ArrayList<ProductModel>();
			String query = "SELECT TOP(3) * FROM product ORDER BY amount DESC";
			try {
			Connection conn = new DBConnection().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findById(rs.getInt("categoryid"));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productid"));
				product.setProductCode(rs.getInt("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				productList.add(product);
			}
			} catch (Exception e) {
			}
			return productList;
			}
		
		public List<ProductModel> getNext3Product(int amount) {
			List<ProductModel> productList = new ArrayList<ProductModel>();
			String query = "SELECT * FROM product ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
			try {
			Connection conn = new DBConnection().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			// set vị trí của product
			ps.setInt(1, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findById(rs.getInt("categoryid"));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productid"));
				product.setProductCode(rs.getInt("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setAmount(rs.getInt("amount"));
				product.setDescription(rs.getString("description"));
				product.setImages(rs.getString("images"));
				product.setPrice(rs.getFloat("price"));
				product.setStock(rs.getInt("stock"));
				product.setWishlist(rs.getInt("wishlist"));
				product.setStatus(rs.getInt("status"));
				product.setCreateDate(rs.getDate("createDate"));
				product.setCategory(category);
				productList.add(product);
			}
			} catch (Exception e) {
			}
			return productList;
			}
}
