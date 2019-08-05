import Enums.DriverTypeEnum;
import Enums.PayBillsTabEnum;
import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PayBillsPage;
import Pages.SubPages.AddNewPayee;
import Pages.SubPages.AddNewPayeeAfterAdd;
import Utlis.BasePage;
import Utlis.ConfigurationConstants;
import Utlis.DriverFactory;
import Utlis.PayBillsTabsFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
public class testIfPayBillsTabAddNewPayeeWorksCorrectlyTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountSummaryPage accountSummaryPage;
    private PayBillsPage payBillsPage;
    private AddNewPayee addNewPayee;
    private AddNewPayeeAfterAdd addNewPayeeAfterAdd;
    @BeforeTest
    private void before() {
        driver = DriverFactory.createDriverForBrowserWithValue(DriverTypeEnum.GOOGLE_CHROME_DRIVER);
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(ConfigurationConstants.BASE_URL, homePage);
        loginPage = homePage.clickButtonSigin();
        accountSummaryPage = loginPage.siginUsingCredentials
                (ConfigurationConstants.USERNAME_COURSE, ConfigurationConstants.PASSWORD_COURSE);
        payBillsPage=accountSummaryPage.clickPayBillsTab();
         addNewPayee= (AddNewPayee) payBillsPage.goToTab(PayBillsTabEnum.ADDNEWPAYEE);
        addNewPayeeAfterAdd= addNewPayee.addNewPayee(ConfigurationConstants.PAYEE_NAME,ConfigurationConstants.PAYEE_ADDRESS,ConfigurationConstants.PAYEE_ACCOUNT,ConfigurationConstants.PAYEE_DETAILS);

    }
    @Test
    void CheckIfPayeeAddedSuccessfully(){
        String value=addNewPayeeAfterAdd.getAlertValue();
        Assert.assertEquals(value,"The new payee PayeeName was successfully created.");
    }
}
