package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //CONSTRUCTOR
    public HomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.ID, using = "ext-gen185")
    private WebElement buttonUsers;

    @FindBy(how = How.ID, using = "ext-gen192")
    private WebElement buttonCustomers;

    //METHODS
    public HomePage clickButtonUsers(WebDriver driver){
        buttonUsers.click();
        return this;
    }
    public HomePage clickButtonCustomers(WebDriver driver){
        buttonCustomers.click();
        return this;
    }

}
