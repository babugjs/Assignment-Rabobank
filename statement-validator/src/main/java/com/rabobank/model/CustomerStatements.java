package com.rabobank.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "records")
@XmlAccessorType (XmlAccessType.FIELD)
public class CustomerStatements implements Serializable {

	@XmlElement(name = "record")
	private List<CustomerStatement> CustomerStatement;

	public CustomerStatements() {
		
	}

	

	public List<CustomerStatement> getCustomerStatement() {
		return CustomerStatement;
	}

	public void setCustomerStatement(List<CustomerStatement> customerStatement) {
		CustomerStatement = customerStatement;
	}



	@Override
	public String toString() {
		return "CustomerStatements [CustomerStatement=" + CustomerStatement + "]";
	}

	
	

}
