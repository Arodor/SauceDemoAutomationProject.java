# SauceDemo Automation Framework

A comprehensive test automation framework for SauceDemo using Selenium WebDriver, TestNG, and modern Java practices.

## 🚀 Key Improvements

### Architecture & Design
- **Page Object Model (POM)** with proper inheritance hierarchy
- **ThreadLocal WebDriver** management for parallel execution
- **Singleton Configuration Manager** for centralized config handling
- **Fluent API design** for readable test chains
- **Proper separation of concerns** across layers

### Code Quality
- **Modern Java 17** features and syntax
- **AssertJ** for fluent and readable assertions
- **Allure reporting** with detailed test documentation
- **Comprehensive error handling** and logging
- **Thread-safe** implementation for parallel testing

### Test Coverage
- **Login functionality** (valid/invalid/locked/empty credentials)
- **Product operations** (sorting, adding to cart, viewing)
- **End-to-end workflows** (complete purchase flow)
- **Edge cases** and error scenarios

### Maintainability
- **Configuration-driven** approach
- **Reusable components** and utilities
- **Clear naming conventions** and documentation
- **Modular test structure** for easy extension

## 📋 Prerequisites

- Java 17+
- Maven 3.8+
- Chrome/Firefox/Safari browser
- Internet connection (for WebDriverManager)

## 🛠️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd AutomationMaven
   ```

2. **Configure test settings**
   Update `src/test/resources/config.properties` with your desired configuration:
   ```properties
   browser=chrome
   headless=false
   base.url=https://www.saucedemo.com/
   ```

3. **Install dependencies**
   ```bash
   mvn clean install
   ```

## 🏃‍♂️ Running Tests

### Run all tests
```bash
mvn clean test
```

### Run specific test suite
```bash
mvn clean test -Dtest=LoginTests
mvn clean test -Dtest=ProductTests
mvn clean test -Dtest=EndToEndTests
```

### Run with specific browser
```bash
mvn clean test -Dbrowser=firefox
```

### Run in headless mode
```bash
mvn clean test -Dheadless=true
```

### Parallel execution
```bash
mvn clean test -DthreadCount=3
```

## 📊 Test Reporting

### Generate Allure Report
```bash
mvn allure:serve
```

### View TestNG Reports
After test execution, reports are available at:
- `target/surefire-reports/index.html`

## 📁 Project Structure

```
src/
├── main/java/
│   ├── config/
│   │   └── ConfigManager.java          # Configuration management
│   ├── driver/
│   │   └── DriverManager.java          # WebDriver management
│   └── pages/
│       ├── BasePage.java               # Base page with common functionality
│       ├── LoginPage.java              # Login page objects and actions
│       ├── ProductsPage.java           # Products page objects and actions
│       ├── CartPage.java               # Cart page objects and actions
│       ├── CheckoutPage.java           # Checkout page objects and actions
│       ├── CheckoutOverviewPage.java   # Checkout overview page
│       └── CheckoutCompletePage.java   # Checkout completion page
└── test/
    ├── java/
    │   ├── base/
    │   │   └── BaseTest.java           # Base test class with setup/teardown
    │   └── tests/
    │       ├── LoginTests.java         # Login functionality tests
    │       ├── ProductTests.java       # Product functionality tests
    │       └── EndToEndTests.java      # End-to-end workflow tests
    └── resources/
        ├── config.properties           # Test configuration
        ├── testng.xml                  # TestNG suite configuration
        └── allure.properties           # Allure reporting configuration
```

## 🔧 Configuration Options

### Browser Support
- Chrome (default)
- Firefox
- Safari

### Test Configuration
- Implicit/Explicit wait times
- Headless execution
- Parallel execution settings
- Base URL configuration

### User Credentials
- Standard user
- Locked user
- Problem user

## 🧪 Test Categories

### Login Tests
- ✅ Valid credentials login
- ✅ Invalid credentials error handling
- ✅ Locked user error handling
- ✅ Empty credentials validation

### Product Tests
- ✅ Product sorting functionality
- ✅ Add single item to cart
- ✅ Add multiple items to cart
- ✅ Product display verification

### End-to-End Tests
- ✅ Complete purchase workflow
- ✅ Cheapest item purchase flow
- ✅ Cart and checkout validation

## 🚀 Advanced Features

### Parallel Execution
Tests can run in parallel using TestNG's parallel execution capabilities.

### Screenshot on Failure
Automatic screenshot capture on test failures with Allure integration.

### Fluent API Design
```java
loginPage
    .navigateToLoginPage()
    .loginWithStandardUser()
    .sortByPriceLowToHigh()
    .addFirstItemToCart()
    .goToCart()
    .proceedToCheckout();
```

### Thread-Safe Design
WebDriver instances are managed per thread for safe parallel execution.

## 📈 Best Practices Implemented

1. **Page Object Model** - Clean separation of page logic
2. **DRY Principle** - Reusable components and methods
3. **Single Responsibility** - Each class has a focused purpose
4. **Configuration Management** - Externalized test data
5. **Proper Exception Handling** - Graceful error management
6. **Comprehensive Assertions** - Clear test validations
7. **Documentation** - Well-documented code and tests

## 🤝 Contributing

1. Follow the existing code structure and naming conventions
2. Add appropriate test documentation using Allure annotations
3. Ensure all tests pass before submitting changes
4. Update README if adding new features

## 📝 License

This project is licensed under the MIT License.