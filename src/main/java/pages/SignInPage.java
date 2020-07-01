package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page {

    //Register
    @FindBy(id = "email_create")
    WebElement registerEmail;
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccButton;
    //login
    @FindBy(id = "email")
    WebElement loginEmail;
    @FindBy(id = "passwd")
    WebElement loginPasswd;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter Email in CREATE AN ACCOUNT Section")
    public void enterEmailInCreateAnAcc(String email) {
        registerEmail.sendKeys(email);
    }

    @Step("Click on Create an account button")
    public CreateYourAccountPage enterSubmitCreate() {
        createAnAccButton.click();
        return new CreateYourAccountPage(driver);
    }

    @Step("Enter Email in ALREADY REGISTERED Section")
    public void enterEmailInAlreadyReg(String email) {
        loginEmail.sendKeys(email);
    }

    @Step("Enter Password in ALREADY REGISTERED Section")
    public void enterPasswordInAlreadyReg(String passwd) {
        loginPasswd.sendKeys(passwd);
    }

    @Step("Click on Sign in button")
    public MyAccountPage clickSignInButton() {
        signInButton.click();
        return new MyAccountPage(driver);
    }
}
