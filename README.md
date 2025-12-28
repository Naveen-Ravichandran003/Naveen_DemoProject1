# Naveen_DemoProject1 - Selenium Test Automation Framework

## 🚀 Overview

A comprehensive **Selenium WebDriver automation framework** built with **Java**, **Maven**, **Cucumber BDD**, and **Allure reporting**. This project demonstrates modern test automation practices using the Page Object Model pattern and behavior-driven development.

## 🏗️ Architecture

### Core Technologies
- **Java 11** - Programming language
- **Maven** - Build and dependency management
- **Selenium WebDriver 4.15.0** - Web automation
- **Cucumber 7.14.0** - BDD framework
- **Allure 2.24.0** - Advanced reporting
- **JUnit 4** - Test runner
- **WebDriverManager** - Browser driver management

### Framework Structure
```
src/
├── main/java/com/acme/
│   ├── pages/          # Page Object Model classes
│   │   ├── BasePage.java
│   │   ├── LoginPage.java
│   │   └── DashboardPage.java
│   └── utils/          # Utility classes
│       ├── DriverManager.java
│       ├── ScreenshotUtils.java
│       └── ReportOpener.java
└── test/
    ├── java/com/acme/
    │   ├── runners/TestRunner.java
    │   └── stepdefinitions/LoginSteps.java
    └── resources/
        ├── features/login.feature
        ├── allure.properties
        └── cucumber.properties
```

## ✨ Key Features

### Test Automation Capabilities
- 🌐 **Cross-browser testing** (Chrome, Firefox)
- 📱 **Headless execution** for CI/CD
- 📸 **Automatic screenshot capture**
- ⏱️ **Smart wait strategies**
- 🔄 **Parallel execution support**

### BDD Implementation
- 📝 **Gherkin scenarios** for business-readable tests
- 🎭 **Multiple test types** (positive, negative, workflow)
- 📊 **Data-driven testing ready**
- 🔗 **Step definition reusability**

### Reporting & Analytics
- 📈 **Allure reports** - Interactive dashboards
- 🌐 **Cucumber HTML reports** - Standard BDD reporting
- 📊 **JSON/XML exports** - CI/CD integration
- 📸 **Visual test evidence** - Screenshots in reports

## 🎯 Test Scenarios

### Implemented Test Cases
1. **User Login** - Valid credential authentication
2. **Dashboard Access** - Post-login navigation verification
3. **User Logout** - Complete session termination
4. **Negative Testing** - Invalid credential handling

### Target Application
- **ACME Test Application**: https://acme-test.uipath.com/
- **Test Credentials**: test-demo@acme.com / Test@1234

## 🚀 Quick Start

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox browser

### Installation
```bash
git clone https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1.git
cd Naveen_DemoProject1
mvn clean install
```

### Execution Options

#### 1. Complete Test Suite (Recommended)
```bash
# Windows
run-complete-test-suite.bat

# Manual execution
mvn clean test
mvn allure:report
```

#### 2. Quick Test Run
```bash
# Windows
run-tests-now.bat

# Maven command
mvn test
```

#### 3. Headless Mode (CI/CD)
```bash
mvn test -Dheadless=true
```

### Report Access
After execution, reports are automatically opened:
- **Cucumber Report**: `target/cucumber-html-reports/report.html`
- **Allure Report**: `target/site/allure-maven-plugin/index.html`
- **Screenshots**: `test-screenshots/`

## 📊 CI/CD Integration

### Supported Platforms
- ✅ **GitHub Actions**
- ✅ **Jenkins**
- ✅ **Azure DevOps**
- ✅ **GitLab CI**

### Pipeline Configuration
```yaml
# Example GitHub Actions
- name: Run Tests
  run: mvn clean test -Dheadless=true
  
- name: Generate Reports
  run: mvn allure:report
```

## 🔧 Configuration

### Browser Settings
- **Default**: Chrome (headed mode)
- **Headless**: Set `headless=true` system property
- **Firefox**: Modify `DriverManager.java`

### Test Data
- **Feature Files**: `src/test/resources/features/`
- **Test Properties**: `src/test/resources/cucumber.properties`
- **Allure Config**: `src/test/resources/allure.properties`

## 📈 Project Metrics

### Framework Statistics
- **Total Files**: 15+ automation files
- **Code Coverage**: Page Object Model implementation
- **Test Scenarios**: 3 comprehensive test cases
- **Reporting Formats**: 4 different report types
- **Execution Scripts**: 3 automated batch files

### Quality Assurance
- ✅ **Page Object Model** - Maintainable code structure
- ✅ **BDD Implementation** - Business-readable scenarios
- ✅ **Error Handling** - Robust exception management
- ✅ **Screenshot Evidence** - Visual test validation
- ✅ **Wait Strategies** - Reliable element synchronization

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/new-test`)
3. Commit changes (`git commit -am 'Add new test scenario'`)
4. Push to branch (`git push origin feature/new-test`)
5. Create Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🏆 Acknowledgments

- Built with **Amazon Q Developer** AI assistance
- Implements industry best practices for test automation
- Designed for enterprise-scale testing requirements
- Optimized for both local development and CI/CD pipelines

---

**Repository**: https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1  
**Branch**: Naveen_Demo  
**Status**: ✅ Production Ready