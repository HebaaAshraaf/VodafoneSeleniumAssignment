package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage extends Page {

    @FindBy(xpath = "//tr[@class='totalprice item']/td/span")
    WebElement productPriceDetails;

    @FindBy(xpath = "(//tr[@class='first_item ']//a)[1]")
    WebElement orderDetails;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on First order details")
    public void clickOnFirstOrderDerails() {
        orderDetails.click();
        PageFactory.initElements(this.driver, this);
    }

    @Step("Get the product details")
    public String getTheProductDetails() {
        System.out.println("Actual: " + productPriceDetails.getText());
        return productPriceDetails.getText(); //Blouse - Color : Black, Size : S
    }
}
