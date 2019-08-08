package Components;

import Utlis.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchaseForeignCurrency extends BasePage {
    public PurchaseForeignCurrency(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
    @FindBy(id="pc_currency")
    WebElement currencyDDL;
    @FindBy(id="pc_amount")
    WebElement amountElement;
    @FindBy(id="pc_inDollars_true")
    WebElement radioButton;
    @FindBy(id="pc_calculate_costs")
    WebElement calculateCostsButton;
    @FindBy(id="purchase_cash")
    WebElement purchaseButton;
    void chooseFromPayeeCurrency(String payeeText){
        chooseFromDDSOptionContainsText(currencyDDL,payeeText);
    }
    void insertIntoAmount(String value){
        clearAndSendKeys(amountElement,value);
    }
    void clickOnButton(WebElement element){
        waitForElementToBeClickableAndClick(element);
    }

    public PurchaseForeignCurrencuAfterAdd clickOmPurchaseButton(String currency, String amount){
        chooseFromPayeeCurrency(currency);
        insertIntoAmount(amount);
        clickOnButton(radioButton);
        clickOnButton(calculateCostsButton);
        clickOnButton(purchaseButton);
        return new PurchaseForeignCurrencuAfterAdd(getWebDriver());
    }


    private void chooseFromDDSOptionContainsText(WebElement ddl, String itemText)  {
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
