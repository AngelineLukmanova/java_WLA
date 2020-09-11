package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //CONSTRUCTOR
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.NAME, using = "j_branch")
    private WebElement branchName;

    @FindBy(how = How.NAME, using = "j_username")
    private WebElement branchAdmin;

    @FindBy(how = How.NAME, using = "j_password" )
    private WebElement branchPassword;

    @FindBy(how = How.ID, using = "ext-gen38")
    private WebElement loginButton;

    //METHODS
        public LoginPage setBranchName(WebDriver driver, String branchName){
            this.branchName.sendKeys(branchName);
            return this;
        }
        public  LoginPage setBranchAdmin (WebDriver driver, String branchAdmin){
            this.branchAdmin.sendKeys(branchAdmin);
            return this;
        }
        public LoginPage setBranchPassword (WebDriver driver, String branchPassword){
            this.branchPassword.sendKeys(branchPassword);
            return this;
        }
        public LoginPage clickLoginButtom (WebDriver driver){
            loginButton.click();
            return this;
        }
    }
