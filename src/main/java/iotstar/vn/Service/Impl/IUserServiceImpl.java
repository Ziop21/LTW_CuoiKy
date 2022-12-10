package iotstar.vn.Service.Impl;

import java.util.List;

import iotstar.vn.Service.IUserService;
import iotstar.vn.dao.IUserDAO;
import iotstar.vn.dao.impl.IUserDAOImpl;
import iotstar.vn.model.UserModel;

public class IUserServiceImpl implements IUserService{
	IUserDAO userDao = new IUserDAOImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.getByEmail(username);
		if (user != null && password.equals(user.getHashed_password())) {
			return user;
		}
		return null;
	}
	
	@Override
	public UserModel getByEmailAndPass(String email, String pass) {
		return userDao.getByEmailAndPass(email, pass);
	}

	@Override
	public UserModel get(int id) {
		return userDao.get(id);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	@Override
	public UserModel getByEmail(String email) {
		return userDao.getByEmail(email);
	}
	@Override
	public void updatePass(String email, String pass) {
		userDao.updatePass(email, pass);
		
	}

	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}
	
}
