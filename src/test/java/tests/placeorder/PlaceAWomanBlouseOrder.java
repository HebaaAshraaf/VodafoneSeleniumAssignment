package tests.placeorder;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import tests.login.SignInTest;
import utils.reports.AllureListener;

import static org.testng.Assert.assertEquals;

@Listeners({AllureListener.class})
@Epic("Automation Tests")
@Feature("Place an order")
public class PlaceAWomanBlouseOrder extends SignInTest {
    //Pre Condition Login is Required
    @Test(dependsOnMethods = {"signinWithValidDataTest"}, description = "Validate order will be placed in order history page when submit it")
    @Description("Test Description: Order Placed Validation")
    public void orderPlacedSuccessfulTest() {
        homePage.hoverOnWomenCategory();
        BlousesPage blousesPage = homePage.clickOnBlouseSubcategory();
        ProductPage productPage = blousesPage.clickOnBlouseProduct();
        productPage.clickOnAddToCard();
        OrderSummaryPage orderSummaryPage = productPage.clickOnProceedToCheckOut();
        OrderAddressPage addressPage = orderSummaryPage.clickOnProceedToCheckOut();
        OrderShippingPage shippingPage = addressPage.clickOnProceedToCheckOut();
        shippingPage.clickOnAgreeentCheckbox();
        OrderPaymentPage paymentPage = shippingPage.clickOnProceedToCheckOut();
        String expected = paymentPage.getTotalPrice();
        MyStorePage myStorePage = paymentPage.clickOnPayByBankWire();
        myStorePage.clickOnConfirmOrder();
        OrderHistoryPage orderHistoryPage = myStorePage.clickBackToOrders();
        orderHistoryPage.clickOnFirstOrderDerails();
        assertEquals(orderHistoryPage.getTheProductDetails(), expected, "Order " +
                "is not placed well");
    }
}
