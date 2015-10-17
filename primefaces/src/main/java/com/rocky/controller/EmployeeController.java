package com.rocky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rocky.service.EmployeeService;
import com.rocky.vo.EmployeeVO;

@Component(value = "employeeController")
public class EmployeeController {

	private EmployeeVO employeeVo;

	@Autowired
	private EmployeeService employeeService;

	public void init() {
		employeeVo = new EmployeeVO();
	}

	public String login() {

		if (employeeService.authendicate(employeeVo) != null) {
			return "/pages/success.xhtml";
		} else {
			return "/pages/login.xhtml";
		}
	}

	public String back() {
		return "/pages/login.xhtml";
	}

	public EmployeeVO getEmployeeVo() {
		return employeeVo;
	}

	public void setEmployeeVo(EmployeeVO employeeVo) {
		this.employeeVo = employeeVo;
	}

}
