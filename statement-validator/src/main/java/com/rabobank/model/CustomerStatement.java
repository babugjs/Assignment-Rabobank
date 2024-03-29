package com.rabobank.model;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class CustomerStatement {
	
	private int reference;
	private String accountNumber;
	private String description;
	private String  startBalance;
	private String  mutation;
	private String  endBalance;

	public CustomerStatement() {
		
	}
	public CustomerStatement(int reference, String accountNo, String description, String  startBal, String  mutation,
			String  endBal) {
		super();
		this.reference = reference;
		this.accountNumber = accountNumber;
		this.description = description;
		this.startBalance = startBalance;
		this.mutation = mutation;
		this.endBalance = endBalance;
	}
	@XmlAttribute
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	@XmlElement 
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	@XmlElement 
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement 
	public String  getStartBalance() {
		return startBalance;
	}
	public void setStartBalance(String  startBalance) {
		this.startBalance = startBalance;
	}
	@XmlElement 
	public String  getMutation() {
		return mutation;
	}
	public void setMutation(String  mutation) {
		this.mutation = mutation;
	}
	@XmlElement 
	public String  getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(String  endBalance) {
		this.endBalance = endBalance;
	}
	@Override
	public String toString() {
		return "CustomerStatement [reference=" + reference + ", accountNumber=" + accountNumber + ", description="
				+ description + ", startBalance=" + startBalance + ", mutation=" + mutation + ", endBalance="
				+ endBalance + "]";
	}
	
	

}
