package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
