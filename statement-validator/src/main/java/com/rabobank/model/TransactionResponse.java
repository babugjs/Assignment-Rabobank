package com.rabobank.model;

import java.util.List;

public class TransactionResponse {
	private List<FailedRecords> failedRecords;
	private String error;
	private String message;

	

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FailedRecords> getFailedRecords() {
		return failedRecords;
	}
	public void setFailedRecords(List<FailedRecords> failedRecords) {
		this.failedRecords = failedRecords;
	}


}
