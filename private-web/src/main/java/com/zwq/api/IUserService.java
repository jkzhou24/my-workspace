package com.zwq.api;

import com.zwq.entity.UserModel;

public interface IUserService {
	
	UserModel getUser(int id);
	
	void saveUser(UserModel user);
	
}
