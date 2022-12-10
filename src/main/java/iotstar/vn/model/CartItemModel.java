package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class CartItemModel implements Serializable{
	private int _id;
	private int cartId;
	private int productId;
	//private int styleValueIds
	private int count;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public CartItemModel(int _id, int cartId, int productId, int count, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this._id = _id;
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public CartItemModel() {
		super();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
