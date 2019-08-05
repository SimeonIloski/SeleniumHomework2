package Pages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPage extends BasePage {
    public AccountSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new AccountSummaryPage(driver);
    }
}
