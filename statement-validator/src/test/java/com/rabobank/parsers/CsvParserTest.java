package com.rabobank.parsers;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.rabobank.model.CustomerStatement;

public class CsvParserTest {

	private List<CustomerStatement> customerStatement = new ArrayList<CustomerStatement>();

	@Test
	public void test() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(
				"C:/Users/intel/Documents/workspace-sts-3.9.9.RELEASE/statement-validator/src/main/resources/records.csv"),
				',', '"', 1);

		ColumnPositionMappingStrategy<CustomerStatement> beanStrategy = new ColumnPositionMappingStrategy<CustomerStatement>();
		beanStrategy.setType(CustomerStatement.class);

		beanStrategy.setColumnMapping(
				new String[] { "reference", "accountNumber", "description", "startBalance", "mutation", "endBalance" });

		CsvToBean<CustomerStatement> csvToBean = new CsvToBean<CustomerStatement>();
		customerStatement = csvToBean.parse(beanStrategy, reader);

		reader.close();
		System.out.println(customerStatement.toString());
	}

}
