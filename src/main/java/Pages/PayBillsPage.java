package Pages;

import Enums.PayBillsTabEnum;
import Utlis.BasePage;
import Utlis.PayBillsTabsFactory;
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
    @FindBy(linkText = "Pay Saved Payee")
    WebElement tabElementPaySavedPayee;

    @FindBy(linkText = "Add New Payee")
    WebElement tabElementAddNewPayee;
    @FindBy(linkText = "Purchase Foreign Currency")
    WebElement tabElementPurchaseForeignCurrency;


    public BasePage goToTab(PayBillsTabEnum tabText){
       BasePage basePage=null;
        if(tabText.equals(PayBillsTabEnum.PAYSAVEDPAYEE)){
           tabElementPaySavedPayee.click();
           basePage= PayBillsTabsFactory.getPayBilssApropriateTab(PayBillsTabEnum.PAYSAVEDPAYEE,getWebDriver());
       }
        if(tabText.equals(PayBillsTabEnum.ADDNEWPAYEE)){
            tabElementAddNewPayee.click();
            basePage= PayBillsTabsFactory.getPayBilssApropriateTab(PayBillsTabEnum.ADDNEWPAYEE,getWebDriver());
        }
        if(tabText.equals(PayBillsTabEnum.PURCHASEFOREIGNCURRENCY)){
            tabElementPurchaseForeignCurrency.click();
            basePage= PayBillsTabsFactory.getPayBilssApropriateTab(PayBillsTabEnum.PURCHASEFOREIGNCURRENCY,getWebDriver());
        }
     return basePage;
    }


}
