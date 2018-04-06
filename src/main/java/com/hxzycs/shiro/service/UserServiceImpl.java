package com.hxzycs.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzycs.shiro.dao.IUserDao;
import com.hxzycs.shiro.entity.User;
@Service("userService")
public class UserServiceImpl implements IUserService{
	private IUserDao userDao;
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	//根据用户名获取用户
	public User getUserByUsername(User user) {
		return userDao.getUserByUsername(user);
	}

	public void deleteUserByUsername(String username) {
		System.out.println("Delete User");
	}
}
