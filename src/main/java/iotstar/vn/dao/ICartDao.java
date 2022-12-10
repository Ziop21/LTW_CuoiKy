package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.CartModel;

public interface ICartDao {

	CartModel get(int id);

	void delete(int id);

	void insert(CartModel cart);

	void edit(CartModel cart);

	List<CartModel> findAll();

}
