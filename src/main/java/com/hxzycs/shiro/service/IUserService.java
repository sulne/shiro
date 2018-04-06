package com.hxzycs.shiro.service;

import com.hxzycs.shiro.entity.User;

public interface IUserService {
	//根据用户名获取用户
	public User getUserByUsername(User user);
	public void deleteUserByUsername(String username);
}
