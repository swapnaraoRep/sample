package com.login.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;

import com.login.rest.beans.Employee;
import com.login.rest.dao.EmployeeIDAO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeIDAO employeeDao; 

	public void setEmployeeDao(EmployeeIDAO employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Transactional
	public void addEmployee(Employee employee) {
		System.out.println("EMPLOYEE serviceIMPL"+employee.getName());
		// TODO Auto-generated method stub
		employeeDao.saveEmployee(employee);


	}


	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return  employeeDao.getAllEmployees();
	}

	public Employee getEmployee(int empid) {
		System.out.println("in services GET EMPLOYEE"+empid);
        return employeeDao.getEmployeeById(empid);
			
	}


	public Employee getEmployee(String name, String password) {
		System.out.println("in services GET EMPLOYEE"+name+""+password);
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(name, password);
	}


	@Override
	@Transactional
	public Employee getEmployeeById(int employeeid) {
		// TODO Auto-generated method stub
		System.out.println("in services GET EMPLOYEE"+employeeid);
        return employeeDao.getEmployeeById(employeeid);
	}


	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employeeId);
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDao.updateEmployee(employee);
	}



}
