package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.UserModel;

public interface IUserDAO {
	void insert(UserModel user);
	//void edit(CategoryModel category);
	void delete(int id);
	UserModel get(String username);
	UserModel get(int id);
	//CategoryModel get(String name);
	List<UserModel> findAll();
	//List<CategoryModel> search(String keyword);
}
