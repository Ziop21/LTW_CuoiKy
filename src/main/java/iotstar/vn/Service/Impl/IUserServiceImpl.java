package iotstar.vn.Service.Impl;

import iotstar.vn.Service.IUserService;
import iotstar.vn.dao.IUserDAO;
import iotstar.vn.dao.impl.UserDAOImpl;
import iotstar.vn.model.UserModel;

public class IUserServiceImpl implements IUserService{
	IUserDAO userDao = new UserDAOImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
	return userDao.get(username);
	}
}
