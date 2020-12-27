package MilkProductsCustomListPageTest;

import Base.BaseClass;
import Pages.MilkProductsCustomListPage.MilkProductsCustomListPage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;

public class MilkProductsCustomListPageTest extends BaseClass {

    MilkProductsCustomListPage milkProductsCustomListPage;


    @BeforeClass
    public void run() {
        driverInitialization();
        milkProductsCustomListPage = new MilkProductsCustomListPage();
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


    @Test(priority = 2)
    public void selectFilterFromCheapToExpensive() {
        milkProductsCustomListPage.selectFilterFromCheapToExpensive();
    }

    @Test(priority = 3)
    public void clickOnSearchIcon() {
        milkProductsCustomListPage.clickOnSearchIcon();
    }

    @Test(priority = 4)
    public void clickOnListButton() {
        milkProductsCustomListPage.clickOnListButton();
    }

    @Test(priority = 5)
    public void findYourCheapestMilkInListAndClickOnIt() {
        milkProductsCustomListPage.findYourCheapestMilkInListAndClickOnIt();
    }

    @Test(priority = 6)
    public void clickOnAddToCartButton() {
        milkProductsCustomListPage.clickOnAddToCartButton();
    }

    @Test(priority = 7)
    public void clickOnCloseButtonAtTheAddToCartPopup() {
        milkProductsCustomListPage.clickOnCloseButtonAtTheAddToCartPopup();
    }
}
