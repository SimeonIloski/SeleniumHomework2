package Components;

import Utlis.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaySavedPayee extends BasePage {
    @FindBy(id="sp_amount")
    WebElement amountElement;
    @FindBy(id="sp_description")
    WebElement descriptionElement;
    @FindBy(id="sp_payee")
    WebElement ddlPayee;
    @FindBy(id="sp_account")
    WebElement ddlAccount;
    @FindBy(id="sp_date")
    WebElement payeeDateElement;
    @FindBy(id="pay_saved_payees")
    WebElement addButton;
    public PaySavedPayee(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }



    void chooseFromPayee(String payeeText){
        chooseFromDDSOptionContainsText(ddlPayee,payeeText);
    }
    void chooseFromAccount(String payeeText){
        chooseFromDDSOptionContainsText(ddlAccount,payeeText);
    }
    void insertIntoAmount(String value){
        clearAndSendKeys(amountElement,value);
    }
    void insertIntoDate(String value){
        clearAndSendKeys(payeeDateElement,value);

    }
    void clickAddButton(){
        waitForElementToBeClickableAndClick(addButton);
    }
    void insertDescription(String desc){
        clearAndSendKeys(descriptionElement,desc);
    }
    public PaySavedPayeeAfterAdd clickOnAddButtton(String payee,String account,String amount,String dateValue,String descripton){
        chooseFromPayee(payee);
        chooseFromAccount(account);
        insertIntoAmount(amount);
        insertIntoDate(dateValue);
        insertDescription(descripton);
        clickAddButton();
        return new PaySavedPayeeAfterAdd(getWebDriver());
    }


    private void chooseFromDDSOptionContainsText(WebElement ddl, String itemText) {
        ddl.click();
        List<WebElement> ddlFromAccountsOptions = waitAndFindElements(ddl, By.tagName("option"));
        for (WebElement ddlFromAccountsOption : ddlFromAccountsOptions) {
            String optionText = ddlFromAccountsOption.getText();
            if (optionText.contains(itemText)) {
                ddlFromAccountsOption.click();
                break;
            }
        }
        ddl.click();
    }
}
