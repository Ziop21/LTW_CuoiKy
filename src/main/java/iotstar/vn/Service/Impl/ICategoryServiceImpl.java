package iotstar.vn.Service.Impl;

import java.io.File;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.ICategoryDAO;
import iotstar.vn.dao.impl.ICategoryDAOImpl;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.Service.ICategoryService;

public class ICategoryServiceImpl extends DBConnection implements ICategoryService{
	//
	ICategoryDAO categoryDAO = new ICategoryDAOImpl();
	
	@Override
	public void insert(CategoryModel category) {
		categoryDAO.insert(category);
	}
	@Override
	public void edit(CategoryModel newCategory) {
		CategoryModel oldCategory = categoryDAO.get(newCategory.getCateid());
		oldCategory.setCatename(newCategory.getCatename());
		if (newCategory.getImages() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getImages();
			final String dir = "C:\\UTEXLMS\\Nam3_2022_2023\\LTW\\upload";
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
			file.delete();
		}
		oldCategory.setImages(newCategory.getImages());
		}
		categoryDAO.edit(oldCategory);
		}
	@Override
	public void delete(int id) {
		categoryDAO.delete(id);
	}
	@Override
	public CategoryModel get(int id) {
		return categoryDAO.get(id);
	}
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}
	
	@Override
	public CategoryModel get(String name) {
		return categoryDAO.get(name);
	}

	@Override
	public List<CategoryModel> search(String catename) {
		return categoryDAO.search(catename);
	} 
	@Override
	public CategoryModel findById(int id) {
		return categoryDAO.findById(id);
	}
}
