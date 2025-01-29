package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathalogy")
public class DiseaseResource {

	public DiseaseResource() {
		// TODO Auto-generated constructor stub
	}
	List<Disease> diseases = Arrays.asList(
			new Disease("d1","disease description 1","disease treatment 1"),
			new Disease("d2","disease description 2","disease treatment 2"),
			new Disease("d3","disease description 3","disease treatment 3")
			);
	@RequestMapping("/diseases")
	public DiseaseList getDiseases()
	{
		DiseaseList diseaseslist =  new DiseaseList();
		diseaseslist.setDisease(diseases);
		return diseaseslist;
	}
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id)
	{
		Disease e =  diseases.stream().filter(disease -> id.equals(disease.getId())).findAny().orElse(null);
		return e;
	}
}
