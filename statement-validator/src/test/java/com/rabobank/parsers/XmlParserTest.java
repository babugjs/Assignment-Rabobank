package com.rabobank.parsers;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.rabobank.model.CustomerStatement;
import com.rabobank.model.CustomerStatements;

public class XmlParserTest {


	private CustomerStatements records;
	
    @Test
    public void testXmlToObject() throws JAXBException, FileNotFoundException {
        File file = new File("/C:/Users/intel/Documents/workspace-sts-3.9.9.RELEASE/statement-validator/src/main/resources/records.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomerStatements.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        records = (CustomerStatements) unmarshaller.unmarshal(file);
        
        for(CustomerStatement record: records.getCustomerStatement()) {
        	System.out.println(record.toString());
        }


}
}
