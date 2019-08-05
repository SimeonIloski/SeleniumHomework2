package Pages;

import Pages.SubPages.AddNewPayee;
import Utlis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage {
    public PayBillsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return null;
    }
    @FindBy(linkText = "Add New Payee")
    WebElement tabElement;

    public AddNewPayee goToTab(){
        tabElement.click();
     return new AddNewPayee(getWebDriver());
    }


}
