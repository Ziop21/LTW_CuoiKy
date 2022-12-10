package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ProductModel implements Serializable{
	private int _id;
	private String name;
	private String slug;
	private String description;
	private float price;
	private float promotionalPrice;
	private int quantity;
	private int sold;
	private boolean isActive;
	private boolean isSelling;
	private String[] listImages;
	private int categoryId;
	
	//private int[] styleValueIds;
	private int storeId;
	private int rating;
	private Timestamp createdAt;
	private Timestamp updatedAt;	
	private CategoryModel category;
	
	
	public ProductModel(int _id, String name, String slug, String description, float price, float promotionalPrice,
			int quantity, int sold, boolean isActive, boolean isSelling, String[] listImages, int categoryId,
			int storeId, int rating, Timestamp createdAt, Timestamp updatedAt, CategoryModel category) {
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
		this.storeId = storeId;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPromotionalPrice() {
		return promotionalPrice;
	}
	public void setPromotionalPrice(float promotionalPrice) {
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
	public boolean getIsActive() {	
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive == 0 ? false : true;
	}
	public boolean getIsSelling() {
		return isSelling;
	}
	public void setIsSelling(int isSelling) {
		this.isSelling = isSelling == 0 ? false : true;
	}
	public String[] getListImages() {
		return listImages;
	}
	public void setListImages(String listImages) {
		if (listImages == null)
			this.listImages = null;
		else
		{
			String[] result = listImages.split(",");
			this.listImages = result;
		}
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
}
