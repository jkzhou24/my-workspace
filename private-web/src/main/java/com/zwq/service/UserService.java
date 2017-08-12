package com.zwq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwq.api.IUserService;
import com.zwq.dao.UserDao;
import com.zwq.entity.UserModel;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserModel getUser(int id) {
		System.out.println(userDao.getUser(id));
		return userDao.getUser(id);
	}

	@Override
	public void saveUser(UserModel user) {
		userDao.saveUser(user);
//		throw new RuntimeException("测试异常事务回滚"); 
	}

}
