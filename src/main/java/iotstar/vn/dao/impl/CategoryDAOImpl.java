package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Clock;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import iotstar.vn.Service.ICategoryService;
import iotstar.vn.Service.Impl.ICategoryServiceImpl;
import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.ICategoryDAO;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;

public class CategoryDAOImpl extends DBConnection implements ICategoryDAO {
	@Override
	public int countAll() {
		String sql = "select count(*) from Category";
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
	public List<CategoryModel> findAllPage(int indexp, int size) {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "select * from Category\r\n" + "ORDER BY Category._id DESC OFFSET ? rows fetch next ? rows only";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ps.setInt(2, size);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.set_id(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setIsDeleted(rs.getInt("isDeleted"));
				category.setCreatedAt(rs.getTimestamp("createdAt"));
				category.setUpdatedAt(rs.getTimestamp("updatedAt"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void insert(CategoryModel category) {
		try {
			if (category.getCategoryId() != 0) {
				String sql = "INSERT INTO Category(name, slug, categoryId, image, isDeleted, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?)";
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, category.getName());
				ps.setString(2,
						category.getName().concat(Long.toString(System.currentTimeMillis())).replaceAll(" ", ""));
				ps.setInt(3, category.getCategoryId());
				ps.setString(4, category.getImage());
				ps.setInt(5, 0);
				Timestamp today = new Timestamp(System.currentTimeMillis());
				ps.setTimestamp(6, today);
				ps.setTimestamp(7, today);
				ps.executeUpdate();
			} else {
				String sql = "INSERT INTO Category(name, slug, image, isDeleted, createdAt, updatedAt) VALUES (?,?,?,?,?,?)";
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, category.getName());
				ps.setString(2,
						category.getName().concat(Long.toString(System.currentTimeMillis())).replaceAll(" ", ""));
				ps.setString(3, category.getImage());
				ps.setInt(4, 0);
				Timestamp today = new Timestamp(System.currentTimeMillis());
				ps.setTimestamp(5, today);
				ps.setTimestamp(6, today);

				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBy_id(int _id) {
		String sql = "DELETE FROM category WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByCategoryId(int catetegoryId) {
		String sql = "DELETE FROM category WHERE categoryId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, catetegoryId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel findByCategoryId(int categoryId) {
		String sql = "SELECT * FROM Category WHERE categoryId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.set_id(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setIsDeleted(rs.getInt("isDeleted"));
				category.setCreatedAt(rs.getTimestamp("createdAt"));
				category.setUpdatedAt(rs.getTimestamp("updatedAt"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findBy_id(int _id) {
		String sql = "SELECT * FROM Category WHERE _id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.set_id(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setIsDeleted(rs.getInt("isDeleted"));
				category.setCreatedAt(rs.getTimestamp("createdAt"));
				category.setUpdatedAt(rs.getTimestamp("updatedAt"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.set_id(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setIsDeleted(rs.getInt("isDeleted"));
				category.setCreatedAt(rs.getTimestamp("createdAt"));
				category.setUpdatedAt(rs.getTimestamp("updatedAt"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category SET name=?, image=?, isDeleted=?, updatedAt=? WHERE _id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getIsDeleted() == true ? 1 : 0);
			ps.setTimestamp(4, category.getUpdatedAt());
			ps.setInt(5, category.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category WHERE or name = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.set_id(rs.getInt("_id"));
				category.setName(rs.getString("name"));
				category.setSlug(rs.getString("slug"));
				category.setCategoryId(rs.getInt("categoryId"));
				category.setImage(rs.getString("image"));
				category.setIsDeleted(rs.getInt("isDeleted"));
				category.setCreatedAt(rs.getTimestamp("createdAt"));
				category.setUpdatedAt(rs.getTimestamp("updatedAt"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

//	@Override 
//	public CategoryModel get(String name) {
//		CategoryModel category = new CategoryModel();
//		return category;
//	}
//	
//	@Override
//	public CategoryModel findById(int id) {
//		String sql = "Select * From Category where categoryid=?";
//		try {
//			Connection conn = new DBConnection().getConnection(); // kết nối CSDL
//			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
//			ps.setInt(1, id); // đưa tham vào dấu ?
//			ResultSet rs = ps.executeQuery(); // thực thi câu query và trả về Resultset
//			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
//				CategoryModel category = new CategoryModel();
//				category.setCateid(rs.getInt("categoryid"));
//				category.setCatename(rs.getString("categoryname"));
//				category.setImages(rs.getString("images"));
//				category.setStatus(rs.getInt("status"));
//				return category;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
