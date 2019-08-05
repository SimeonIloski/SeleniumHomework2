import Enums.DriverTypeEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
public class testIfPayBillsTabsWprksCorrectlyTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private PayBillsPage payBillsPage;

    @BeforeTest
    private void before() {
        driver = DriverFactory.createDriverForBrowserWithValue(DriverTypeEnum.GOOGLE_CHROME_DRIVER);
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(ConfigurationConstants.BASE_URL, homePage);
        loginPage = homePage.clickButtonSigin();
        accountSummaryPage = loginPage.siginUsingCredentials
                (ConfigurationConstants.USERNAME_COURSE, ConfigurationConstants.PASSWORD_COURSE);
        payBillsPage=accountSummaryPage.clickPayBillsTab();
    }
    @Test
    void donothing(){
        Assert.assertTrue(true);
    }
}
