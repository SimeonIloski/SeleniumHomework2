package Components;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayee extends BasePage {
    public AddNewPayee(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }

    @FindBy(id = "np_new_payee_name")
    WebElement payeeName;
    @FindBy(id="np_new_payee_address")
    WebElement payeeAddress;
    @FindBy(id="np_new_payee_account")
    WebElement payeeAccount;
    @FindBy(id="np_new_payee_details")
    WebElement payeeDetails;
    @FindBy(id="add_new_payee")
    WebElement buttonAdd;

    void insertIntoPayeeName(String name) {
        clearAndSendKeys(payeeName,name);
    }
    void insertIntoPayeeAddress(String address){
        clearAndSendKeys(payeeAddress,address);
    }
    void insertIntoPayeeAccount(String account){
        clearAndSendKeys(payeeAccount,account);
    }
    void insertIntoPayeeDetails(String details){
        clearAndSendKeys(payeeDetails,details);
    }
    void clickOnAddButton() {
        waitForElementToBeClickableAndClick(buttonAdd);
    }
    public AddNewPayeeAfterAdd addNewPayee(String name, String address, String account, String details){
        insertIntoPayeeName(name);
        insertIntoPayeeAddress(address);
        insertIntoPayeeAccount(account);
        insertIntoPayeeDetails(details);
        clickOnAddButton();
        return new AddNewPayeeAfterAdd(getWebDriver());
    }
}
