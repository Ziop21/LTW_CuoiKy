package iotstar.vn.dao;
import java.util.List;

import iotstar.vn.model.ProductModel;
public interface IProductDAO {

	void deleteBy_id(int _id);

	void edit(ProductModel product);

	void insert(ProductModel product);

	List<ProductModel> getTop3Product();

	int countAll();

	ProductModel findBy_Id(int _id);

	List<ProductModel> findAll();

	List<ProductModel> findByCategoryId(int categoryId);

	List<ProductModel> findAllPage(int indexp, int size);

	List<ProductModel> findByCategoryIdPage(int categoryId, int indexp, int size);

	List<ProductModel> search(String keyword);

	

	


}
