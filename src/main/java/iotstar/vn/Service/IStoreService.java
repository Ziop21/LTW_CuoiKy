package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.StoreModel;

public interface IStoreService {

	void delete(int id);

	StoreModel getById(int id);

	List<StoreModel> findAll();
}
