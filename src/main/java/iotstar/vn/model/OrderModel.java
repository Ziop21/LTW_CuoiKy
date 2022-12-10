package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderModel implements Serializable{
	private int _id;
	private int userId;
	private int storedId;
	private int cartId;
	//private int deliveryId;
	//private int commissionId
	private String address;
	private String phone;
	private String status;
	private Boolean isPaidBefore;
	private float amountFromUser;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGD;
	private Timestamp createdAt;
	private Timestamp updatedAt;	
	public OrderModel(int _id, int userId, int storedId, int cartId, String address, String phone, String status,
			Boolean isPaidBefore, float amountFromUser, int amountFromStore, int amountToStore, int amountToGD,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storedId = storedId;
		this.cartId = cartId;
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

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public float getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(float amountFromUser) {
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
