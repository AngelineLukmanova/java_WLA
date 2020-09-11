package com.wla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {
    protected void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void doesTextExistOnPage(String errorMessage, WebDriver driver) {
        WebElement body = driver.findElement(By.tagName("body"));
        boolean ret = body.getText().contains(errorMessage);
        System.out.println("The error message is correct: " + ret);
    }
}
