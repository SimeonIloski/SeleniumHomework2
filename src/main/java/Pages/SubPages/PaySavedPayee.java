package Pages.SubPages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;

public class PaySavedPayee extends BasePage {
    public PaySavedPayee(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
}
