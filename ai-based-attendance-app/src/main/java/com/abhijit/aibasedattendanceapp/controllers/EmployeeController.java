package com.abhijit.aibasedattendanceapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhijit.aibasedattendanceapp.entity.Employee;
import com.abhijit.aibasedattendanceapp.entity.Photo;
import com.abhijit.aibasedattendanceapp.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping("/addemployee")
	public ModelAndView userDashboard() {
		Employee employee = new Employee(0,"Abhijit");
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(new Photo(0,"photosfolder"));
		photos.add(new Photo(0,"photosfolder/2"));
		photos.add(new Photo(0,"photosfolder/3"));
		employee.setPhotoId(photos);
		service.save(employee);
		
		return new ModelAndView("addemployee", "employee", employee);
	}

}
