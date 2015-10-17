package com.rocky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocky.dao.EmployeeDAO;
import com.rocky.model.Employee;
import com.rocky.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional(readOnly = false)
	public boolean saveEmployee(Employee employee) {
		return employeeDAO.saveEmployee(employee);
	}

	@Transactional(readOnly = true)
	public Employee authendicate(EmployeeVO employeeVO) {
		return employeeDAO.authendicate(employeeVO);
	}

}
