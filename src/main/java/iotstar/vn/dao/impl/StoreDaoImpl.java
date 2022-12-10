package iotstar.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.IStoreDao;
import iotstar.vn.model.StoreModel;

public class StoreDaoImpl extends DBConnection implements IStoreDao{

	@Override
	public List<StoreModel> findAll(){
		List<StoreModel> stores = new ArrayList<StoreModel>();
		String sql = "SELECT * FROM [dbo].[Store]";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.set_id(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setIsActive(rs.getBoolean("isActive"));
				store.setIsOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("createdAt"));
				store.setCreatedAt(rs.getTimestamp("updatedAt"));
				store.setCreatedAt(rs.getTimestamp("createdAt"));
				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
		}
	@Override
	public StoreModel getById(int id){
		String sql = "SELECT * FROM [dbo].[Store] WHERE _id=?";
		try {
			Connection conn = super.getConnectionW();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreModel store = new StoreModel();
				store.set_id(rs.getInt("_id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setIsActive(rs.getBoolean("isActive"));
				store.setIsOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setCover(rs.getString("createdAt"));
				store.setCreatedAt(rs.getTimestamp("updatedAt"));
				store.setCreatedAt(rs.getTimestamp("createdAt"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	@Override
	public void delete(int id) {
		String sql = "Delete FROM [dbo].[Store] WHERE _id = ?";
		try {
			Connection con = super.getConnectionW();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
