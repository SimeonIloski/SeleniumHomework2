package Pages.SubPages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;

public class PurchaseForeignCurrency extends BasePage {
    public PurchaseForeignCurrency(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
}
