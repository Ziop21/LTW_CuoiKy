package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.dao.IVendorRegistrationDao;
import iotstar.vn.dao.impl.VendorRegistrationDaoImpl;
import iotstar.vn.model.VendorRegistrationModel;

public interface IVendorRegistrationService {

	VendorRegistrationModel getById(int id);

	List<VendorRegistrationModel> findAll();

	int countAll();

	void insert(VendorRegistrationModel vendorRegis);

	void delete(int id);

	void updateApprove(int id, int isApproved);

	List<VendorRegistrationModel> findAllByUserId(int id);
	int countAllByUserId(int id);
}
