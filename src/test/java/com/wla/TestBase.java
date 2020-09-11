package com.wla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void clickElementByID(WebDriver driver, String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickElementByXpath(WebDriver driver, String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clickElementByLinkText(WebDriver driver, String name){
        driver.findElement(By.linkText(name)).click();
    }
    public void setText(WebDriver driver, String name, String text){
        driver.findElement(By.name(name)).sendKeys(text);
    }
    public void selectItem(WebDriver driver, String id, String item){
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByVisibleText(item);

    }
}
