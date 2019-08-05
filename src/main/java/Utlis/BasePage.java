package Utlis;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
public abstract class BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, ConfigurationConstants.MAX_RETRY_FOR_LOCATING_ELEMENT);
        this.ajaxElementLocatorFactory = new AjaxElementLocatorFactory(webDriver, ConfigurationConstants.MAX_RETRY_FOR_LOCATING_ELEMENT_AJAX_FACTORY);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
        this.actions = new Actions(webDriver);
        this.javascriptExecutor = (JavascriptExecutor) webDriver;
    }

    public void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

    public abstract BasePage newInstance(WebDriver driver);

    public <T extends BasePage> BasePage navigateTo(String url, T type) {
        webDriver.get(url);
        return type.newInstance(webDriver);
    }

    public void clearAndSendKeys(WebElement element, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        moveToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitForElementToBeClickableAndClick(WebElement elem) {
        moveToElement(elem);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    public WebElement waitAndFindElement(WebElement root, By byLocator) {
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, byLocator));
        return root.findElement(byLocator);
    }

    protected WebElement waitAndFindElementFromRoot(By byLocator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
        return webDriver.findElement(byLocator);
    }

    protected List<WebElement> waitAndFindElements(WebElement root, By byLocator) {
        webDriverWait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(root, byLocator));
        return root.findElements(byLocator);
    }
}
