package iotstar.vn.dao;
import java.util.List;

import iotstar.vn.model.ProductModel;
public interface IProductWebDAO {
	List<ProductModel> findAll();
	List<ProductModel> findLastProductList();
	List<ProductModel> findTopProductList();
	ProductModel findTopProduct();
	ProductModel findById(int id);
	List<ProductModel> findAllPage(int indexp);
	int countAll();
	List<ProductModel> getTop3Product();
	List<ProductModel> getNext3Product(int amount);
}
