package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderShippingPage extends Page {
    @FindBy(id = "cgv")
    WebElement agreementCheckbox;

    @FindBy(name = "processCarrier")
    WebElement proceedToCheckoutButton;


    public OrderShippingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Proceed To Checkout in the shipping page")
    public OrderPaymentPage clickOnProceedToCheckOut() {
        proceedToCheckoutButton.click();
        return new OrderPaymentPage(driver);
    }

    @Step("Click on agreeent checkbox")
    public void clickOnAgreeentCheckbox() {
        agreementCheckbox.click();
    }

}
