package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	public MovieResource() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId)
	{
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=en-US",MovieSummary.class);
		System.out.println("done");
		return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
	}
	
	
}
