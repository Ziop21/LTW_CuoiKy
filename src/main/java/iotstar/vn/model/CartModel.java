package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CartModel implements Serializable{
	private int _id;
	private int userId;
	private int storeId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public CartModel(int _id, int userId, int storeId, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storeId = storeId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public CartModel() {
		super();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
