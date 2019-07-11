package com.rabobank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rabobank.model.CustomerStatement;
import com.rabobank.model.FailedRecords;

@Component
public class Validator {

	private static final Logger logger = LoggerFactory.getLogger(Validator.class);



	public List<FailedRecords> validateRecords(List<CustomerStatement> customerStatements) {
		 List<FailedRecords> failedRecords = new ArrayList<FailedRecords>();
		try {
			logger.info("Validation Started");
			Map<Integer, String> unique = new HashMap<Integer, String>();
			if (null != customerStatements && customerStatements.size() > 0) {
				for (CustomerStatement customerStatement : customerStatements) {
					FailedRecords failedRecord = new FailedRecords();
					if (unique.containsKey(customerStatement.getReference())) {
						failedRecord.setReference(customerStatement.getReference());
						failedRecord.setDescription(customerStatement.getDescription());
						failedRecords.add(failedRecord);
					}

					else {
						BigDecimal total = new BigDecimal(customerStatement.getStartBalance())
								.add(new BigDecimal(customerStatement.getMutation()));
						if (!total.equals(new BigDecimal(customerStatement.getEndBalance()))) {
							failedRecord.setReference(customerStatement.getReference());
							failedRecord.setDescription(customerStatement.getDescription());
							failedRecords.add(failedRecord);
						}
						unique.put(customerStatement.getReference(), customerStatement.getDescription());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return failedRecords;
	}

}
