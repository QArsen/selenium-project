package Pages.LoginPage;

import Base.BaseClass;
import Base.Elements;
import org.openqa.selenium.WebElement;


public class LoginPage extends BaseClass {


    public void loginAsValidUser(String  username, String password, WebElement element){
        waitForElementIsPresent(Elements.login_link).click();
        waitForElementIsPresent(Elements.credentials.get(0)).sendKeys(username);
        waitForElementIsPresent(Elements.credentials.get(1)).sendKeys(password);
        waitForElementIsPresent(element).click();
    }

    public String verifyLoggedInUserName() {
        return waitForElementIsPresent(Elements.user_name).getText().trim();
    }

    public String verifyPageLogo() {
        return waitForElementIsPresent(Elements.page_logo).getText().trim();
    }
}
