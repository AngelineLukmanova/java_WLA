package com.wla;

import com.dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.UsersPage;

public class Users extends TestBase{
    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    public void AddUser(String branchName, String branchAdmin, String branchPassword, String user, String password, String errorMessage){
        WebDriver driver = new ChromeDriver();
        //create Objects required for this test
        Login login = new Login();
        login.WLALogin(driver, branchName, branchAdmin, branchPassword);
        HomePage homePage = new HomePage(driver);
        UsersPage usersPage = new UsersPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);

        homePage.clickButtonUsers(driver);
        usersPage.clickButtonAction(driver);
        usersPage.clickButtonAddUser(driver);

        sleep(3000);

        addUserPage.setUsername(driver, user);
        addUserPage.setPassword(driver, password);

        sleep(3000);

        addUserPage.clickButtonSave(driver);

        sleep(10000);

        if(!errorMessage.equals("")){
            //verify the correct error message appears
            doesTextExistOnPage(errorMessage, driver);
            addUserPage.clickButtonOK(driver);
            addUserPage.clickButtonCancel(driver);


        } else {
            //verify user was created
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(user);
            System.out.println("The user was created: " + ret);

        }

        usersPage.clickButtonLogout(driver);
        //close the browser
        driver.close();

    }

}
