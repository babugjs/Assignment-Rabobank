package com.rabobank.parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.rabobank.model.CustomerStatement;
import com.rabobank.model.CustomerStatements;

@Component
public class CsvParser {
	private static final Logger logger = LoggerFactory.getLogger(CsvParser.class);

	@Autowired
	private CustomerStatements records;

	private List<CustomerStatement> customerStatement = new ArrayList<CustomerStatement>();

	public List<CustomerStatement> parseCsv(String inputCsv) throws FileNotFoundException{
		/**
		 * Reading the CSV File Delimiter is comma Default Quote character is double
		 * quote Start reading from line 1
		 */
		try {
			logger.info("Reading CSV input file from path :" +inputCsv);

			CSVReader reader = new CSVReader(new FileReader(inputCsv), ',', '"', 1);

			ColumnPositionMappingStrategy<CustomerStatement> beanStrategy = new ColumnPositionMappingStrategy<CustomerStatement>();
			beanStrategy.setType(CustomerStatement.class);

			beanStrategy.setColumnMapping(new String[] { "reference", "accountNumber", "description", "startBalance",
					"mutation", "endBalance" });

			CsvToBean<CustomerStatement> csvToBean = new CsvToBean<CustomerStatement>();
			customerStatement = csvToBean.parse(beanStrategy, reader);

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return customerStatement;

	}

}
