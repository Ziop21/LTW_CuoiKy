package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class StoreModel implements Serializable{
	private int _id;
	private String name;
	private String bio;
	private String slug;
	private int ownerId;
	private int[] staffIds;
	private Boolean isActive;
	private Boolean isOpen;
	private String avatar;
	private String cover;
	private String[] featured_images;
	//private int commissionId;
	private int point;
	//private int rating;
	private int e_wallet;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private UserModel user;
	
	
	public StoreModel(int _id, String name, String bio, String slug, int ownerId, int[] staffIds, Boolean isActive,
			Boolean isOpen, String avatar, String cover, String[] featured_images, int point, int e_wallet,
			Timestamp createdAt, Timestamp updatedAt, UserModel user) {
		super();
		this._id = _id;
		this.name = name;
		this.bio = bio;
		this.slug = slug;
		this.ownerId = ownerId;
		this.staffIds = staffIds;
		this.isActive = isActive;
		this.isOpen = isOpen;
		this.avatar = avatar;
		this.cover = cover;
		this.featured_images = featured_images;
		this.point = point;
		this.e_wallet = e_wallet;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	public StoreModel() {
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
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int[] getStaffIds() {
		return staffIds;
	}
	public void setStaffIds(int[] staffIds) {
		this.staffIds = staffIds;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String[] getFeatured_images() {
		return featured_images;
	}
	public void setFeatured_images(String[] featured_images) {
		this.featured_images = featured_images;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getE_wallet() {
		return e_wallet;
	}
	public void setE_wallet(int e_wallet) {
		this.e_wallet = e_wallet;
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
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}

	
}
