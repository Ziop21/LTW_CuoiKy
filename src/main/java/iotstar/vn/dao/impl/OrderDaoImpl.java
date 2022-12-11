package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IOrderDao;
import iotstar.vn.model.CartModel;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.OrderItemModel;
import iotstar.vn.model.OrderModel;
import iotstar.vn.model.ProductModel;

public class OrderDaoImpl extends DBConnection implements IOrderDao{

	@Override
	public void insert(OrderModel order)
	{
		String sql = "INSERT INTO [dbo].[Order]([userId], [cartId], [address], [phone], [status], [isPaidBefore], [amountFromUser], [createdAt] ) VALUES (?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getCartId());
			ps.setString(3, order.getAddress());
			ps.setString(4, order.getPhone());
			ps.setString(5, order.getStatus());
			ps.setBoolean(6, order.isPaidBefore());
			ps.setFloat(7, order.getAmountFromUser());
			ps.setTimestamp(8,order.getCreatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "Delete FROM Order WHERE _id = ?";
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
	public void taoOrderItem(OrderItemModel orderItem)
	{
		String sql = "INSERT INTO OrderItem(orderId, productId, count, createdAt) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderItem.getOrderId());
			ps.setInt(2, orderItem.getProductId());
			ps.setInt(3, orderItem.getCount());
			ps.setTimestamp(4,orderItem.getCreatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public OrderModel getOrderNew() {
		String sql = "SELECT TOP(1) * FROM [dbo].[Order] ORDER BY _id DESC";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				OrderModel order = new OrderModel();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setCartId(rs.getInt("cartId"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateSoldProduct(int quantity, int sold, int id)
	{
		String sql = "UPDATE Product SET sold=?, quantity=? WHERE _id = ? ";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sold);
			ps.setInt(2, quantity);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateStatus(int id,String status) {
		String sql = "UPDATE [dbo].[Order] SET status=? WHERE _id = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<OrderModel> findAll(){
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [dbo].[Order]";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setCartId(rs.getInt("cartId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setCreatedAt(rs.getTimestamp("createdAt"));
				order.setUpdatedAt(rs.getTimestamp("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
		}
	@Override
	public List<OrderModel> findAllByUserId(int userId){
		List<OrderModel> orders = new ArrayList<OrderModel>();
		String sql = "SELECT * FROM [dbo].[Order] WHERE _id=?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setCartId(rs.getInt("cartId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setCreatedAt(rs.getTimestamp("createdAt"));
				order.setUpdatedAt(rs.getTimestamp("updatedAt"));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
		}
	@Override
	public OrderModel getById(int id){
		String sql = "SELECT * FROM [dbo].[Order] WHERE _id=?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderModel order = new OrderModel();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setCartId(rs.getInt("cartId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getFloat("amountFromUser"));
				order.setCreatedAt(rs.getTimestamp("createdAt"));
				order.setUpdatedAt(rs.getTimestamp("updatedAt"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
}
