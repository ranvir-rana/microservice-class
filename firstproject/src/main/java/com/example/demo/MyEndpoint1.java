package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyEndpoint1 {

	public MyEndpoint1() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/mypage")
	public String myString()
	{
		return "First Microservice Example";
		
	}
	
	@RequestMapping("/second")
	public String sayHello(@RequestParam String name)
	{
		
		return "Welcome : " + name;
	}
	
	@RequestMapping(path="/pathvarexample/{name}")
	public String sayHello2(@PathVariable String name)
	{
		
		return "Path Defination : " + name;
	}
	
	@GetMapping(path="/secondSampleBean")
	public SecondSampleBean secondBean()
	{
		
		return new SecondSampleBean("for oracle");
	}
}