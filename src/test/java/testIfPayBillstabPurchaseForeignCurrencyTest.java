import Enums.DriverTypeEnum;
import Enums.PayBillsTabEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import Pages.SubPages.PaySavedPayee;
import Pages.SubPages.PaySavedPayeeAfterAdd;
import Pages.SubPages.PurchaseForeignCurrencuAfterAdd;
import Pages.SubPages.PurchaseForeignCurrency;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test(priority = 3)
public class testIfPayBillstabPurchaseForeignCurrencyTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private PayBillsPage payBillsPage;
    private PurchaseForeignCurrency purchaseForeignCurrency;
    private PurchaseForeignCurrencuAfterAdd purchaseForeignCurrencuAfterAdd;
    WebDriver driver;
    @BeforeTest
    private void before() {
         driver = DriverFactory.createDriverForBrowserWithValue(DriverTypeEnum.GOOGLE_CHROME_DRIVER);
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(ConfigurationConstants.BASE_URL, homePage);
        loginPage = homePage.clickButtonSigin();
        accountSummaryPage = loginPage.siginUsingCredentials
                (ConfigurationConstants.USERNAME_COURSE, ConfigurationConstants.PASSWORD_COURSE);
        payBillsPage=accountSummaryPage.clickPayBillsTab();
        purchaseForeignCurrency=(PurchaseForeignCurrency) payBillsPage.goToTab(PayBillsTabEnum.PURCHASEFOREIGNCURRENCY);
        purchaseForeignCurrencuAfterAdd=purchaseForeignCurrency.clickOmPurchaseButton(ConfigurationConstants.CURRENCY,ConfigurationConstants.AMMOUNT);

    }
    @Test
    public void checkIfPurchaseForeignCurrencyWorkingCorrectlyTest(){
        Assert.assertEquals(purchaseForeignCurrencuAfterAdd.getAlertValue(),"Foreign currency cash was successfully purchased.");
    }
    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
