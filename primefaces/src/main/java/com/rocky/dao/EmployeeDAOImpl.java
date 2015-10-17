package com.rocky.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rocky.model.Employee;
import com.rocky.vo.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().save(employee);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee authendicate(EmployeeVO employeeVO) {
		Employee employee = null;
		try {
			employee = (Employee) sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Employee where empId='"
									+ employeeVO.getEmpId()
									+ "' and empPwd = '"
									+ employeeVO.getEmpPwd() + "'")
					.uniqueResult();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return employee;
	}
}
