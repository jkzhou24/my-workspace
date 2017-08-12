package com.zwq.dao;

import com.zwq.entity.UserModel;

public interface UserDao {
	
	UserModel getUser(int id);
	
	void saveUser(UserModel user);
	
}
