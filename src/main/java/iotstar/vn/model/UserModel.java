package iotstar.vn.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class UserModel implements Serializable {
	private int _id;
	private String firstname;
	private String lastname;
	private String slug;
	private String id_card;
	private String email;
	private String phone;
	private boolean isEmailActive;
	private boolean isPhoneActive;
	private String salt;
	private String hashed_password;
	private String role;
	private String[] addresses;
	private String address;
	private String avatar;
	private String cover;
	private int point;
	private int e_wallet;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private StoreModel store;
	public UserModel() {
		super();
	}
	
	public UserModel(int _id, String firstname, String lastname, String slug, String id_card, String email,
			String phone, boolean isEmailActive, boolean isPhoneActive, String salt, String hashed_password,
			String role, String[] addresses, String address, String avatar, String cover, int point, int e_wallet,
			Timestamp createdAt, Timestamp updatedAt, StoreModel store) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.slug = slug;
		this.id_card = id_card;
		this.email = email;
		this.phone = phone;
		this.isEmailActive = isEmailActive;
		this.isPhoneActive = isPhoneActive;
		this.salt = salt;
		this.hashed_password = hashed_password;
		this.role = role;
		this.addresses = addresses;
		this.address = address;
		this.avatar = avatar;
		this.cover = cover;
		this.point = point;
		this.e_wallet = e_wallet;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.store = store;
	}

	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEmailActive() {
		return isEmailActive;
	}
	public void setEmailActive(boolean isEmailActive) {
		this.isEmailActive = isEmailActive;
	}
	public boolean isPhoneActive() {
		return isPhoneActive;
	}
	public void setPhoneActive(boolean isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHashed_password() {
		return hashed_password;
	}
	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String[] getAddresses() {
		return addresses;
	}
	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	public StoreModel getStore() {
		return store;
	}

	public void setStore(StoreModel store) {
		this.store = store;
	}
	
}