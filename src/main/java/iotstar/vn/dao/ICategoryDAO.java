package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.CategoryModel;

public interface ICategoryDAO {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> findAll();
	List<CategoryModel> search(String keyword);
	public CategoryModel findById(int id);
}
