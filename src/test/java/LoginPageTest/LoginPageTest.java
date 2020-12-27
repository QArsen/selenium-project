package LoginPageTest;

import Base.BaseClass;
import Base.Elements;
import Pages.LoginPage.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;


public class LoginPageTest extends BaseClass {

    LoginPage loginPage;


    public LoginPageTest() {
        super();
    }


    @BeforeClass
    public void run() {
        driverInitialization();
        loginPage = new LoginPage();
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

    // Using Fluent interface
    @Parameters("test status")
    @Test
    public void loginPageTest() {
        loginPage.loginAsValidUser(prop.getProperty("username"),prop.getProperty("password"), Elements.login_button);
        Assert.assertEquals(loginPage.verifyLoggedInUserName(), "שלום ארסן");
        Assert.assertEquals(loginPage.verifyPageLogo(), "התחלת קניה ב");
    }
}
