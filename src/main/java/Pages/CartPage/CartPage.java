package Pages.CartPage;

import Base.BaseClass;
import Base.Elements;
import org.openqa.selenium.WebElement;

public class CartPage  extends BaseClass {


    // Here I get delivery price -> double
    public double getDeliveryPriceFromCart(){
        return getPriceFromCart(waitForElementIsPresent(Elements.delivery_price));
    }

    // Here I get milk price -> double
    public double  getMilkPriceFromCart(){
        return getPriceFromCart(waitForElementIsPresent(Elements.milk_price));
    }

    // Here I get total price (milk + delivery) -> double
    public double getTotalPriceFromCart(){
        return getPriceFromCart(waitForElementIsPresent(Elements.total_price));
    }

    //Parsing String to double
    public double  getPriceFromCart(WebElement element){
        double price;
        String  str = element.getText().trim().replaceAll("[^0-9.]+", " ");
        price = Double.parseDouble(str);
        return price;
    }

    public void removeProductFromCart(){
        waitForElementIsPresent(Elements.remove_product).click();
    }
}
