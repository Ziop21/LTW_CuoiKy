package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.connection.DBConnection;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.ProductModel;

public interface ICartItemDao {

	void editCount(CartItemModel cartItem);

	void edit(CartItemModel cartItem);

	void delete(int id);

	void insert(CartItemModel cartItem);

	List<CartItemModel> findAllByCartId(int id);

	List<CartItemModel> findAll();

	ProductModel get(int id);

	int countAll();

	List<ProductModel> findAllProduct();

	int countAllByCartId(int cartId);
}
