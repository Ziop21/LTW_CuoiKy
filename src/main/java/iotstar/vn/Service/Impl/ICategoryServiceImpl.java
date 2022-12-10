package iotstar.vn.Service.Impl;

import java.io.File;
import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.dao.ICategoryDAO;
import iotstar.vn.dao.impl.CategoryDAOImpl;
import iotstar.vn.model.CategoryModel;
import iotstar.vn.Service.ICategoryService;

public class ICategoryServiceImpl extends DBConnection implements ICategoryService{
	//
	ICategoryDAO categoryDAO = new CategoryDAOImpl();
	
	
//	@Override
//	public void edit(CategoryModel newCategory) {
//		CategoryModel oldCategory = categoryDAO.get(newCategory.getCateid());
//		oldCategory.setCatename(newCategory.getCatename());
//		if (newCategory.getImages() != null) {
//			// XOA ANH CU DI
//			String fileName = oldCategory.getImages();
//			final String dir = "C:\\UTEXLMS\\Nam3_2022_2023\\LTW\\upload";
//			File file = new File(dir + "/category" + fileName);
//			if (file.exists()) {
//			file.delete();
//		}
//		oldCategory.setImages(newCategory.getImages());
//		}
//		categoryDAO.edit(oldCategory);
//		}
	@Override
	public int countAll(){
		return categoryDAO.countAll();
	}
	
	@Override
	public List<CategoryModel> findAllPage(int indexp, int size){
		return categoryDAO.findAllPage(indexp, size);
	}
	
	@Override
	public List<CategoryModel> searchByName(String keyword){
		return categoryDAO.searchByName(keyword);
	}

	@Override
	public void edit(CategoryModel category){
		categoryDAO.edit(category);
	}
	@Override
	public void update(CategoryModel category){
		categoryDAO.edit(category);
	}

	@Override
	public List<CategoryModel> findAll(){
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findByCategoryId(int categoryId) {
		return categoryDAO.findByCategoryId(categoryId);
	}

	@Override
	public void deleteByCategoryId(int catetegoryId) {
		categoryDAO.deleteByCategoryId(catetegoryId);
	}
	@Override
	public void deleteBy_id(int _id) {
		categoryDAO.deleteBy_id(_id);
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDAO.insert(category);
	}
	
	@Override
	public CategoryModel findBy_id(int _id) {
		return categoryDAO.findBy_id(_id);
	}
}
