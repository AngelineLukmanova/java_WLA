package com.wla;

import com.dataprovider.CustomerDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobject.AddCustomerPage;
import pageobject.CustomersPage;
import pageobject.HomePage;

public class Customers extends TestBase {
    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)
    public void AddCustomer(String branchName, String branchAdmin, String branchPassword,String firstName, String lastName, String errorMessage){
        WebDriver driver = new ChromeDriver();

        //create Objects required for this test
        Login login = new Login();
        login.WLALogin(driver, branchName, branchAdmin, branchPassword);
        CustomersPage customersPage = new CustomersPage(driver);
        HomePage homePage = new HomePage(driver);
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

        homePage.clickButtonCustomers(driver);
        customersPage.clickButtonAction(driver);
        customersPage.clickButtonAddCustomer(driver);

        sleep(3000);

        addCustomerPage.setFirstName(driver, firstName);
        addCustomerPage.setLastName(driver, lastName);

        sleep(3000);

        addCustomerPage.clickButtonSave(driver);

        sleep(10000);

        if(!errorMessage.equals("")){
            doesTextExistOnPage(errorMessage, driver);
            addCustomerPage.clickButtonOK(driver);
            addCustomerPage.clickButtonCancel(driver);

        } else{
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(lastName);
            System.out.println("New Customer was created: " + ret);
        }

        customersPage.clickButtonLogout(driver);
        //close web browser
        driver.close();
    }

}
