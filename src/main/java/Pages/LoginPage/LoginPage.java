package Pages.LoginPage;

import Base.BaseClass;
import Base.ElementsRepo;
import Base.ToolsManager;
import Logger.Log;
import org.openqa.selenium.By;


public class LoginPage extends BaseClass {

    public static void loginAsValidUser(String username, String password, By by){
        Log.debug("login with user " + username);
        ToolsManager.clickOnElement(ElementsRepo.login_link);
        ToolsManager.sendKeys(ElementsRepo.user_Name,username);
        ToolsManager.sendKeys(ElementsRepo.user_Password,password);
        ToolsManager.clickOnElement(by);
    }

    public static boolean verifyElementContentAfterLogin(By actual, String expected ) {
        String str =  ToolsManager.waitForElementIsPresent(actual).getText().trim();
         if(!str.equals(expected)){
             Log.error("Error : expected " + expected + " but found: " + str);
             return false;
         }
             return true;
    }
}
