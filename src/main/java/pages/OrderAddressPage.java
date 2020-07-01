package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderAddressPage extends Page {

    @FindBy(name = "processAddress")
    WebElement proceedToCheckoutButton;

    public OrderAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Proceed To Checkout in the Address page")
    public OrderShippingPage clickOnProceedToCheckOut() {
        proceedToCheckoutButton.click();
        return new OrderShippingPage(driver);
    }
}
