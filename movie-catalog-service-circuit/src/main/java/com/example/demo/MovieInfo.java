package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating)
	{
		Movie movie = restTemplate.getForObject("http://moview-info-service/movies/" + rating.getMoviewId(), Movie.class);
		return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating())	;	
	}
	public CatalogItem getFallbackCatalogItem(Rating rating)
	{
		
		return new CatalogItem("Movie name not found at theis time","",rating.getRating());
	}
}
