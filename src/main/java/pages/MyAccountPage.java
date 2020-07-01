package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Page {
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public SignInPage clickOnSignOut(){
        signOutButton.click();
        return new SignInPage(driver);
    }
}
