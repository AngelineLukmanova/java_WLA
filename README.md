# Automation Scripts For WebLoanApp with Java and Selenium

## Description Of The Product

**"WebLoanApp"** is a web-based banking application used to evaluate eligibility of potential customer to get a loan. When bank employee (User) enters customer's monthly income and debt, WebLoanApp should automatically calculate maximum amount of loan eligible and monthly payments. System also allows creating and printing a letter that can be sent to the customer with Loan conditions. 

![1](https://user-images.githubusercontent.com/64429543/92963681-b709dc00-f427-11ea-9b4e-b8286f74fcd1.png)

**Version 2.1.08**

## Prerequisites
1. JDK 14.0.2
2. Maven
3. Add JAVA_HOME, M2_Home to Path
4. Install IntelliJ IDEA
5. Google Chrome or Mozilla Firefox

      To run the tests locally with Chrome, install ChromeDriver
      
      To run the tests locally with Firefox, install GeckoDriver

      ###### Java Code
      
      ###### Chrome Driver(by default)

      ```java
        WebDriver driver = new ChromeDriver();
      ```

      ###### Firefox Driver

      ```java
        WebDriver driver = new FirefoxDriver();
      ```
5. Dependencies
      ```java
         <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.3.0</version>
        </dependency>
        </dependencies>
      ```

## Installation
```
git clone https://github.com/AngelineLukmanova/java_WLA
open java_WLA project in IntelliJ IDEA
run testng.xml
```
## Test Scripts
    - master branch scripts are written using Page Objects Model

    - bot_style_of_tests branch scripts are written using Bot Style Model
    
##### Test Results
    
 ![Screen Shot 2020-09-11 at 1 13 28 PM](https://user-images.githubusercontent.com/64429543/92968875-baee2c00-f430-11ea-9753-26523a25365d.png)


