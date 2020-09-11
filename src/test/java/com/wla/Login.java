package com.wla;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class Login extends TestBase{
    @Test
    public void WLALogin(WebDriver driver, String branchName, String branchAdmin, String branchPassword){
        //create Objects required for this test
        LoginPage loginPage = new LoginPage(driver);
        //open a new WLA page
        driver.get("https://www.qa-hitekschool.com/lms/loans/2108");
        //read the title of the page and output it into results
        System.out.println("Page title is: " + driver.getTitle());

        setText(driver, "j_branch", branchName);
        setText(driver, "j_username", branchAdmin);
        setText(driver, "j_password", branchPassword);
        clickElementByID(driver, "ext-gen38");

        sleep(13000);

        //verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branchName +"' branch");

    }
}