package Pages.SubPages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForeignCurrencuAfterAdd extends BasePage {
    public PurchaseForeignCurrencuAfterAdd(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
    @FindBy(id="alert_content")
    WebElement alertElement;
    String getValue(WebElement webElement){
        return webElement.getText();
    }
    public String getAlertValue(){
        return getValue(alertElement);
    }
}
