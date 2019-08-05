package Pages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new AccountSummaryPage(driver);
    }
    @FindBy(id = "pay_bills_tab")
    WebElement payBissTab;

    public PayBillsPage clickPayBillsTab() {
        payBissTab.click();
        return new PayBillsPage(getWebDriver());
    }
}
