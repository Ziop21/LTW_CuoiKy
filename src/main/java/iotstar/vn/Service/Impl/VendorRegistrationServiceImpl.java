package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.IVendorRegistrationService;
import iotstar.vn.dao.IVendorRegistrationDao;
import iotstar.vn.dao.impl.VendorRegistrationDaoImpl;
import iotstar.vn.model.VendorRegistrationModel;

public class VendorRegistrationServiceImpl implements IVendorRegistrationService{

	IVendorRegistrationDao vendorRegisDao = new VendorRegistrationDaoImpl();
	@Override
	public List<VendorRegistrationModel> findAllByUserId(int id) {
		return vendorRegisDao.findAllByUserId(id);
	}


	@Override
	public void updateApprove(int id, int isApproved) {
		vendorRegisDao.updateApprove(id, isApproved);
		
	}

	
	@Override
	public void delete(int id) {
		vendorRegisDao.delete(id);
		
	}

	
	
	@Override
	public void insert(VendorRegistrationModel vendorRegis) {
		vendorRegisDao.insert(vendorRegis);
		
	}

	
	
	@Override
	public int countAll() {
		return vendorRegisDao.countAll();
	}

	
	
	@Override
	public List<VendorRegistrationModel> findAll() {
		return vendorRegisDao.findAll();
	}

	
	
	@Override
	public VendorRegistrationModel getById(int id) {
		return vendorRegisDao.getById(id);
	}


	@Override
	public int countAllByUserId(int id) {
		return vendorRegisDao.countAllByUserId(id);
	}
	
}
