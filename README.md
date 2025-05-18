Match the input data from setup.java and resource property file
locations: src/test/resources/resources.properties  | https://github.com/Arodor/SauceDemoAutomationProject.java/blob/master/src/test/java/Utility/setup.java
This is not yet a complete project, and it will evolve in the future




## Project Overview
Automated UI tests for SauceDemo using Selenium WebDriver, TestNG, and the Page Object Model.

## Prerequisites
- Java 17+
- Maven 3.8+
- Chrome/Firefox/Safari browser
- Internet connection (for WebDriverManager)

## Setup Instructions
1. Clone the repository.
2. Update `src/test/resources/resources.properties` with your desired configuration.
3. Run `mvn clean test` to execute all tests.

## Project Structure
- `src/main/java/Pages/` - Page Object classes
- `src/test/java/LoginTests/` - Test classes
- `src/test/resources/resources.properties` - Test configuration

## How to Run Tests
```sh
mvn clean test
