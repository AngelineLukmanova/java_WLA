package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    //CONSTRUCTOR
    public AddCustomerPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.NAME, using = "FirstName")
    private WebElement firstName;

    @FindBy(how = How.NAME, using = "LastName")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonOK;

    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonCancel;

    //METHODS
    public AddCustomerPage setFirstName(WebDriver driver, String firstName){
        this.firstName.sendKeys(firstName);
        return this;
    }
    public AddCustomerPage setLastName(WebDriver driver, String lastName){
        this.lastName.sendKeys(lastName);
        return this;
    }
    public AddCustomerPage clickButtonSave(WebDriver driver){
        buttonSave.click();
        return this;
    }
    public AddCustomerPage clickButtonOK(WebDriver driver){
        buttonOK.click();
        return this;
    }
    public AddCustomerPage clickButtonCancel(WebDriver driver){
        buttonCancel.click();
        return this;
    }

}
