package Pages.LoginPage;

import Base.BaseClass;
import Base.Elements;


public class LoginPage extends BaseClass {



    public LoginPage clickOnLoginLink() {
        Elements.login_link.click();
        return this;
    }

    public LoginPage interUserName() {
        Elements.credentials.get(0).sendKeys(prop.getProperty("username"));
        return this;
    }

    public LoginPage enterPassword() {
        Elements.credentials.get(1).sendKeys(prop.getProperty("password"));
        return this;
    }

    public LoginPage clickOnLoginButton() {
        Elements.login_button.click();
        return this;
    }

    public String verifyLoggedInUserName() {
        String user = waitForElementIsPresent(Elements.user_name).getText().trim();
        return user;
    }

    public String verifyPageLogo() {
        String user = waitForElementIsPresent(Elements.page_logo).getText().trim();
        return user;
    }
}
