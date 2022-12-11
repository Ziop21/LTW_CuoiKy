package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.StoreModel;

public interface IStoreDao {

	void delete(int id);

	StoreModel getById(int id);

	List<StoreModel> findAll();

	StoreModel getByOwnerId(int id);

}
