package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.ICartService;
import iotstar.vn.dao.ICartDao;
import iotstar.vn.dao.impl.CartDaoImpl;
import iotstar.vn.model.CartModel;

public class CartServiceImpl implements ICartService{

	@Override
	public void edit(CartModel cart) {
		cartDao.edit(cart);
		
	}

	@Override
	public List<CartModel> findAll() {
		return cartDao.findAll();
	}

	ICartDao cartDao  = new CartDaoImpl();
	@Override
	public CartModel get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
		
	}

	@Override
	public void insert(CartModel cart) {
		cartDao.insert(cart);
		
	}

	
}
