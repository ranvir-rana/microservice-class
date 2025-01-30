package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {


	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/*@GetMapping("/user/servicecall")
	public Mono<String> getUser()
	{
		return userService.getUserById();
	}*/
	
	@GetMapping("/user/servicecall")
	public Flux<User> getUser()
	{
		return userService.getUserById();
	}
}
