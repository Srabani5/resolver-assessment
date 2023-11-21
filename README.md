# Resolver Assessment with Selenium TestNG Framework

This Selenium Test Automation Project is built to automate a html page named ["QE-index.html"](https://github.com/Srabani5/resolver-assessment/blob/feature/polish-testcases/src/test/java/test_page/QE-index.html). 
It follows the Page Object Model (POM) design pattern. The project aims to showcase best 
practices in automated web testing using Selenium.

## Prerequisites

1. **Java Development Kit (JDK):** Ensure you have JDK 11 installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html).

2. **Maven:** Make sure you have Maven installed. You can download it from [Maven's official website](https://maven.apache.org/download.cgi).

3. **WebDriver Drivers:** Download the WebDriver driver executable for the browsers you plan to test (e.g., ChromeDriver, FirefoxoDriver, EdgeDriver).

## Libraries Used

- **Maven Plugin:** Version 3.2.2
- **TestNG:** Version 7.8.0
- **Selenium:** Version 4.15.0
- **WebdriverManager:** Version 5.6.0
- **Extent Report:** Version 5.0.8

## Getting Started

1. **Clone the Repository:**

    ```bash
    git clone  https://github.com/Srabani5/resolver-assessment.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd resolver-assessment
    ```

4. **Run Tests:**

    Execute the following Maven command to run the tests:

    ```bash
    mvn test
    ```

## Project Structure

The project follows a standard Page Object Model structure:

- `src/main/java/pages`: Contains Page objects.
- `src/main/java/testdata`: Contains test data.
- `src/main/java/utils` : Contains listener classes.
- `src/test/java/test_page` : Contains the html test page and the test guides.
- `src/test/java/tests` : Contains test classes.
- `src/test/resources`: Contains testng configuration file.
- `pom.xml`: Maven project configuration file.

## Highlights

- **Page Object Model (POM):** The project adheres to the POM design pattern for better organization and maintenance of web elements.
- **Browsers:** The tests are designed to support three browsers - Chrome, Firefox, and Edge.
- **Reporting:** Extent Report is used for comprehensive test reporting.
- **Screenshot on test failure:** A screenshot of the active browser is captured and stored in the screenshots folder.


