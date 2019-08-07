import Enums.DriverTypeEnum;
import Enums.PayBillsTabEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import Pages.SubPages.AddNewPayee;
import Pages.SubPages.AddNewPayeeAfterAdd;
import Pages.SubPages.PaySavedPayee;
import Pages.SubPages.PaySavedPayeeAfterAdd;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test(priority = 1)
public class testIfPayBillsTabPaySavedPayeeWorksCorrectlyTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private PayBillsPage payBillsPage;
    private PaySavedPayee paySavedPayee;
    private PaySavedPayeeAfterAdd paySavedPayeeAfterAdd;
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
        paySavedPayee=(PaySavedPayee) payBillsPage.goToTab(PayBillsTabEnum.PAYSAVEDPAYEE);
        paySavedPayeeAfterAdd=paySavedPayee.clickOnAddButtton(ConfigurationConstants.PAYEE_DDL_CHOOSE,ConfigurationConstants.ACCOUNT_DDL_CHOOSE,
                ConfigurationConstants.AMMOUNT,ConfigurationConstants.DATE,ConfigurationConstants.DESCRIPTION);

    }
    @Test
    public void checkIfPaySavedPayeeAddSuccessfullyTest(){
        Assert.assertEquals(paySavedPayeeAfterAdd.getAlertValue(),"The payment was successfully submitted.");
    }
    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
