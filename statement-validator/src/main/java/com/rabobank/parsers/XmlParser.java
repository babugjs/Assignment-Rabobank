package com.rabobank.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabobank.model.CustomerStatement;
import com.rabobank.model.CustomerStatements;

@Component
public class XmlParser {

	private static final Logger logger = LoggerFactory.getLogger(XmlParser.class);

	@Autowired
	private CustomerStatements records;

	public List<CustomerStatement> parseXml(String inputXml) throws FileNotFoundException {
		try {
			logger.info("Reading XML input file from path :" +inputXml);
		
			JAXBContext jaxbContext = JAXBContext.newInstance(CustomerStatements.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			records = (CustomerStatements) jaxbUnmarshaller.unmarshal(new File(inputXml));

		} 
		catch (JAXBException e) {
			e.printStackTrace();

		}
		catch (Exception e) {
			e.printStackTrace();

		}

		return records.getCustomerStatement();

	}

}
