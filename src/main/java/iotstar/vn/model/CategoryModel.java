package iotstar.vn.model;

import java.io.Serializable;
import java.util.Date;

public class CategoryModel implements Serializable{
	private int _id;
	private String name;
	private String slug;
	private int categoryId;
	private String image;
	private boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;
	public CategoryModel(int _id, String name, String slug, int categoryId, String image, boolean isDeleted,
			Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.slug = slug;
		this.categoryId = categoryId;
		this.image = image;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public CategoryModel() {
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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