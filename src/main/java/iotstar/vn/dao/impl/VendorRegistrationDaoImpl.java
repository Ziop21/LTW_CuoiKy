package iotstar.vn.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IVendorRegistrationDao;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.VendorRegistrationModel;

public class VendorRegistrationDaoImpl extends DBConnection implements IVendorRegistrationDao{

	@Override
	public VendorRegistrationModel getById(int id)
	{
		String sql = "SELECT * FROM VendorRegistration Where _id = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				VendorRegistrationModel vendorRegis = new VendorRegistrationModel();
				vendorRegis.set_id(rs.getInt("_id"));
				vendorRegis.setUserId(rs.getInt("userId"));
				vendorRegis.setApproved(rs.getBoolean("isApproved"));
				vendorRegis.setCreatedAt(rs.getTimestamp("createdAt"));
				vendorRegis.setUpdatedAt(rs.getTimestamp("updatedAt"));
				return vendorRegis;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<VendorRegistrationModel> findAllByUserId(int id){
		List<VendorRegistrationModel> vendorRegiss = new ArrayList<VendorRegistrationModel>();
		String sql = "SELECT * FROM VendorRegistration Where userId = ?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VendorRegistrationModel vendorRegis = new VendorRegistrationModel();
				vendorRegis.set_id(rs.getInt("_id"));
				vendorRegis.setUserId(rs.getInt("userId"));
				vendorRegis.setApproved(rs.getBoolean("isApproved"));
				vendorRegis.setCreatedAt(rs.getTimestamp("createdAt"));
				vendorRegis.setUpdatedAt(rs.getTimestamp("updatedAt"));
				vendorRegiss.add(vendorRegis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendorRegiss;
		}
	@Override
	public List<VendorRegistrationModel> findAll(){
		List<VendorRegistrationModel> vendorRegiss = new ArrayList<VendorRegistrationModel>();
		String sql = "SELECT * FROM VendorRegistration";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				VendorRegistrationModel vendorRegis = new VendorRegistrationModel();
				vendorRegis.set_id(rs.getInt("_id"));
				vendorRegis.setUserId(rs.getInt("userId"));
				vendorRegis.setApproved(rs.getBoolean("isApproved"));
				vendorRegis.setCreatedAt(rs.getTimestamp("createdAt"));
				vendorRegis.setUpdatedAt(rs.getTimestamp("updatedAt"));
				vendorRegiss.add(vendorRegis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendorRegiss;
		}
	@Override
	public int countAll() {
		String sql = "select count(*) from VendorRegistration";
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
	public int countAllByUserId(int id) {
		String sql = "select count(*) from VendorRegistration Where userId=?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
	@Override
	public void insert(VendorRegistrationModel vendorRegis) {
		String sql = "INSERT INTO VendorRegistration(userId, isApproved, createdAt, updatedAt ) VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vendorRegis.getUserId());
			ps.setBoolean(2, vendorRegis.isApproved());
			ps.setTimestamp(3, vendorRegis.getCreatedAt());
			ps.setTimestamp(4,vendorRegis.getUpdatedAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "Delete FROM VendorRegistration WHERE _id = ?";
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
	public void updateApprove(int id, int isApproved) {
		String sql = "UPDATE VendorRegistration SET isApproved=? WHERE _id = ? ";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, isApproved);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
