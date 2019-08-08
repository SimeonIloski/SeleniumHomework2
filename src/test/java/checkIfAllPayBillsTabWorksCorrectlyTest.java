import Enums.DriverTypeEnum;
import Enums.PayBillsTabEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import Components.*;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class checkIfAllPayBillsTabWorksCorrectlyTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private PayBillsPage payBillsPage;
    private AddNewPayee addNewPayee;
    private AddNewPayeeAfterAdd addNewPayeeAfterAdd;
    private PaySavedPayee paySavedPayee;
    private PaySavedPayeeAfterAdd paySavedPayeeAfterAdd;
    private PurchaseForeignCurrency purchaseForeignCurrency;
    private PurchaseForeignCurrencuAfterAdd purchaseForeignCurrencuAfterAdd;
    WebDriver driver;

    @BeforeClass
    private void before() {
        driver = DriverFactory.createDriverForBrowserWithValue(DriverTypeEnum.GOOGLE_CHROME_DRIVER);
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(ConfigurationConstants.BASE_URL, homePage);
        loginPage = homePage.clickButtonSigin();
        accountSummaryPage = loginPage.siginUsingCredentials
                (ConfigurationConstants.USERNAME_COURSE, ConfigurationConstants.PASSWORD_COURSE);
        payBillsPage = accountSummaryPage.clickPayBillsTab();

    }

    @Test(priority = 2)
    void CheckIfPayeeAddedSuccessfullyTest() {
        addNewPayee = (AddNewPayee) payBillsPage.goToTab(PayBillsTabEnum.ADDNEWPAYEE);
        addNewPayeeAfterAdd = addNewPayee.addNewPayee(ConfigurationConstants.PAYEE_NAME, ConfigurationConstants.PAYEE_ADDRESS, ConfigurationConstants.PAYEE_ACCOUNT, ConfigurationConstants.PAYEE_DETAILS);
        Assert.assertEquals(addNewPayeeAfterAdd.getAlertValue(), "The new payee PayeeName was successfully created.");
        addNewPayeeAfterAdd.clickClose();
    }

    @Test(priority = 1)
    public void checkIfPayeeSavedPaySuccessfullyTest() {
        paySavedPayee = (PaySavedPayee) payBillsPage.goToTab(PayBillsTabEnum.PAYSAVEDPAYEE);
        paySavedPayeeAfterAdd = paySavedPayee.clickOnAddButtton(ConfigurationConstants.PAYEE_DDL_CHOOSE, ConfigurationConstants.ACCOUNT_DDL_CHOOSE, ConfigurationConstants.AMMOUNT, ConfigurationConstants.DATE, ConfigurationConstants.DESCRIPTION);
        Assert.assertEquals(paySavedPayeeAfterAdd.getAlertValue(), "The payment was successfully submitted.");
        paySavedPayeeAfterAdd.closeClick();
    }

    @Test(priority = 3)
    public void checkIfPurchaseForeignCurrencySuccessfullyTest() {
        purchaseForeignCurrency=(PurchaseForeignCurrency) payBillsPage.goToTab(PayBillsTabEnum.PURCHASEFOREIGNCURRENCY);
        purchaseForeignCurrencuAfterAdd=purchaseForeignCurrency.clickOmPurchaseButton(ConfigurationConstants.CURRENCY,ConfigurationConstants.AMMOUNT);
        Assert.assertEquals(purchaseForeignCurrencuAfterAdd.getAlertValue(),"Foreign currency cash was successfully purchased.");
        purchaseForeignCurrencuAfterAdd.clickClose();
    }


    @AfterClass
    public void afterTest() {
              driver.close();
              driver.quit();
    }
}
