package com.rabobank.model;

import org.springframework.stereotype.Component;

@Component
public class FailedRecords {
	private int reference;
	private String description;
	
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FailedRecords(int reference, String description) {
		this.reference = reference;
		this.description = description;
	}
	public FailedRecords() {
	
	}
	
	

}
