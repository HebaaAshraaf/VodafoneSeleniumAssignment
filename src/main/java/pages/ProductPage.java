package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ProductPage extends Page {

    @FindBy(xpath = "//p[@id='add_to_cart']/button[@name='Submit']")
    WebElement addToCardButton;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Add to card Button")
    public void clickOnAddToCard() {
        addToCardButton.click();
    }

    @Step("Click on Proceed To Checkout in the Product page")
    public OrderSummaryPage clickOnProceedToCheckOut() {
        proceedToCheckoutButton.click();
        return new OrderSummaryPage(driver);
    }
}
