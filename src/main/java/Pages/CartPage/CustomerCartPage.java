package Pages.CartPage;

import Base.BaseClass;
import Base.ElementsRepo;
import Base.ToolsManager;
import Logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerCartPage extends BaseClass {

    public static double getPriceFromCart(By by)  {
        return getPriceFromCart(ToolsManager.waitForElementIsPresent(by));
    }

    public static double getTotalPriceFromCart(By by){
        return getPriceFromCart(ToolsManager.waitForElementIsPresent(by));
    }

    //Parsing String to double
    private static double  getPriceFromCart(WebElement element) {
        ToolsManager.waitForValueToChange(element);
        double price;
        String str = element.getText().trim().replaceAll("[^0-9.]+", " ");
        price = Double.parseDouble(str);
        return price;
    }

    public static void printTestResults()  {
        Log.info("printing tests results in console");
        System.out.println(" Milk price is : " + CustomerCartPage.getPriceFromCart(ElementsRepo.milk_price) + " ₪ "
                +"\n Delivery price is : " + CustomerCartPage.getPriceFromCart(ElementsRepo.delivery_price) + " ₪ "
                + "\n Total price is : " + Double.sum(CustomerCartPage.getPriceFromCart(ElementsRepo.milk_price), CustomerCartPage.getPriceFromCart(ElementsRepo.delivery_price)) + " ₪ ");
    }

    public static  void removeProductFromCart(By by){
        ToolsManager.clickOnElement(by);
    }
}
