package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SignInPage;
import readers.JSONReader;
import tests.base.BaseTest;
import tests.register.RegisterTest;
import utils.reports.AllureListener;

import static org.testng.Assert.assertEquals;

@Listeners({AllureListener.class})
@Epic("Automation Tests")
@Feature("Sign In")
public class SignInTest extends BaseTest{
    @DataProvider
    public Object[][] signInData() {
        reader = new JSONReader();
        return reader.signInDataReader();
    }

    @Test(dataProvider = "signInData", description = "Sign In with Valid Data")
    @Description("Test Description: Sign In with valid data")
    public void signinWithValidDataTest(String email, String passwd) {
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailInAlreadyReg(email);
        signInPage.enterPasswordInAlreadyReg(passwd);
        MyAccountPage accountPage = signInPage.clickSignInButton();
        assertEquals(accountPage.getPageTitle(), "My account - My Store", "The Sign-in Test Failed");
    }
}
