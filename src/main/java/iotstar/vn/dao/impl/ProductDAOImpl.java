package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IProductDAO;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;

public class ProductDAOImpl extends DBConnection implements IProductDAO {

	@Override
	public List<ProductModel> findAllPage(int indexp, int size) {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		String sql = "select Product._id,Product.name,Product.slug,Product.description,Product.price,Product.promotionalPrice,Product.quantity,Product.sold,Product.isActive,\r\n"
				+ " Product.isSelling,Product.images,Product.categoryId, Product.storeId,Product.rating,Product.createdAt,Product.updatedAt,\r\n"
				+ "Category._id,Category.name\r\n" + "from Product\r\n"
				+ "INNER JOIN Category ON Product.categoryId = Category._id\r\n"
				+ "ORDER BY Product._id DESC OFFSET ? rows fetch next ? rows only";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
		}

//	public List<ProductModel> getNext3Product(int amount) {
//		List<ProductModel> productList = new ArrayList<ProductModel>();
//		String query = "SELECT * FROM product ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";
//		try {
//			Connection conn = new DBConnection().getConnection();// mo ket noi voi sql
//			PreparedStatement ps = conn.prepareStatement(query);
//			// set vị trí của product
//			ps.setInt(1, amount);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				ICategoryService cateService = new ICategoryServiceImpl();
//				CategoryModel category = cateService.findById(rs.getInt("categoryid"));
//				ProductModel product = new ProductModel();
//				product.setProductId(rs.getInt("productid"));
//				product.setProductCode(rs.getInt("productCode"));
//				product.setProductName(rs.getString("productName"));
//				product.setAmount(rs.getInt("amount"));
//				product.setDescription(rs.getString("description"));
//				product.setImages(rs.getString("images"));
//				product.setPrice(rs.getFloat("price"));
//				product.setStock(rs.getInt("stock"));
//				product.setWishlist(rs.getInt("wishlist"));
//				product.setStatus(rs.getInt("status"));
//				product.setCreateDate(rs.getDate("createDate"));
//				product.setCategory(category);
//				productList.add(product);
//			}
//		} catch (Exception e) {
//		}
//		return productList;
//	}
	@Override
	public List<ProductModel> findByCategoryIdPage(int categoryId, int indexp, int size) {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product WHERE categoryId = ?"
				+ " ORDER BY Product._id DESC OFFSET ? rows fetch next ? rows only";
		try {
			Connection conn = super.getConnection();
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, indexp);
			ps.setInt(3, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public List<ProductModel> findByCategoryId(int categoryId) {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product WHERE categoryId = ?";
		try {
			Connection conn = super.getConnection();
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM Product ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ProductModel findBy_Id(int _id) {
		String sql = "SELECT * FROM Product WHERE _id = ?";
		try {
			Connection conn = super.getConnection();
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	// Hàm đếm số Product
	public int countAll() {
		String sql = "select count(*) from Product";
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

	@Override
	public List<ProductModel> getTop3Product() {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		String query = "SELECT TOP(3) * FROM product ORDER BY amount DESC";
		try {
			Connection conn = new DBConnection().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setIsActive(rs.getInt("isActive"));
				product.setIsSelling(rs.getInt("isSelling"));
				product.setListImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getTimestamp("createdAt"));
				product.setUpdatedAt(rs.getTimestamp("updatedAt"));

				ICategoryService cateService = new ICategoryServiceImpl();
				CategoryModel category = cateService.findByCategoryId(rs.getInt("categoryId"));
				product.setCategory(category);

				productList.add(product);
			}
		} catch (Exception e) {
		}
		return productList;
	}

	@Override
	public void insert(ProductModel product) {
		String sql = "";
		if (product.getListImages() != null) {
			if (product.getStoreId() != 0)
			sql = "INSERT INTO Product(name, slug, description, price, promotionalPrice, quantity, sold, isActive, isSelling"
					+ ",images, categoryId, storeId, rating, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			else
				sql = "INSERT INTO Product(name, slug, description, price, promotionalPrice, quantity, sold, isActive, isSelling"
						+ ",images, categoryId, rating, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		} else {
			if (product.getStoreId() != 0)
				sql = "INSERT INTO Product(name, slug, description, price, promotionalPrice, quantity, sold, isActive, isSelling"
						+ ",categoryId, storeId, rating, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				else
					sql = "INSERT INTO Product(name, slug, description, price, promotionalPrice, quantity, sold, isActive, isSelling"
							+ ",categoryId, rating, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getName().concat(Long.toString(System.currentTimeMillis())).replaceAll(" ", ""));
			ps.setString(3, product.getDescription());
			ps.setFloat(4, product.getPrice());
			ps.setFloat(5, product.getPromotionalPrice());
			ps.setInt(6, product.getQuantity());
			ps.setInt(7, 0);
			ps.setInt(8, 1);
			ps.setInt(9, 1);
			
			if (product.getListImages() != null)
			{
				String ListImagesString = "";
				String [] ListOfImages = product.getListImages();
 				for (int i = 0; i < product.getListImages().length; i++) {
					if (i == product.getListImages().length - 1)
						ListImagesString = ListImagesString.concat(ListOfImages[i]);
					else
						ListImagesString = ListImagesString.concat(ListOfImages[i] + ",");
				}
				ps.setString(10, ListImagesString);
				ps.setInt(11, product.getCategoryId());
				if (product.getStoreId() != 0)
				{
					ps.setInt(12, product.getStoreId());
					ps.setInt(13, 0);
					Timestamp now = new Timestamp(System.currentTimeMillis());
					ps.setTimestamp(14, now);
					ps.setTimestamp(15, now);
				}
				else
				{
					ps.setInt(12, 0);
					Timestamp now = new Timestamp(System.currentTimeMillis());
					ps.setTimestamp(13, now);
					ps.setTimestamp(14, now);
				}
				
				
			}
			else {
				ps.setInt(10, product.getCategoryId());
				if (product.getStoreId() != 0)
				{
					ps.setInt(11, product.getStoreId());
					ps.setInt(12, 0);
					Timestamp now = new Timestamp(System.currentTimeMillis());
					ps.setTimestamp(13, now);
					ps.setTimestamp(14, now);
				}
				else
				{
					ps.setInt(11, 0);
					Timestamp now = new Timestamp(System.currentTimeMillis());
					ps.setTimestamp(12, now);
					ps.setTimestamp(13, now);
				}
			}
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(ProductModel product) {
		String sql = "";
		if (product.getStoreId() != 0)
			sql = "UPDATE Product SET name = ?, description = ?, price = ?, promotionalPrice = ?, quantity = ?, isActive = ?, isSelling = ?"
				+ ",images = ?, categoryId = ?, storeId = ?, rating = ?, updatedAt = ? WHERE _id = ?";
		else
			sql = "UPDATE Product SET name = ?, description = ?, price = ?, promotionalPrice = ?, quantity = ?, isActive = ?, isSelling = ?"
					+ ",images = ?, categoryId = ?, rating = ?, updatedAt = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setFloat(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getIsActive() == true ? 1 : 0);
			ps.setInt(7, product.getIsSelling() == true ? 1 : 0);
			String ListImagesString = "";
			String [] ListOfImages = product.getListImages();
			for (int i = 0; i < product.getListImages().length; i++) {
				if (i == product.getListImages().length - 1)
					ListImagesString = ListImagesString.concat(ListOfImages[i]);
				else
					ListImagesString = ListImagesString.concat(ListOfImages[i] + ",");
			}
			ps.setString(8, ListImagesString);
			ps.setInt(9, product.getCategoryId());
			if (product.getStoreId() != 0)
			{
				ps.setInt(10, product.getStoreId());
				ps.setInt(11, product.getRating());
				Timestamp now = new Timestamp(System.currentTimeMillis());
				ps.setTimestamp(12, now);
				ps.setInt(13, product.get_id());
			}
			else{
				ps.setInt(10, product.getRating());
				Timestamp now = new Timestamp(System.currentTimeMillis());
				ps.setTimestamp(11, now);
				ps.setInt(12, product.get_id());
			}
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBy_id(int _id) {
		String sql = "DELETE FROM Product WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
