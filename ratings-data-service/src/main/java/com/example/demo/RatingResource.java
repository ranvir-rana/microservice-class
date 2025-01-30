package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	public RatingResource() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/movies/{movieId}")
	public Rating getMoviewRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId,5);
		
	}
	
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
		
	}
	
	
}
