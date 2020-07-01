package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPaymentPage extends Page {

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    WebElement payByBankOption;

    @FindBy(id = "total_price")
    WebElement totalPrice;

    public OrderPaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get The Total Price")
    public String getTotalPrice() {
        System.out.println("Expected: " + totalPrice.getText());
        return totalPrice.getText();
    }

    @Step("Click on Pay by bank wire")
    public MyStorePage clickOnPayByBankWire() {
        payByBankOption.click();
        return new MyStorePage(driver);
    }

}
