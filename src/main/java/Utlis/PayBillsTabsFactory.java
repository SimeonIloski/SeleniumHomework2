package Utlis;

import Enums.PayBillsTabEnum;
import Components.AddNewPayee;
import Components.PaySavedPayee;
import Components.PurchaseForeignCurrency;
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
