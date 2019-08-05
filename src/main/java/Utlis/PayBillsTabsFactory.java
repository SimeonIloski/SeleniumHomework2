package Utlis;

import Pages.SubPages.AddNewPayee;
import Pages.SubPages.PaySavedPayee;
import Pages.SubPages.PurchaseForeignCurrency;
import org.openqa.selenium.WebDriver;

public class PayBillsTabsFactory {
public static BasePage getPayBilssApropriateTab(String classCode, WebDriver webDriver){
    BasePage basePage=null;
    if(classCode.equals("paySavedPayee"))
        basePage= new PaySavedPayee(webDriver);
    if(classCode.equals("addNewPayee"))
       basePage=  new AddNewPayee(webDriver);
    if(classCode.equals("purchaseForeignCurrency"))
        basePage=  new PurchaseForeignCurrency(webDriver);
    return basePage;
}
}
