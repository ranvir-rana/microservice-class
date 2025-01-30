package com.example.demo;

public class Rating {

	public Rating() {
		// TODO Auto-generated constructor stub
	}
	private String moviewId;
	private Integer rating;
	public Rating(String moviewId, Integer rating) {
		super();
		this.moviewId = moviewId;
		this.rating = rating;
	}
	public String getMoviewId() {
		return moviewId;
	}
	public void setMoviewId(String moviewId) {
		this.moviewId = moviewId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
