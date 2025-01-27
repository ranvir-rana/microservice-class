package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndpoint2 {

	public MyEndpoint2() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User> retriveAll()
	{
		return service.findAll();
	}
}
