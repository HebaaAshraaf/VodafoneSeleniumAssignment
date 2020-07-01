package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends Page {

    @FindBy(xpath = "//p/a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Proceed To Checkout in the order summary page")
    public OrderAddressPage clickOnProceedToCheckOut() {
        proceedToCheckoutButton.click();
        return new OrderAddressPage(driver);
    }

}
