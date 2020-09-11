package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    //CONSTRUCTOR
    public UsersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.XPATH, using = "//td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonAction;

    @FindBy(how = How.LINK_TEXT, using = "Add User")
    private WebElement buttonAddUser;

    @FindBy(how = How.LINK_TEXT, using = "Delete User")
    private WebElement buttonDeleteUser;

    @FindBy(how = How.LINK_TEXT, using = "Edit User")
    private WebElement buttonEditUser;

    @FindBy(how = How.XPATH, using = "//td[4]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonLogout;

    //METHODS
    public UsersPage clickButtonAction (WebDriver driver){
        buttonAction.click();
        return this;
    }
    public UsersPage clickButtonAddUser(WebDriver driver){
        buttonAddUser.click();
        return this;
    }
    public UsersPage clickButtonDeleteUser(WebDriver driver){
        buttonDeleteUser.click();
        return this;
    }
    public UsersPage clickButtonEditUser(WebDriver driver){
        buttonEditUser.click();
        return this;
    }
    public UsersPage clickButtonLogout(WebDriver driver){
        buttonLogout.click();
        return this;
    }

}
