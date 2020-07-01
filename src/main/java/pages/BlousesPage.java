package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends Page {

    @FindBy(xpath = "//a[@title='Blouse' and contains(text(),'Blouse')]")
    WebElement blouseProduct;

    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the first resulted product")
    public ProductPage clickOnBlouseProduct() {
        blouseProduct.click();
        return new ProductPage(driver);
    }

}
