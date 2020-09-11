package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    //CONSTRUCTOR
    public AddUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.NAME, using = "Username")
    private WebElement Username;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement Password;

    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonOK;

    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]")
    private WebElement buttonCancel;

    //METHODS
    public AddUserPage setUsername(WebDriver driver, String user){
        Username.sendKeys(user);
        return this;
    }
    public AddUserPage setPassword(WebDriver driver, String password){
        Password.sendKeys(password);
        return this;
    }
    public AddUserPage clickButtonSave(WebDriver driver){
        buttonSave.click();
        return this;
    }
    public AddUserPage clickButtonOK(WebDriver driver){
        buttonOK.click();
        return this;
    }
    public AddUserPage clickButtonCancel(WebDriver driver){
        buttonCancel.click();
        return this;
    }

}
