Steps to run the application:
1.	Clone the project Rabobank (spring boot project).
     git clone https://github.com/babugjs/Assignment-Rabobank.git
2.	Import the project in STS and do maven ->update project
3.	Mention the path of  csv and xml files  correctly in application.properties file
4.	Start the application by restarting embedded server.
5.	service url to test application: http://localhost:8080/rabobank/run
6.	Hit the above URL in browser or Postman/SoapUi tool.
7.	The input file will be validated based on two condition mentioned in the problem statment.(validation condition mentioned in expected output section)
      o	Duplicate Reference number check,
      o	End balance calculation check. (end balance = start balance +(or) – mutation)
8.	Finally invalid records will be getting as web service response.

Logic:
1.	Only CSV and Xml files can be used. Both files will be read one by one. If no file is there in the mentioned path exception will be thrown. 
2.	If any one of the file is present in the given path it will validate that file and get us the response. 
