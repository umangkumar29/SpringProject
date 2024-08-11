package com.kpit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	//List<Employee> employees = new ArrayList<>();

	EmployeeService employeeService = new EmployeeServiceImpl();
	
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeService.readEmployees();
	}
	
	@PostMapping("employees")
	public String createEmployees(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
		
		/*this cannot make a static reference to the non-static method in employeeService thats why 
		we are making the  object of EmployeeService and then we used the annotation @Autowired*/	
	}
	
	
	@DeleteMapping("employees/{id}")
	public String deleteEmploye(@PathVariable Long id) {
		if(employeeService.deleteEmployee(id))
			return "Delete success";
		return "Not found";
	}
}
