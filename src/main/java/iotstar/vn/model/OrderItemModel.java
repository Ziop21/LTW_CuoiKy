package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderItemModel implements Serializable{
	private int _id;
	private int orderId;
	private int productId;
	//private int styleValueIds;
	private int count;
	private Date createdAt;
	private Date updatedAt;
	public OrderItemModel(int _id, int orderId, int productId, int count, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.productId = productId;
		this.count = count;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public OrderItemModel() {
		super();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
