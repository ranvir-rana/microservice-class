package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	public CatalogResource() {
		// TODO Auto-generated constructor stub
	}
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	//@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		//UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
		UserRating userRating = userRatingInfo.getUserRating(userId);
		/* return userRating.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://moview-info-service/movies/" + rating.getMoviewId(), Movie.class);
					return new CatalogItem(movie.getName(),movie.getDescription(),rating.getRating())	;				
		}).collect(Collectors.toList());*/
		
		return userRating.getRatings().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
		
	}
	
	/* public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId)
	{
		return Arrays.asList(new CatalogItem("No Movie info at this time","",0));
		
	} */
	
}
