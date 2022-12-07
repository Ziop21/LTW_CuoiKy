package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel newCategory);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> findAll();
	List<CategoryModel> search(String catename) ;
	public CategoryModel findById(int id);
}
