package com.kpit;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kpit.repo.EmployeeEntity;
import com.kpit.repo.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	List<Employee> employees = new ArrayList<>();
	
	@Override
	public String createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		
		employeeRepository.save(employeeEntity);
		
		return "Saved Successfully";
	}

	@Override
	public List<Employee> readEmployees() {
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		List<Employee> employees = new ArrayList<>();
		
		for(EmployeeEntity employeeEntity: employeeList) {
			Employee emp = new Employee(); 
			emp.setName(employeeEntity.getName());
			emp.setEmail(employeeEntity.getEmail());
			employees.add(emp);
		}
		return employees;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		//employees.remove(id);
		return true;
	}

}
