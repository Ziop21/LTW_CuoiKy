package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> searchByName(String keyword);

	void edit(CategoryModel category);

	List<CategoryModel> findAll();

	CategoryModel findByCategoryId(int categoryId);

	void deleteByCategoryId(int catetegoryId);

	void insert(CategoryModel category);
	
	CategoryModel findBy_id(int _id);

	void update(CategoryModel category);
	
	void deleteBy_id(int _id);
	
	List<CategoryModel> findAllPage(int indexp, int size);

	int countAll();
}
