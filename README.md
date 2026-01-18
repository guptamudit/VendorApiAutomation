# Vendor API Automation

This repository contains an automated testing suite for a **Vendor Management Web Service**. The project demonstrates advanced API testing techniques using **Rest Assured**, **Cucumber (BDD)**, and **TestNG**, with a focus on requirement analysis, test execution, and detailed reporting.

##  Project Overview
The goal of this project is to meticulously assess whether the Vendor web service aligns with specified business requirements. The service uses REST architecture and handles JSON data for operations like retrieving vendor details and adding/updating vendors.

### Key Features Tested:
* **Add Vendor:** Validating `POST` requests with JSON payloads.
* **Fetch Vendor Details:** Validating `GET` requests with path parameters and header assertions.
* **Parameterization:** Data-driven testing using Excel files to test multiple datasets.
* **BDD Implementation:** Using Gherkin syntax (Given/When/Then) for readable test scenarios.

---

##  Tech Stack
* **Java**: Primary programming language.
* **Rest Assured**: For automating RESTful web services.
* **TestNG / JUnit**: Test execution frameworks.
* **Cucumber**: For Behavior Driven Development (BDD).
* **Apache POI**: For reading and writing data to Excel (Data-Driven Testing).
* **Maven**: Dependency management and project build tool.

---

##  Getting Started

### Prerequisites
* JDK 1.8 or higher
* Apache Maven
* An IDE (IntelliJ IDEA or Eclipse)

### Maven Dependencies
Add the following to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.1.1</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>5.2.0</version>
    </dependency>

    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.2</version>
    </dependency>
</dependencies>
```
---

##  Results & Reporting
* The framework outputs the execution status directly to the console and updates the specified Excel sheets with the response status codes and messages, ensuring full traceability of the test results.
