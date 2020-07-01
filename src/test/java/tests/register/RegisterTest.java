package tests.register;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreateYourAccountPage;
import pages.MyAccountPage;
import pages.SignInPage;
import readers.JSONReader;
import tests.base.BaseTest;
import utils.reports.AllureListener;

import static org.testng.Assert.assertEquals;


@Listeners({AllureListener.class})
@Epic("Automation Tests")
@Feature("Registration")
public class RegisterTest extends BaseTest {

    @DataProvider
    public Object[][] registerData() {
        reader = new JSONReader();
        return reader.registerDataReader();
    }

    @Test(dataProvider = "registerData", description = "Register with Valid Data to Create a new user")
    @Description("Test Description: Create a valid new user")
    public void createValidNewUserTest(String firstName, String lastName, String email, String passwd,
                                       String firstAddress, String city, String postcode, String country,
                                       String state, String phone_mobile) {
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailInCreateAnAcc(email);
        CreateYourAccountPage createYourAccountPage = signInPage.enterSubmitCreate();
        createYourAccountPage.enterFirstNameInPersonalInfo(firstName);
        createYourAccountPage.enterLastNameInPersonalInfo(lastName);
        createYourAccountPage.enterPasswordInPersonalInfo(passwd);
        createYourAccountPage.enterAddressInAddInfo(firstAddress);
        createYourAccountPage.enterCityInAddInfo(city);
        createYourAccountPage.enterPostalCodeInAddInfo(postcode);
        createYourAccountPage.selectCountryInAddInfo(country);
        createYourAccountPage.selectStateInAddInfo(state);
        createYourAccountPage.enterMobilePhoneInAddInfo(phone_mobile);
        MyAccountPage accountPage = createYourAccountPage.clickOnRegisterButton();
        assertEquals(accountPage.getPageTitle(), "My account - My Store", "The Register Test Failed");
    }
}
