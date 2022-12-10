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

public class IUserDAOImpl extends DBConnection implements IUserDAO {
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO [dbo].[User](fistname, lastname, slug, id_card, email, phone, isEmalActive, isPhoneActive, salt, password, role, address, avatar, cover, createdAt) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getSlug());
			ps.setString(4, user.getId_card());;
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setBoolean(7, user.isEmailActive());
			ps.setBoolean(8, user.isPhoneActive());
			ps.setString(9, user.getSalt());
			ps.setString(10, user.getHashed_password());
			ps.setString(11, user.getRole());
			ps.setString(12, user.getAddress());
			ps.setString(13, user.getAvatar());
			ps.setString(14, user.getCover());
			ps.setTimestamp(15, user.getCreatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM [dbo].[User] WHERE _id = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserModel get(int id) {
		String sql = "SELECT * FROM [dbo].[User] WHERE _id = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				//Lay du lieu qua chi so
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("fistname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setAddress(rs.getString("address"));		
				user.setAvatar(rs.getString("avatar"));		
				user.setCover(rs.getString("cover"));		
				user.setCreatedAt(rs.getTimestamp("createdAt"));	
				user.setUpdatedAt(rs.getTimestamp("updatedAt"));	
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	@Override
	public UserModel getByEmailAndPass(String email, String pass) {
		String sql = "SELECT * FROM [dbo].[User] WHERE email = ? and password = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("fistname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setAddress(rs.getString("address"));		
				user.setAvatar(rs.getString("avatar"));		
				user.setCover(rs.getString("cover"));		
				user.setCreatedAt(rs.getTimestamp("createdAt"));	
				user.setUpdatedAt(rs.getTimestamp("updatedAt"));	
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public UserModel getByEmail(String email) {
		String sql = "SELECT * FROM [dbo].[User] WHERE email = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("fistname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setAddress(rs.getString("address"));		
				user.setAvatar(rs.getString("avatar"));		
				user.setCover(rs.getString("cover"));		
				user.setCreatedAt(rs.getTimestamp("createdAt"));	
				user.setUpdatedAt(rs.getTimestamp("updatedAt"));	
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	@Override
	public void updatePass(String email, String pass) {
		String sql = "UPDATE [dbo].[User] SET password=? WHERE email = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserModel> findAll() {
		List<UserModel> users  = new ArrayList<UserModel>();
		String sql = "SELECT * FROM [dbo].[User]";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("fistname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmailActive(rs.getBoolean("isEmalActive"));
				user.setPhoneActive(rs.getBoolean("isPhoneActive"));
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setAddress(rs.getString("address"));		
				user.setAvatar(rs.getString("avatar"));		
				user.setCover(rs.getString("cover"));		
				user.setCreatedAt(rs.getTimestamp("createdAt"));	
				user.setUpdatedAt(rs.getTimestamp("updatedAt"));	
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	} 
	/*
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
	}*/
}
