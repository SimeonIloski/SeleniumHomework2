import Enums.DriverTypeEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class testIfPayBillsTabsWprksCorrectly {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;


    @BeforeTest
    private void before() {
        driver = DriverFactory.createDriverForBrowserWithValue(DriverTypeEnum.GOOGLE_CHROME_DRIVER);
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(ConfigurationConstants.BASE_URL, homePage);
        loginPage = homePage.clickButtonSigin();
        accountSummaryPage = loginPage.siginUsingCredentials
                (ConfigurationConstants.USERNAME_COURSE, ConfigurationConstants.PASSWORD_COURSE);

    }
}
