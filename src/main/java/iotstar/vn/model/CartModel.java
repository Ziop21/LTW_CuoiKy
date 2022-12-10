package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;

public class CartModel implements Serializable{
	private int _id;
	private int userId;
	private int storeId;
	private Date createdAt;
	private Date updatedAt;
	public CartModel(int _id, int userId, int storeId, Date createdAt, Date updatedAt) {
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
