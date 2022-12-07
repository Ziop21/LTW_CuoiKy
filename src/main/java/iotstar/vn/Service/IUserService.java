package iotstar.vn.Service;

import iotstar.vn.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel get(String username);
}
