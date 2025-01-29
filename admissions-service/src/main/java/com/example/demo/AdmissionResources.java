package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admissions")
public class AdmissionResources {

	public AdmissionResources() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/physicians")
	public EmployeeList getPhysicians()
	{
		//EmployeeList physicains = restTemplate.getForObject("http://localhost:8082/hr/employees",EmployeeList.class);
		EmployeeList physicains = restTemplate.getForObject("http://hr-service/hr/employees",EmployeeList.class);
		return physicains;
	}
	
	@RequestMapping("/healthissues")
	public DiseaseList getDiseases()
	{
		//DiseaseList diseases = restTemplate.getForObject("http://localhost:8083/pathalogy/diseases",DiseaseList.class);
		DiseaseList diseases = restTemplate.getForObject("http://pathalogy-service/pathalogy/diseases",DiseaseList.class);
		return diseases;
	}
}
