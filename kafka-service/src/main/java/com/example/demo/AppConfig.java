package com.example.demo;

public class AppConfig {

	public AppConfig() {
		// TODO Auto-generated constructor stub
	}

	final static String applicationID = "HelloProduer";
	final static String bootstrapServers = "localhost:9092,localhost:9093,localhost:9094";
	final static String topicName = "invoice";
	final static int numEvenets = 1000;
}
