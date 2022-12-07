package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderModel implements Serializable{
	private int _id;
	private int userId;
	private int storedId;
	//private int deliveryId;
	//private int commissionId
	private String address;
	private String phone;
	private String status;
	private boolean isPaidBefore;
	private int amountFromUser;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGD;
	private Date createdAt;
	private Date updatedAt;
	public OrderModel(int _id, int userId, int storedId, String address, String phone, String status,
			boolean isPaidBefore, int amountFromUser, int amountFromStore, int amountToStore, int amountToGD,
			Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storedId = storedId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public OrderModel() {
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
	public int getStoredId() {
		return storedId;
	}
	public void setStoredId(int storedId) {
		this.storedId = storedId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isPaidBefore() {
		return isPaidBefore;
	}
	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}
	public int getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(int amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public int getAmountFromStore() {
		return amountFromStore;
	}
	public void setAmountFromStore(int amountFromStore) {
		this.amountFromStore = amountFromStore;
	}
	public int getAmountToStore() {
		return amountToStore;
	}
	public void setAmountToStore(int amountToStore) {
		this.amountToStore = amountToStore;
	}
	public int getAmountToGD() {
		return amountToGD;
	}
	public void setAmountToGD(int amountToGD) {
		this.amountToGD = amountToGD;
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
