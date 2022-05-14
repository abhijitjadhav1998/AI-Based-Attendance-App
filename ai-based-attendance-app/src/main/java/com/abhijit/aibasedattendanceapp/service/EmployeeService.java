package com.abhijit.aibasedattendanceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhijit.aibasedattendanceapp.entity.Employee;
import com.abhijit.aibasedattendanceapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;

	public void save(Employee employee) {
		repository.save(employee);
	}

}
