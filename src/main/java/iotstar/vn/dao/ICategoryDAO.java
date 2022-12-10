package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.CategoryModel;
import iotstar.vn.model.ProductModel;

public interface ICategoryDAO {

	List<CategoryModel> searchByName(String keyword);

	void edit(CategoryModel category);

	List<CategoryModel> findAll();

	CategoryModel findByCategoryId(int categoryId);

	void deleteByCategoryId(int catetegoryId);

	void insert(CategoryModel category);

	void deleteBy_id(int _id);

	CategoryModel findBy_id(int _id);

	List<CategoryModel> findAllPage(int indexp, int size);

	int countAll();
	
}
