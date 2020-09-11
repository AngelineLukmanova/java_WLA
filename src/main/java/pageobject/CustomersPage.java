package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    //CONSTRUCTOR
    public CustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //LOCATORS
    @FindBy(how = How.XPATH, using = "//td/table/tbody/tr/td[2]/em/button")
    private WebElement buttonAction;

    @FindBy(how = How.LINK_TEXT, using = "Add Customer")
    private WebElement buttonAddCustomer;

    @FindBy(how = How.LINK_TEXT, using = "Delete Customer")
    private WebElement buttonDeleteCustomer;

    @FindBy(how = How.LINK_TEXT, using = "Edit Customer")
    private WebElement buttonEditCustomer;

    @FindBy(how = How.XPATH, using = "//td[4]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonLogout;

    //METHODS
    public CustomersPage clickButtonAction(WebDriver driver){
        buttonAction.click();
        return this;
    }
    public CustomersPage clickButtonAddCustomer(WebDriver driver){
        buttonAddCustomer.click();
        return this;
    }
    public CustomersPage clickButtonDeleteCustomer(WebDriver driver){
        buttonDeleteCustomer.click();
        return this;
    }
    public CustomersPage clickButtonEditCustomer(WebDriver driver){
        buttonEditCustomer.click();
        return this;
    }
    public CustomersPage clickButtonLogout(WebDriver driver){
        buttonLogout.click();
        return this;
    }
}
