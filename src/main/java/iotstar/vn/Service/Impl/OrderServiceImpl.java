package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.IOrderService;
import iotstar.vn.dao.IOrderDao;
import iotstar.vn.dao.impl.OrderDaoImpl;
import iotstar.vn.model.OrderItemModel;
import iotstar.vn.model.OrderModel;

public class OrderServiceImpl implements IOrderService{
	IOrderDao orderDao = new OrderDaoImpl();
	@Override
	public void taoOrderItem(OrderItemModel orderItem) {
		orderDao.taoOrderItem(orderItem);
		
	}

	@Override
	public void delete(int id) {
		orderDao.delete(id);
		
	}

	@Override
	public void insert(OrderModel order) {
		orderDao.insert(order);
		
	}

	@Override
	public OrderModel getOrderNew() {
		return orderDao.getOrderNew();
	}

	@Override
	public void updateSoldProduct(int quantity, int sold, int id) {
		orderDao.updateSoldProduct(quantity, sold, id);
		
	}

	@Override
	public OrderModel getById(int id) {
		return orderDao.getById(id);
	}

	@Override
	public List<OrderModel> findAll() {
		return orderDao.findAll()	;
	}

	@Override
	public void updateStatus(int id, String status) {
		orderDao.updateStatus(id, status);
		
	}

	@Override
	public List<OrderModel> findAllByUserId(int userId) {
		return orderDao.findAllByUserId(userId);
	}

	@Override
	public int TinhDoanhThuTheoThang(int month) {
		return orderDao.TinhDoanhThuTheoThang(month);
	}

	@Override
	public int SoLuongBanTheoThang(int month) {
		return orderDao.SoLuongBanTheoThang(month);
	}
	

}
