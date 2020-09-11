package com.wla;

import com.dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Users extends TestBase{
    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    public void AddUser(String branchName, String branchAdmin, String branchPassword, String user, String password, String errorMessage){
        WebDriver driver = new ChromeDriver();
        //create Objects required for this test
        Login login = new Login();
        login.WLALogin(driver, branchName, branchAdmin, branchPassword);

        //click button Users
        clickElementByID(driver, "ext-gen185");
        //click button Action
        clickElementByXpath(driver, "//td/table/tbody/tr/td[2]/em/button");
        //select AddUser menu item
        clickElementByLinkText(driver, "Add User");

        sleep(3000);

        //enter username
        setText(driver, "Username", user);
        //enter password
        setText(driver, "Password", password);

        sleep(3000);

        //click button Save
        clickElementByXpath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");

        sleep(10000);

        if(!errorMessage.equals("")){
            //verify the correct error message appears
            doesTextExistOnPage(errorMessage, driver);
            //click button OK
            clickElementByXpath(driver, "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button");
            //click button Cancel
            clickElementByXpath(driver, "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]");


        } else {
            //verify user was created
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(user);
            System.out.println("The user was created: " + ret);

        }
        //click button Logout
        clickElementByXpath(driver, "//td[4]/table/tbody/tr/td[2]/em/button");
        //close the browser
        driver.close();

    }

}
