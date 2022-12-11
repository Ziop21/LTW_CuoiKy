package iotstar.vn.model;

import java.sql.Timestamp;

public class VendorRegistrationModel {

	private int _id;
	private int userId;
	private boolean isApproved;
	private UserModel user;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public VendorRegistrationModel() {
		super();
	}
	public VendorRegistrationModel(int _id, int userId, boolean isApproved, UserModel user, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this._id = _id;
		this.userId = userId;
		this.isApproved = isApproved;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
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
