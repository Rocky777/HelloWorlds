package com.pfms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pfms.vo.User;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginControllerBean {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		if (user.getUsername().equalsIgnoreCase(user.getPassword())) {
			return "/pages/success.xhtml";
		} else {
			return "/pages/login.xhtml";
		}

	}

	public String back() {
		return "/pages/login.xhtml";

	}

	public void init() {
		user = new User();
	}
}
