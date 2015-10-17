package com.rocky.service;

import com.rocky.model.Employee;
import com.rocky.vo.EmployeeVO;

public interface EmployeeService {

	public boolean saveEmployee(Employee employee);
	
	public Employee authendicate(EmployeeVO employeeVO);
}
