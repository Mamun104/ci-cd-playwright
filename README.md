# Playwright Java Automation Framework

## Introduction
This project provides a robust and scalable foundation for automating web application testing using **Playwright** with **Java**.
It leverages Playwright for browser automation, TestNG for test execution, and Gradle for build management.
The framework is designed for maintainability, modularity, and readability by implementing the **Page Object Model (POM)**.
Advanced HTML reports are supported via **Allure Reporting**, enabling easy analysis of test results.


<img width="646" height="400" alt="image" src="https://github.com/user-attachments/assets/5f5305d0-b842-483d-8e8b-143df16e8677" />

---

## Technologies & Tools Used

| Tool / Library                  | Purpose                                    |
| ------------------------------- | ------------------------------------------ |
| Java                            | Programming language                       |
| Playwright                      | Cross-browser automation framework         |
| TestNG / JUnit                  | Test execution framework                   |
| Gradle                          | Build automation and dependency management |
| Allure Reporting                | Advanced HTML test reporting               |
| ChromeDriver / Firefox / WebKit | Supported browsers via Playwright          |

---

## Prerequisites

Ensure the following tools are installed before running the framework:

* Java JDK 11 or higher
* Gradle
* Chrome / Firefox / Safari browser
* IntelliJ IDEA / Eclipse (optional for development)

---

## Project Structure

```bash
playwright-java-framework/
├── src
│   ├── main
│   │   └── java/org/example
│   │       └── utils                # Utility classes
│   ├── test
│   │   ├── java
│   │   │   ├── pages               # Page Object classes (LoginPage.java)
│   │   │   ├── setup               # Driver setup and Playwright initialization
│   │   │   ├── tests               # Test classes (LoginTests.java)
│   │   │   └── listeners           # Custom listeners for reporting
│   │   └── resources
│   │       └── testData            # Test data files
├── build.gradle
├── settings.gradle
└── README.md
```

---

## How to Run This Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/playwright-java-framework.git
cd playwright-java-framework
```

### 2. Run the Tests

```bash
./gradle clean test
```

### 3. Generate Allure Report (Optional)

```bash
./gradle allureServe
```

> This will start a local server with interactive test reports in your browser.

---

## Test Report

After test execution, Allure reports are generated at:

```bash
build/allure-results/
```


<img width="1892" height="975" alt="image" src="https://github.com/user-attachments/assets/6cdf251e-39b7-4e43-bf67-aa3713db1628" />


<img width="1899" height="987" alt="image" src="https://github.com/user-attachments/assets/d0af4870-045c-4f52-ae64-bb37104d50ef" />


> The report provides detailed insights into test execution, including pass/fail status, screenshots, and logs.

---

## Report Customization

The framework supports **Allure Reporting** with custom metadata such as environment, platform, browser, and test author.

**Sample Configuration in TestNG Listener:**

```java
import io.qameta.allure.Allure;

@BeforeMethod
public void beforeTest(Method method) {
    Allure.parameter("Platform", "Windows 10");
    Allure.parameter("Browser", "Chrome");
    Allure.parameter("Environment", "QA");
    Allure.parameter("Author", "Your Name");
}
```

---

