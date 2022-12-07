package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.ICategoryDAO;
import iotstar.vn.model.CategoryModel;

public class ICategoryDAOImpl extends DBConnection implements ICategoryDAO {
	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO category(categoryName, images, status) VALUES (?,?,1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCatename());
			ps.setString(2, category.getImages());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE categoryId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM category WHERE categoryId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				//Lay du lieu qua chi so
				category.setCateid(rs.getInt(1));
				//Lay chi so qua ten cot
				category.setCatename(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
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
				category.setCateid(rs.getInt("categoryId"));
				category.setCatename(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE category SET categoryName=?, images=?, status=? WHERE categoryId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getCatename());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCateid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<CategoryModel> search(String keyword){
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		return categories;
	}
	
	@Override 
	public CategoryModel get(String name) {
		CategoryModel category = new CategoryModel();
		return category;
	}
	
	@Override
	public CategoryModel findById(int id) {
		String sql = "Select * From Category where categoryid=?";
		try {
			Connection conn = new DBConnection().getConnection(); // kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql); // ném câu lệnh sql bằng phát biểu preparestatement
			ps.setInt(1, id); // đưa tham vào dấu ?
			ResultSet rs = ps.executeQuery(); // thực thi câu query và trả về Resultset
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				CategoryModel category = new CategoryModel();
				category.setCateid(rs.getInt("categoryid"));
				category.setCatename(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
