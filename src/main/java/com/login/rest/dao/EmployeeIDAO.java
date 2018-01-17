package com.login.rest.dao;

import java.util.List;

import com.login.rest.beans.Employee;



public interface EmployeeIDAO {
	 public void saveEmployee(Employee employee);
	 
	  public List<Employee> getAllEmployees();
	  public Employee getEmployeeById(int employeeid);
	  public Employee getEmployee(String name, String password);
	 
	  public void deleteEmployee(int employeeId);
	 
	    public void updateEmployee(Employee employee);
	 
	    

}
