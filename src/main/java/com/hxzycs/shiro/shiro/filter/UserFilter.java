package com.hxzycs.shiro.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class UserFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入自定义filter类的登录成功的操作>>onLoginSuccess方法");
		System.out.println("搞事情");
		/**
		 * 这里可以根据你的用户名查找其角色,和其角色的权限的操作来决定页面显示菜单栏和功能选项
		 * */
		//subject.logout();
		System.out.println("=============================================================================================");
		return super.onLoginSuccess(token, subject, request, response);
	}
}
