package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.IStoreService;
import iotstar.vn.dao.IStoreDao;
import iotstar.vn.dao.impl.StoreDaoImpl;
import iotstar.vn.model.StoreModel;

public class StoreServiceImpl implements IStoreService{

	IStoreDao storeDao = new StoreDaoImpl();
	@Override
	public void delete(int id) {
		storeDao.delete(id);		
	}

	@Override
	public StoreModel getById(int id) {
		return storeDao.getById(id);
	}

	@Override
	public List<StoreModel> findAll() {
		return storeDao.findAll();
	}

}
