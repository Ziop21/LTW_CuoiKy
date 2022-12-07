package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.ProductModel;

public interface IProductWebService {
	List<ProductModel> findLastProductList();
	List<ProductModel> findTopProductList();
	ProductModel findTopProduct();
	public ProductModel findById(int id);
	List<ProductModel> findAllPage(int indexp);
	int countAll();
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);
}
