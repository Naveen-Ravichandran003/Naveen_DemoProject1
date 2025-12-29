# Naveen_DemoProject1 – AI-Assisted Selenium Test Automation Framework using Amazon Q Developer

## 🚀 Overview
A comprehensive Selenium WebDriver automation framework built using **Java**, **Maven**, and **Cucumber BDD**.  
This project demonstrates how **Amazon Q Developer** can be used to generate an enterprise-ready test automation framework from scratch using **basic, user-friendly prompts**, significantly reducing manual development effort.
The framework follows modern test automation best practices, including the **Page Object Model (POM)** and **Behavior-Driven Development (BDD)**, and supports detailed **test execution reporting**, while being designed for scalability, maintainability, and seamless CI/CD integration.

## 🎥 Demo Recording
A complete end-to-end demonstration of this project, including Amazon Q Developer–assisted framework generation, test execution, and reporting, is available at the link below:

🔗 **Demo Video (Google Drive):** https://drive.google.com/file/d/1jLzyRj0eA2G76cf_fTAeDACaOkITJ09t/view?usp=sharing 


## 🤖 Amazon Q Developer Contribution
This project was generated using Amazon Q Developer AI assistance.

### What Amazon Q Did
- Generated the complete project structure
- Created Page Object Model classes
- Implemented Cucumber step definitions
- Configured Maven dependencies
- Set up Allure reporting
- Created CI/CD-ready execution scripts
- Generated the initial README documentation

### Manual Effort by Developer
- Provided user friendly prompts to Amazon Q
- Reviewed and validated generated code
- Minor refinements for project-specific needs
- Executed and demonstrated the framework

This demonstrates how Amazon Q can significantly accelerate enterprise-grade test automation development.

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

#### 1. Run Tests
```bash
# Run all tests
mvn clean test

# Headless mode (CI/CD)
mvn test -Dheadless=true
```

#### 2. Generate Reports
```bash
# Generate Allure report
mvn allure:report

# Start Allure live server
mvn allure:serve
# OR
allure-serve.bat

# Generate reports (Windows)
generate-reports.bat
```

### Report Access
After execution, reports are available at:
- **Cucumber HTML**: `target/cucumber-html-reports/report.html`
- **Allure Report**: `target/site/allure-maven-plugin/index.html`
- **Pre-built Reports**: `reports/cucumber-report.html`
- **Screenshots**: `test-screenshots/`

## 📊 CI/CD Integration

### 🤔 Why Use CI/CD Integration?

#### 🔄 Continuous Quality Assurance
- **Automatic testing** on every code change
- **Catch bugs early** before they reach production
- **Prevent broken code** from being merged

#### 🚀 Professional Development Practices
- **Industry standard** - Expected in enterprise environments
- **Team collaboration** - Multiple developers can work safely
- **Code confidence** - Know immediately if changes break tests

#### 📊 Automated Reporting
- **Test results** available instantly after each run
- **Historical tracking** - See test trends over time
- **Visual evidence** - Screenshots and reports stored automatically

#### 🏢 Enterprise Requirements
- **Compliance** - Many organizations require automated testing
- **Deployment gates** - Tests must pass before releases
- **Documentation** - Audit trail of all test executions

### GitHub Actions Workflow
- ✅ **Automated Testing** - Runs on every push and pull request
- ✅ **Cross-Platform** - Ubuntu environment with headless Chrome
- ✅ **Report Generation** - Automatic Allure and Cucumber reports
- ✅ **Artifact Storage** - Test results and screenshots saved for 30 days
- ✅ **Status Badges** - Real-time build status visibility

### Workflow Triggers
- Push to `main` or `Naveen_Demo` branches
- Pull requests to these branches
- Manual workflow dispatch

### Pipeline Steps
1. **Environment Setup** - Java 11, Maven, Chrome
2. **Dependency Caching** - Faster builds with Maven cache
3. **Test Execution** - Headless Selenium tests
4. **Report Generation** - Allure and Cucumber reports
5. **Artifact Upload** - Reports and screenshots storage

### Viewing Results
- **GitHub Actions**: [View Workflows](https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1/actions)
- **Download Artifacts**: Test reports, screenshots, and results
- **Build Status**: [![CI](https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1/actions/workflows/ci.yml/badge.svg)](https://github.com/Naveen-Ravichandran003/Naveen_DemoProject1/actions/workflows/ci.yml)

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
- **Execution Scripts**: 2 utility batch files

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
