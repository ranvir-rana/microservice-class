package com.example.demo;

public class Disease {

	public Disease() {
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String description;
	@Override
	public String toString() {
		return "Disease [id=" + id + ", description=" + description + ", treatment=" + treatment + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public Disease(String id, String description, String treatment) {
		super();
		this.id = id;
		this.description = description;
		this.treatment = treatment;
	}
	private String treatment;
}
