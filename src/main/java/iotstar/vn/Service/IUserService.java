package iotstar.vn.Service;

import java.util.List;

import iotstar.vn.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel getByEmailAndPass(String email, String pass);
	UserModel get(int id);
	void delete(int id);
	void insert(UserModel user);
	UserModel getByEmail(String email);
	void updatePass(String email, String pass);
	List<UserModel> findAll();
}
