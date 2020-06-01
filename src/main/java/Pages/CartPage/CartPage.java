package Pages.CartPage;

import Base.BaseClass;
import Base.Elements;
import org.openqa.selenium.WebElement;

public class CartPage  extends BaseClass {


    // Here I get delivery price -> double
    public double getDeliveryPriceFromCart(){
       double  price  = getPriceFromCart(waitForElementIsPresent(Elements.delivery_price));
       return price ;
    }

    // Here I get milk price -> double
    public double  getMilkPriceFromCart(){
        double price  = getPriceFromCart(waitForElementIsPresent(Elements.milk_price));
        return  price;
    }

    // Here I get total price (milk + delivery) -> double
    public double getTotalPriceFromCart(){
        double  price  = getPriceFromCart(waitForElementIsPresent(Elements.total_price));
        return price;
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
