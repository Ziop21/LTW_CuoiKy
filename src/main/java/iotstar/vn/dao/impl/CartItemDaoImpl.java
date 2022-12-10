package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import iotstar.vn.dao.ICartItemDao;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.ProductModel;

import java.util.ArrayList;
import iotstar.vn.connection.DBConnection;

public class CartItemDaoImpl extends DBConnection implements ICartItemDao {
	@Override
	public List<CartItemModel> findAll(){
		List<CartItemModel> cartItems = new ArrayList<CartItemModel>();
		String sql = "SELECT * FROM CartItem";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				cartItem.set_id(rs.getInt("categoryId"));
				cartItem.setCartId(rs.getInt("categoryName"));
				cartItem.setCount(rs.getInt("images"));
				cartItem.setProductId(rs.getInt("status"));
				cartItem.setCreatedAt(rs.getTimestamp("status"));
				cartItem.setUpdatedAt(rs.getTimestamp("status"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
		}
	@Override
	public int countAll() {
		String sql = "select count(*) from CartItem";
		try {
			Connection conn = super.getConnectionW();
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
	public int countAllByCartId(int cartId) {
		String sql = "select count(*) from CartItem Where cartId=?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	@Override
	public List<CartItemModel> findAllByCartId(int id){
		List<CartItemModel> cartItems = new ArrayList<CartItemModel>();
		String sql = "SELECT * FROM CartItem Where cartId = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItemModel cartItem = new CartItemModel();
				cartItem.set_id(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setCount(rs.getInt("count"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setCreatedAt(rs.getTimestamp("createdAt"));
				cartItem.setUpdatedAt(rs.getTimestamp("updatedAt"));
				cartItems.add(cartItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItems;
		}
	@Override
	public ProductModel get(int id)
	{
		String sql = "SELECT * FROM Product Where _id = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setImage(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<ProductModel> findAllProduct()
	{
		List<ProductModel> products = new ArrayList<ProductModel>();	
		String sql = "SELECT * FROM Product ";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				ProductModel product = new ProductModel();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setPromotionalPrice(rs.getInt("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setSelling(rs.getBoolean("isSelling"));
				product.setImage(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "INSERT INTO CartItem(cartId, productId, count, createdAt ) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.setTimestamp(4,cartItem.getCreatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "Delete FROM CartItem WHERE _id = ?";
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
	public void edit(CartItemModel cartItem) {
		String sql = "UPDATE CartItem SET cartId=?, productId=?, count=?, updatedAt=? WHERE _id = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCartId());
			ps.setInt(2, cartItem.getProductId());
			ps.setInt(3, cartItem.getCount());
			ps.setInt(5, cartItem.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void editCount(CartItemModel cartItem) {
		String sql = "UPDATE CartItem SET count=?, updatedAt=? WHERE _id = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCount());
			ps.setTimestamp(2, cartItem.getUpdatedAt());
			ps.setInt(3, cartItem.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
