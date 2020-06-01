package CartPageTest;

import Base.BaseClass;
import Pages.CartPage.CartPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class CartPageTest extends BaseClass {
    CartPage cartPage;


    public CartPageTest() {
        super();
    }

    @BeforeClass
    public void run() {
        driverInitialization();
        cartPage = new CartPage();
    }

    @AfterMethod
    public void screenShot(ITestResult testResult) throws IOException {
        screenShotOnFailure(testResult);
    }

    @Parameters("test")
    @AfterClass
    public void quit(String parameter) throws IOException, InterruptedException {
        // "if" checks is it single test case or it is part of whole test
        // if this is "full test" it will not kill current session
        if (!parameter.equalsIgnoreCase("full test")) {
            killWindowsProcessAfterTestFinished();
            driver.quit();
        }
    }

    // Each step has own test


    //Check Delivery price
    @Test(priority = 1)
    public void checkDeliveryPrice() {
        Assert.assertEquals(cartPage.getDeliveryPriceFromCart(), 30.0);
    }
    // Check Total price -> sum of delivery & milk price
    @Test(priority = 2)
    public void checkTotalPrice() {
        Assert.assertEquals(cartPage.getTotalPriceFromCart(),
                Double.sum(cartPage.getDeliveryPriceFromCart(), cartPage.getMilkPriceFromCart()));
    }
    // Prints result
    @Test(priority = 3)
    public void printPrices() {
        System.out.println(" Milk price is : " + cartPage.getMilkPriceFromCart() + " ₪ "
                +"\n Delivery price is : " + cartPage.getDeliveryPriceFromCart() + " ₪ "
                + "\n Total price is : " + Double.sum(cartPage.getMilkPriceFromCart(), cartPage.getDeliveryPriceFromCart()) + " ₪ ");
    }
    //Removes product from cart
    @Test(priority = 4)
    public void removeProductFromCart() {
        cartPage.removeProductFromCart();
    }
}
