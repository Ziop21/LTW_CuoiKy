package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.ICartDao;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.CartModel;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.UserModel;

public class CartDaoImpl extends DBConnection implements ICartDao{
	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Cart(userId, createdAt ) VALUES (?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setTimestamp(2,cart.getCreatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "Delete FROM Cart WHERE _id = ?";
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
	public CartModel get(int id)
	{
		String sql = "SELECT * FROM Cart Where userId = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				CartModel cart = new CartModel();
				cart.set_id(rs.getInt("_id"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreatedAt(rs.getTimestamp("createdAt"));
				cart.setUpdatedAt(rs.getTimestamp("updatedAt"));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<CartModel> findAll(){
		List<CartModel> carts = new ArrayList<CartModel>();
		String sql = "SELECT * FROM Cart";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartModel cart = new CartModel();
				cart.set_id(rs.getInt("categoryId"));
				cart.setUserId(rs.getInt("userId"));
				cart.setStoreId(rs.getInt("storeId"));
				cart.setCreatedAt(rs.getTimestamp("createdAt"));
				cart.setUpdatedAt(rs.getTimestamp("updatedAt"));
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;
		}
	@Override
	public void edit(CartModel cart) {
		String sql = "UPDATE Cart SET userId=?, storeId=?, updatedAt=? WHERE _id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getStoreId());
			ps.setTimestamp(3, cart.getUpdatedAt());
			ps.setInt(4, cart.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
