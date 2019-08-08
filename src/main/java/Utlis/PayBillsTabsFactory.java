package Utlis;

import Enums.PayBillsTabEnum;
import Pages.Components.AddNewPayee;
import Pages.Components.PaySavedPayee;
import Pages.Components.PurchaseForeignCurrency;
import org.openqa.selenium.WebDriver;

public class PayBillsTabsFactory {
public static BasePage getPayBilssApropriateTab(PayBillsTabEnum classCode, WebDriver webDriver){
    BasePage basePage=null;
    if(classCode.equals(PayBillsTabEnum.PAYSAVEDPAYEE))
        basePage= new PaySavedPayee(webDriver);
    if(classCode.equals(PayBillsTabEnum.ADDNEWPAYEE))
       basePage=  new AddNewPayee(webDriver);
    if(classCode.equals(PayBillsTabEnum.PURCHASEFOREIGNCURRENCY))
        basePage=  new PurchaseForeignCurrency(webDriver);
    return basePage;
}
}
