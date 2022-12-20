package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.OrderItemModel;
import iotstar.vn.model.OrderModel;

public interface IOrderService {

	void taoOrderItem(OrderItemModel orderItem);

	void delete(int id);

	void insert(OrderModel order);
	
	OrderModel getOrderNew();
	void updateSoldProduct(int quantity, int sold, int id);
	OrderModel getById(int id);

	List<OrderModel> findAll();
	void updateStatus(int id, String status);
	List<OrderModel> findAllByUserId(int userId);
	int TinhDoanhThuTheoThang(int month);

	int SoLuongBanTheoThang(int month);
}
