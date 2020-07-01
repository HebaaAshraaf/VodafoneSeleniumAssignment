package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    //Actions
    Actions actions;

    //Locators
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(xpath = "//a[@title='Blouses']")
    WebElement blouseSubcategory;
    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Go To Automation Practice Home Page")
    public void goToHomePageURL() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Step("Go To Login Page")
    public SignInPage clickOnSignInButton() {
        signInButton.click();
        return new SignInPage(driver);
    }

    @Step("Mouse Hover on Women Category")
    public void hoverOnWomenCategory() {
        actions = new Actions(driver);
        actions.moveToElement(womenCategory).perform();
    }

    @Step("Click On Blouse Subcategory")
    public BlousesPage clickOnBlouseSubcategory() {
        actions = new Actions(driver);
        actions.moveToElement(womenCategory).moveToElement(blouseSubcategory).click().build().perform();
        return new BlousesPage(driver);
    }

}
