package com.hxzycs.shiro.entity;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7331487125497200126L;
	private int userId;//用户id
	private String username;//用户姓名
	private String password;//密码
	private String passwordSalt;//加密言
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[%d,%s,%s,%s]", userId, username,password,passwordSalt);
	}
}
