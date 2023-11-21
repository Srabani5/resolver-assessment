Resolver Assessment with Selenium TestNG Framework

This Selenium Test Automation Project is built to automate a html page named "QE-index.html". 
It follows the Page Object Model (POM) design pattern. The project aims to showcase best 
practices in automated web testing using Selenium.

Prerequisites
Before running the tests, make sure you have the following installed:
Java Development Kit (JDK) 11
WebDriver (e.g., ChromeDriver, FirefoxoDriver, EdgeDriver)

Libraries
Maven plugin 3.2.2
TestNG 7.8.0
Selenium 4.15.0
Webdrivermanager 5.6.0
Extent Report 5.0.8


Configure Maven
No additional configuration is needed for Maven as the project structure already includes a pom.xml file with 
the necessary dependencies.

How to run test

1.Clone the repository:
git clone https://github.com/Srabani5/resolver-assessment.git

2.Navigate to the project directory:
cd selenium-test-automation

3.Run the tests using Maven:
mvn clean test

Project Components

    Page objects are in the directory src/main/java/pages
    Test data are in the directory src/main/java/testdata
    Test classes are in the the directory src/test/java/tests
    Listener class is in the directory src/main/java/utils
    The html page and the test guide are in directory src/test/java/test_page


Highlights
Page Object Model (POM): The project adheres to the POM design pattern for better organization and maintenance of web elements.
Browsers: The tests are designed to support three browsers - Chrome, Firefox, and Edge.
Reporting: Extent Report version 5.0.8 is used for comprehensive test reporting.


