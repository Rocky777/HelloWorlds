package com.rocky.dao;

import com.rocky.model.Employee;
import com.rocky.vo.EmployeeVO;

public interface EmployeeDAO {

	public boolean saveEmployee(Employee employee);
	
	public Employee authendicate(EmployeeVO employeeVO);
}
