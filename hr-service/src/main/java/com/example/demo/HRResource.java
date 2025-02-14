package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HRResource {

	public HRResource() {
		// TODO Auto-generated constructor stub
	}
	List<Employee> employees = Arrays.asList(
			new Employee("e1","User","name 1","MedTech"),
			new Employee("e2","User","name 2","Surgery"),
			new Employee("e3","User","name 3","Dental")
			);
	@RequestMapping("/employees")
	public EmployeeList getEmployees()
	{
		EmployeeList employeelist =  new EmployeeList();
		employeelist.setEmployee(employees);
		return employeelist;
	}
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id)
	{
		Employee e =  employees.stream().filter(employee -> id.equals(employee.getId())).findAny().orElse(null);
		return e;
	}
}
