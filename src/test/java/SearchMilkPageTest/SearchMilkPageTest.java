package SearchMilkPageTest;

import Base.BaseClass;
import Pages.SearchMilkPage.SearchMilkPage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;


public class SearchMilkPageTest extends BaseClass {

    SearchMilkPage searchMilkAndAddToCartPage;

    public SearchMilkPageTest() {
        super();
    }

    @BeforeClass
    public void run() {
        driverInitialization();
        searchMilkAndAddToCartPage = new SearchMilkPage();
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
    @Test(priority = 1)
    public void searchMilkInSearchField() {
        searchMilkAndAddToCartPage.searchMilkInSearchField("חלב טרי");
    }

    @Test(priority = 2)
    public void clickOnToAllResultsLink() {
        searchMilkAndAddToCartPage.clickOnToAllResultsLink();
    }
}
