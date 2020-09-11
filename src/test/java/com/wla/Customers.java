package com.wla;

import com.dataprovider.CustomerDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Customers extends TestBase {
    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)
    public void AddCustomer(String branchName, String branchAdmin, String branchPassword,String firstName, String lastName, String errorMessage){
        WebDriver driver = new ChromeDriver();

        //create Objects required for this test
        Login login = new Login();
        login.WLALogin(driver, branchName, branchAdmin, branchPassword);

        //click button Customers
        clickElementByID(driver, "ext-gen192");
        //click button Action
        clickElementByXpath(driver, "//td/table/tbody/tr/td[2]/em/button");
        //select AddCustomer menu item
        clickElementByLinkText(driver, "Add Customer");

        sleep(3000);

        //enter First Name
        setText(driver, "FirstName", firstName);
        //enter Last Name
        setText(driver, "LastName", lastName);

        sleep(3000);

        //click button Save
        clickElementByXpath(driver, "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");

        sleep(10000);

        if(!errorMessage.equals("")){
            doesTextExistOnPage(errorMessage, driver);
            //click button OK
            clickElementByXpath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
            //click button Cancel
            clickElementByXpath(driver, "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button");

        } else{
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(lastName);
            System.out.println("New Customer was created: " + ret);
        }

        //click button Logout
        clickElementByXpath(driver, "//td[4]/table/tbody/tr/td[2]/em/button");

        //close web browser
        driver.close();
    }

}
