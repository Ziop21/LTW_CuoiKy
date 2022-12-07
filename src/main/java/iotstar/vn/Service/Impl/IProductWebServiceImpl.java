package iotstar.vn.Service.Impl;

import java.util.List;
import iotstar.vn.model.ProductModel;
import iotstar.vn.dao.IProductWebDAO;
import iotstar.vn.dao.impl.IProductWebDAOImpl;
import iotstar.vn.Service.IProductWebService;

public class IProductWebServiceImpl implements IProductWebService{
	IProductWebDAO ProductWebDAO = new IProductWebDAOImpl();
	public List<ProductModel> findLastProductList(){
		
		return ProductWebDAO.findLastProductList();
	}
	
	public ProductModel findTopProduct()
	{
		return ProductWebDAO.findTopProduct();
	}
	public List<ProductModel> findTopProductList()
	{
		return ProductWebDAO.findTopProductList();
	}

	@Override
	public ProductModel findById(int id) {
		return ProductWebDAO.findById(id);
	}
	
	@Override
	public List<ProductModel> findAllPage(int indexp) {
		return ProductWebDAO.findAllPage(indexp);
	}
	@Override
	public int countAll() {
		return ProductWebDAO.countAll();
	}
	@Override
	public List<ProductModel> getTop3Product() {
		return ProductWebDAO.getTop3Product();
	}
	public List<ProductModel> getNext3Product(int amount) {
		return ProductWebDAO.getNext3Product(amount);
	}
	
}
