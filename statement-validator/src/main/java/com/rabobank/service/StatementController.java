package com.rabobank.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.model.CustomerStatement;
import com.rabobank.model.FailedRecords;
import com.rabobank.model.TransactionResponse;
import com.rabobank.parsers.CsvParser;
import com.rabobank.parsers.XmlParser;

@RequestMapping("/rabobank")
@RestController
public class StatementController {

	private static final Logger logger = LoggerFactory.getLogger(StatementController.class);

	@Autowired
	private Validator validator;

	@Autowired
	private XmlParser xmlParser;

	@Autowired
	private CsvParser csvParser;

	@Value("${inputCsv}")
	private String inputCsv;

	@Value("${inputXml}")
	private String inputXml;

	@GetMapping("/test")
	public String testEnv() {
		return "OK";
	}

	@GetMapping("/run")

	public ResponseEntity<TransactionResponse> validate() throws IOException {

		logger.info("======Inside Statement Controller======");
		TransactionResponse response = new TransactionResponse();

		List<CustomerStatement> customerStatement = csvParser.parseCsv(inputCsv);

		List<CustomerStatement> customerStatementXml = xmlParser.parseXml(inputXml);

		if (null == customerStatement && null == customerStatementXml) {
			response.setError("Error reading file");
			response.setMessage("Please check if the file is present in the mentioned path");
			return new ResponseEntity<TransactionResponse>(response, HttpStatus.BAD_REQUEST);
		}
		if (null != customerStatementXml) {
			customerStatement.addAll(customerStatementXml);
		}

		List<FailedRecords> failedRecords = validator.validateRecords(customerStatement);

		response.setFailedRecords(failedRecords);
		logger.info("Validation completed Successfully");

		return new ResponseEntity<TransactionResponse>(response, HttpStatus.OK);

	}

}
