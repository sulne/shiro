package com.hxzycs.shiro.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzycs.shiro.entity.User;
import com.hxzycs.shiro.service.IUserService;

@Controller
public class UserController {
	public IUserService userService;
	
	@Resource(name="userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	/**
	 * 方法一:基于表单验证
	 * */
	@RequestMapping(value="index")
	public String index() {
		System.out.println("hello index");
		return "index";
	}

	@RequestMapping(value="login")
	public String login(HttpServletRequest request,Model model) {
		System.out.println("hello login");
		//shiro会将异常的类名添加进request的shiroLoginFailure里
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exceptionClassName >>"+exceptionClassName);
		model.addAttribute("error", exceptionClassName);
		return "login";
	}
	
	/**
	 * 方法二:手动验证
	 * */
	@RequestMapping(value="login2")
	public String login2() {
		return "login2";
	}
	@RequestMapping(value="doLogin")
	public String doLogin(User user) {
		System.out.println("hello doLogin");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
		subject.login(token);
		return "index";
	}
	
	//需要授权add才能访问
	@RequiresPermissions("add")
	@RequestMapping(value="hello")
	public String hello(User user) {
		System.out.println("MOTO");
		return "index";
	}
	
	//需要角色是admin才能访问
	@RequiresRoles("admin")
	@RequestMapping(value="delete")
	public String deleteUserByUsername(String userName) {
		userService.deleteUserByUsername(userName);
		return "index";
	}
}
