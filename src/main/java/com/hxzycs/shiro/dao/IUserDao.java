package com.hxzycs.shiro.dao;

import com.hxzycs.shiro.entity.User;

public interface IUserDao {
	//根据用户名获取用户
	public User getUserByUsername(User user);
}
