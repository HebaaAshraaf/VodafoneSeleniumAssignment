package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pages.HomePage;
import readers.JSONReader;

public class BaseTest {
    //Pages
    protected HomePage homePage;
    //browser name
    protected String browserName;
    //json reader
    protected JSONReader reader;
    //webDriver
    private WebDriver driver;

    @Step("Open Browser {0}")
    @BeforeTest
    @Parameters("browser")
    public void browserSetups(String browser) throws Exception {
        browserName = browser.toLowerCase();
        //The Cross Browser tests setup
        //Check if parameter passed from TestNG is 'firefox'
        if (browserName.equalsIgnoreCase("firefox")) {
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browserName.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'internet explorer'
        else if (browserName.equalsIgnoreCase("edge")) {
            //set path to internet_explorer.exe
            WebDriverManager.edgedriver().setup();
            //create internet explorer instance
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser name is not correct or not supported now");
        }
    }

    @Step("Set the required dimension")
    @BeforeTest
    public void sizeSetups() {
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage(driver);
        homePage.goToHomePageURL();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Step("Close the browser")
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
