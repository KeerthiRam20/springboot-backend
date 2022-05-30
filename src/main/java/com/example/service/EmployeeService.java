package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.repository.EmployeeRepository;

public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeerepo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees=new ArrayList<Employee>();
		employeerepo.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}
	
	public Employee createEmployee() {
		return employeerepo.save(createEmployee());
	}
	public Employee getEmployeeById(@PathVariable Long id){
		return employeerepo.findById(id).get();
	}
	
	public Optional<Employee> updateEmployee(@PathVariable Long id){
		return employeerepo.findById(id);
	}
	public ResponseEntity<Map<String, Boolean>> deleteEmployee (@PathVariable Long id){
	 employeerepo.deleteById(id);
	return null;
		
	}
}
