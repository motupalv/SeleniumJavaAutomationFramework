Framework for web Application Testing
Programming Language used: Java
Automation Framework: Selenium
Type of Framework: TDD (Test Driven Development)
Design Pattern: POM (Page Object Model)
Unit test Framework: TestNG
Build Tool: Maven

Command to run test via Maven

To run all test cases
mvn -Dtest=<Replace with Runner Class Name> test

To run via xml file
mvn clean install test -DsuiteXmlFile="<File Name>.xml"

To run specific testcase
mvn -Dtest=<Replace with Runner Class Name>#<Replace with Method Name> test

TestNG:
Right Click on testng.xml file and select run.

Reports:
Reports will be stored in "reports" folder

Initialized Webdriver using "WebDriverManager" package.
pom.xml will have all dependencies and plugins needed for test automation.
Failure screenshots will be seen under "screenshots" folder.

Future dependencies and plugins can be taken from  "https://mvnrepository.com/"

Packages:
Main Package
Main Package contains all the Page Objects Interface, Page Methods/Events Classes 
Util Classes like constants, ElementsFetch, RetryAnalyzer, SuiteListener.

Test Package:
Test Package Contains BaseTest Class and Runner/Executable Class

CI/CD Integration:
Jenkins/GitHubActions






