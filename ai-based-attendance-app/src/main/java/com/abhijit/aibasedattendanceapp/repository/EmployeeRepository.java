package com.abhijit.aibasedattendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhijit.aibasedattendanceapp.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
