package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IUserDAO;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.UserModel;

public class UserDAOImpl extends DBConnection implements IUserDAO {
	public void insert(UserModel user) {
		String sql = "INSERT INTO Users(userId, username, email, fullname, password, images, phone, status, code, roleId, sellerid) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullName());;
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getImages());
			ps.setString(7, user.getPhone());
			ps.setInt(8, user.getStatus());
			ps.setInt(9, user.getCode());
			ps.setInt(11, user.getSellerid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		String sql = "DELETE FROM Users WHERE userId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserModel get(int id) {
		String sql = "SELECT * FROM Users WHERE userId = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				//Lay du lieu qua chi so
				user.setId(rs.getInt(0));;
				//Lay chi so qua ten cot
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setImages(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setStatus(rs.getInt(7));
				user.setCode(rs.getInt(8));
				user.setRoleid(rs.getInt(9));
				user.setSellerid(rs.getInt(10));			
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	//CategoryModel get(String name);
	public List<UserModel> findAll(){
		List<UserModel> userlist = new ArrayList<UserModel>();
		String sql = "SELECT * FROM Users";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				//Lay du lieu qua chi so
				user.setId(rs.getInt(0));;
				//Lay chi so qua ten cot
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setImages(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setStatus(rs.getInt(7));
				user.setCode(rs.getInt(8));
				user.setRoleid(rs.getInt(9));
				user.setSellerid(rs.getInt(10));	
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}
	@Override
	public UserModel get(String username) {
		String sql = "SELECT * FROM Users WHERE username = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				//Lay du lieu qua chi so
				user.setId(rs.getInt(0));;
				//Lay chi so qua ten cot
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setImages(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setStatus(rs.getInt(7));
				user.setCode(rs.getInt(8));
				user.setRoleid(rs.getInt(9));
				user.setSellerid(rs.getInt(10));	
				return user;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
