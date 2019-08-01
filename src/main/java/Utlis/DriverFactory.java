package Utlis;

import Enums.DriverTypeEnum;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private final static String GOOGLE_CHROME_SET_UP_NAME = "webdriver.chrome.driver";
    private final static String GOOGLE_CHROME_SET_UP_PATH = "src/main/resources/Drivers/chromedriver.exe";

    private final static String FIREFOX_SET_UP_NAME = "webdriver.gecko.driver";
    private final static String FIREFOX_SET_UP_PATH = "src/main/resources/Drivers/geckodriver.exe";

    public static WebDriver createDriverForBrowserWithValue(DriverTypeEnum driverType) {


        WebDriver driver = null;
        if (driverType.equals(DriverTypeEnum.GOOGLE_CHROME_DRIVER)) {
//            System.setProperty(GOOGLE_CHROME_SET_UP_NAME, GOOGLE_CHROME_SET_UP_PATH);
            //latest version
//            ChromeDriverManager.getInstance().setup();
            //get driver 2.34 version
            ChromeDriverManager.getInstance().version("2.40").setup();
            driver = new ChromeDriver();
        }
        if (driverType.equals(DriverTypeEnum.FIRE_FOX_DRIVER)) {
//            System.setProperty(FIREFOX_SET_UP_NAME, FIREFOX_SET_UP_PATH);
            //latest version
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        if (driver == null) {
            throw new RuntimeException("The driver wasn't initialised");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
