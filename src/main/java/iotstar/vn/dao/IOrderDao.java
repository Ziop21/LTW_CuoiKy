package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.OrderItemModel;
import iotstar.vn.model.OrderModel;

public interface IOrderDao {

	void taoOrderItem(OrderItemModel orderItem);

	void delete(int id);

	void insert(OrderModel order);

	OrderModel getOrderNew();

	void updateSoldProduct(int quantity, int sold, int id);

	OrderModel getById(int id);

	List<OrderModel> findAll();

	void updateStatus(int id, String status);

	List<OrderModel> findAllByUserId(int userId);

}
