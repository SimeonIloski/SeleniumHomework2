package Pages.SubPages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;

public class AddNewPayee extends BasePage {
    public AddNewPayee(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
}
