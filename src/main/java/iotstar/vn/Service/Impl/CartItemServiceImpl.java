package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.ICartItemService;
import iotstar.vn.dao.ICartItemDao;
import iotstar.vn.dao.impl.CartItemDaoImpl;
import iotstar.vn.model.CartItemModel;
import iotstar.vn.model.ProductModel;

public class CartItemServiceImpl implements ICartItemService{
	ICartItemDao cartItemDao = new CartItemDaoImpl();
	public void insert(CartItemModel cartItem) {
		cartItemDao.insert(cartItem);
	}
	@Override
	public void editCount(CartItemModel cartItem) {
		cartItemDao.editCount(cartItem);
		
	}
	@Override
	public void edit(CartItemModel cartItem) {
		cartItemDao.edit(cartItem);
		
	}
	@Override
	public void delete(int id) {
		cartItemDao.delete(id);
		
	}
	@Override
	public List<CartItemModel> findAllByCartId(int id) {
		return cartItemDao.findAllByCartId(id);
	}
	@Override
	public List<CartItemModel> findAll() {
		return cartItemDao.findAll();
	}
	@Override
	public ProductModel get(int id) {
		return cartItemDao.get(id);
	}
	@Override
	public int countAll() {
		return cartItemDao.countAll();
	}
	@Override
	public List<ProductModel> findAllProduct() {
		return cartItemDao.findAllProduct();
	}
	@Override
	public int countAllByCartId(int cartId) {
		return cartItemDao.countAllByCartId(cartId);
	}
	
	
	
}
