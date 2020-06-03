package Pages.MilkProductsCustomListPage;

import Base.BaseClass;
import Base.Elements;
import org.openqa.selenium.*;

import java.util.*;

public class MilkProductsCustomListPage extends BaseClass {

    public void clickOnRelevanceFilterButton() {
        waitForElementIsPresent(Elements.relevance_filter_button).click();
    }

    // doesn`t work properly(After milk selection I get all the products - not milk,  according to price filter)
    // Here I select needed filter from dropdown menu
    public void selectFilterFromCheapToExpensive() {
        List<WebElement> list = Elements.drop_down_relevance_menu;
        try {
            for (WebElement element : list) {
                if (element.getText().equalsIgnoreCase("מחיר: נמוך עד גבוה")) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {

        }
    }

    //I click on this button to get milk list only
    public void clickOnSearchIcon() {
        Elements.searching_icon.click();
    }

    // After this button on clicking,  vodka (halavi) and body milk disappear from milk list :)
    public void clickOnListButton() {
        waitForElementIsPresent(Elements.list_button).click();
    }

    public void findYourCheapestMilkInListAndClickOnIt() {
        // list with prices
        List<WebElement> prices = Elements.prices;
        //List with names
        List<WebElement> names = Elements.names;
        String price;
        String name;

        // Key - names(String), Value - prices(String)
        Map<String, Double> map = new HashMap<>();
        // Adding prices and names to Map and converting prices to Double
        for (int i = 0; i < prices.size(); i++) {
            //product price
            price = prices.get(i).getText();
            double priseInDouble = Double.parseDouble(price);
            // product name
            name = names.get(i).getText();
            map.put(name, priseInDouble);
        }
        //Here I get my Key (name of milk) by Value(lowest price) that I get from findSmallest() function
        // and compare product name  with List of names where I hold all elements point on objects in DOM (names of product)
        // and when I find  name in List "names" I click on it.
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals(findSmallest(map))) {
                for (WebElement element : names) {
                    if (element.getText().contains(entry.getKey())) {
                        try {
                            element.click();
                        } catch (ElementNotInteractableException e) {

                        }
                    }
                }
                break;
            }
        }
    }

    //Adding to cart button
    public void clickOnAddToCartButton() {
        waitForElementIsPresent(Elements.add_to_cart_button).click();
    }

    //Clicking on "X" (close) button at the "Add to Cart" popup
    public void clickOnCloseButtonAtTheAddToCartPopup() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = waitForElementIsPresent(Elements.close_add_to_cart_button);
        js.executeScript("arguments[0].click();", element);
    }

    // In the Map I search lowest price
    public Double findSmallest(Map<String, Double> map) {
        double min = Collections.min(map.values());
        return min;
    }
}
