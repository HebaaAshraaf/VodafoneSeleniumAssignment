package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateYourAccountPage extends Page {
    //I wrote those elements that're required only
    @FindBy(id = "customer_firstname")
    WebElement firstName; //input
    @FindBy(id = "customer_lastname")
    WebElement lastName; //input
    @FindBy(id = "email")
    WebElement email; //input
    @FindBy(id = "passwd")
    WebElement passwd; //At Least 5 Characters
    @FindBy(id = "address1")
    WebElement firstAddress; //input: Street address, P.O. Box, Company name, etc.
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "postcode")
    WebElement postCode;
    @FindBy(id = "id_country")
    WebElement countryDropDownMenu;
    @FindBy(id = "id_state")
    WebElement stateDropDownMenu;
    @FindBy(id = "phone_mobile")
    WebElement phoneNum;
    @FindBy(id = "submitAccount")
    WebElement registerButton;

    //for Dropdown Menus
    Select dropdown;

    public CreateYourAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter First name in YOUR PERSONAL INFORMATION section")
    public void enterFirstNameInPersonalInfo(String fName) {
        firstName.sendKeys(fName);
    }

    @Step("Enter Last name in YOUR PERSONAL INFORMATION section")
    public void enterLastNameInPersonalInfo(String lName) {
        lastName.sendKeys(lName);
    }

    @Step("Enter Email in YOUR PERSONAL INFORMATION section")
    public void enterEmailInPersonalInfo(String email) {
        this.email.sendKeys(email);
    }

    @Step("Enter Password in YOUR PERSONAL INFORMATION section")
    public void enterPasswordInPersonalInfo(String passwd) {
        this.passwd.sendKeys(passwd);
    }

    @Step("Enter Address in YOUR ADDRESS section")
    public void enterAddressInAddInfo(String add) {
        firstAddress.sendKeys(add);
    }

    @Step("Enter City in YOUR ADDRESS section")
    public void enterCityInAddInfo(String city) {
        this.city.sendKeys(city);
    }

    @Step("Enter Zip/Postal Code in YOUR ADDRESS section")
    public void enterPostalCodeInAddInfo(String zipcode) {
        postCode.sendKeys(zipcode);
    }

    @Step("Select Country in YOUR ADDRESS section")
    public void selectCountryInAddInfo(String country) {
        dropdown = new Select(countryDropDownMenu);
        dropdown.selectByVisibleText(country);
    }

    @Step("Select State in YOUR ADDRESS section")
    public void selectStateInAddInfo(String country) {
        dropdown = new Select(stateDropDownMenu);
        dropdown.selectByVisibleText(country);
    }

    @Step("Enter your Mobile phone in YOUR ADDRESS section")
    public void enterMobilePhoneInAddInfo(String mobPhone) {
        phoneNum.sendKeys(mobPhone);
    }

    @Step("Submit your registeration and Go to MY ACCOUNT page")
    public MyAccountPage clickOnRegisterButton() {
        registerButton.click();
        return new MyAccountPage(driver);
    }
}
