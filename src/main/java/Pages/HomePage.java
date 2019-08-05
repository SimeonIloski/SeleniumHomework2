package Pages;

import Utlis.BasePage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new HomePage(driver);
    }
    @FindBy(id="signin_button")
    WebElement signinButton;
    public LoginPage clickButtonSigin(){
        signinButton.click();
        return new LoginPage(getWebDriver());
    }
}
