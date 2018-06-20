package com.service;

import java.util.ArrayList;

import com.bean.Employee;
import com.dao.EmployeeDAO;

public class EmployeeService {
	EmployeeDAO dao=new EmployeeDAO();
	public ArrayList<Employee> listEmployees() {
		return dao.listEmployees();
	}
	
	public boolean insertEmployee(Employee emp) {
		return dao.insertEmployee(emp);
	}

	public Employee deleteEmployee(int emp) {
		return dao.deleteEmployee(emp);
	}

	public boolean updateEmployee(Employee emp) {
		return dao.updateEmployee(emp);
	}
	
	public Employee fetchEmployee(int emp) {
		return dao.fetchEmployee(emp);
	}
}
