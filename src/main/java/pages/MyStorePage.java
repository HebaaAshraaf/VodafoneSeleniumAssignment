package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStorePage extends Page {

    @FindBy(xpath = "//button/span[contains(text(),'I confirm my order')]")
    WebElement confirmOrderButton;
    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrders;

    public MyStorePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'I confirm my order'")
    public OrderHistoryPage clickOnConfirmOrder() {
        confirmOrderButton.click();
        return new OrderHistoryPage(driver);
    }

    @Step("Click on 'Back to orders'")
    public OrderHistoryPage clickBackToOrders() {
        backToOrders.click();
        return new OrderHistoryPage(driver);
    }

}
