package StartPageTest;

import Base.BaseClass;
import Pages.StratPage.StartPage;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;


public class StartPageTest extends BaseClass {

    StartPage startPage;

    StartPageTest() {
        super();
    }

    @BeforeClass
    public void run() throws MalformedURLException {
        driverInitialization();
        startPage = new StartPage();
    }

    @AfterMethod
    public void screenShot(ITestResult testResult) throws IOException {
        screenShotOnFailure(testResult);
    }

    @Parameters("test")
    @AfterClass
    public void quit(String parameter) throws IOException {
        // "if" checks is it`s single test case or it is part of whole test
        // if this is "full test" in suite it wont kill current session
        if (!parameter.equalsIgnoreCase("full test")) {
            killWindowsProcessAfterTestFinished();
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        Assert.assertTrue(startPage.verifyPageTitle(), prop.getProperty("start_page_title"));
    }


}
