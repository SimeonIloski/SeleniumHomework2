package Pages;

import Utlis.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new LoginPage(driver);
    }
    @FindBy(id="user_login")
    private
    WebElement usernameElement;
    @FindBy(id="user_password")
    private
    WebElement passwordElement;
    @FindBy(id="user_remember_me")
    private
    WebElement buttonRememberMe;
    @FindBy(className = "btn-primary")
    private
    WebElement buttonLogin;
    private void insertUserName(String username){
        clearAndSendKeys(usernameElement,username);
    }
    private void insertPassword(String password){
        clearAndSendKeys(passwordElement,password);
    }
    private void clickRememberMe(){
        waitForElementToBeClickableAndClick(buttonRememberMe);
    }
    private void clickSignIn(){
        waitForElementToBeClickableAndClick(buttonLogin);
    }
    public AccountSummaryPage siginUsingCredentials(String username, String password){
        insertUserName(username);
        insertPassword(password);
        clickRememberMe();
        clickSignIn();
        return new AccountSummaryPage(getWebDriver());
    }
}
