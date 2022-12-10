package iotstar.vn.Service.Impl;

import java.util.List;
import iotstar.vn.model.ProductModel;
import iotstar.vn.dao.IProductDAO;
import iotstar.vn.dao.impl.ProductDAOImpl;
import iotstar.vn.Service.IProductService;

public class IProductServiceImpl implements IProductService{
	IProductDAO ProductWebDAO = new ProductDAOImpl();
	@Override
	public List<ProductModel> findByCategoryIdPage(int categoryId, int indexp, int size){
		return ProductWebDAO.findByCategoryIdPage(categoryId, indexp, size);
	}
	@Override
	public List<ProductModel> findAllPage(int indexp, int size){
		return ProductWebDAO.findAllPage(indexp, size);
	}
	@Override
	public void deleteBy_id(int _id) {
		ProductWebDAO.deleteBy_id(_id);
	}
	@Override
	public void edit(ProductModel product)
	{
		ProductWebDAO.edit(product);
	}
	@Override
	public void insert(ProductModel product) {
		ProductWebDAO.insert(product);
	}
	@Override
	public List<ProductModel> getTop3Product(){
		return ProductWebDAO.getTop3Product();
	}
	@Override
	public int countAll() {
		return ProductWebDAO.countAll();
	}
	@Override
	public ProductModel findBy_Id(int _id) {
		return ProductWebDAO.findBy_Id(_id);
	}
	@Override
	public List<ProductModel> findAll(){
		return ProductWebDAO.findAll();
	}
	@Override
	public List<ProductModel> findByCategoryId(int categoryId){
		return ProductWebDAO.findByCategoryId(categoryId);
	}
	
}
