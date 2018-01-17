package com.login.rest.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.login.rest.beans.Login;
import com.login.rest.service.EmployeeService;
import com.login.rest.beans.Employee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/requestLogin")
	public ModelAndView DisplayLoginForm(
			@ModelAttribute("emp") Employee employee) {
		return new ModelAndView("Login");
	}

	@RequestMapping("/empform")
	public ModelAndView DisplayEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return new ModelAndView("empform");
	}
	    

	@RequestMapping(value = "/userLogin/{name}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployee(@PathVariable String name,
			@PathVariable String password) {
		System.out.println("Controler" + name);

		return employeeService.getEmployee(name, password);

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		System.out.println("Add emplyee to id"+employee.getId());

	}

	@RequestMapping(value = "/getEmployeeId/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getAllEmployee() {
		return (List) employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/updateEmployee/{employeeId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteEmployeeById(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
}
