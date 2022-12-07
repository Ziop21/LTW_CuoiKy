package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;

public class ProductModel implements Serializable{
	private int _id;
	private String name;
	private String slug;
	private String description;
	private int price;
	private int promotionalPrice;
	private int quantity;
	private int sold;
	private boolean isActive;
	private boolean isSelling;
	private String[] listImages;
	private int categoryId;
	
	//private int[] styleValueIds;
	private int storeId;
	//private int rating;
	private Date createdAt;
	private Date updatedAt;
	public ProductModel(int _id, String name, String slug, String description, int price, int promotionalPrice,
			int quantity, int sold, boolean isActive, boolean isSelling, String[] listImages, int categoryId,
			Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.listImages = listImages;
		this.categoryId = categoryId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public ProductModel() {
		super();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPromotionalPrice() {
		return promotionalPrice;
	}
	public void setPromotionalPrice(int promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isSelling() {
		return isSelling;
	}
	public void setSelling(boolean isSelling) {
		this.isSelling = isSelling;
	}
	public String[] getListImages() {
		return listImages;
	}
	public void setListImages(String[] listImages) {
		this.listImages = listImages;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
