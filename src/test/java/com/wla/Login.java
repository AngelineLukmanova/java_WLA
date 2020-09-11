package com.wla;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

public class Login {
    @Test
    public void WLALogin(WebDriver driver, String branchName, String branchAdmin, String branchPassword){
        //create Objects required for this test
        LoginPage loginPage = new LoginPage(driver);
        //open a new WLA page
        driver.get("https://www.qa-hitekschool.com/lms/loans/2108");
        //read the title of the page and output it into results
        System.out.println("Page title is: " + driver.getTitle());

        loginPage.setBranchName(driver, branchName);
        loginPage.setBranchAdmin(driver, branchAdmin);
        loginPage.setBranchPassword(driver, branchPassword);
        loginPage.clickLoginButtom(driver);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branchName +"' branch");

    }
}