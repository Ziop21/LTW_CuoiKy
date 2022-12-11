package iotstar.vn.dao;

import java.util.List;

import iotstar.vn.model.VendorRegistrationModel;

public interface IVendorRegistrationDao {

	void updateApprove(int id, int isApproved);

	void delete(int id);

	void insert(VendorRegistrationModel vendorRegis);

	int countAll();

	List<VendorRegistrationModel> findAll();

	VendorRegistrationModel getById(int id);

	List<VendorRegistrationModel> findAllByUserId(int id);

	int countAllByUserId(int id);

}
