package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	public UserDAOService() {
		// TODO Auto-generated constructor stub
	}
	private static List<User> users =  new ArrayList<>();
	private static int usersCount = 3;
	static
	{
		users.add(new User(1,"User name 1",new Date()));
		users.add(new User(2,"User name 2",new Date()));
		users.add(new User(3,"User name 3",new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
}
