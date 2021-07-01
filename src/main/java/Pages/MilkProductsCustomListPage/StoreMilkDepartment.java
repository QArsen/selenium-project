package Pages.MilkProductsCustomListPage;

import Base.BaseClass;
import Base.ElementsRepo;
import Base.ToolsManager;
import Repos.ObjectsRepo;
import org.openqa.selenium.*;

import java.util.*;

public class StoreMilkDepartment extends BaseClass {


    // doesn`t work properly(After milk selection I get all the products - not milk,  according to price filter)
    // Here I select needed filter from dropdown menu
    // There is no needed to get List as parameter because this List of elements is constant
    public static void selectFilterFromCheapToExpensive(String value) {
        List<WebElement> list = driver.findElements(ElementsRepo.drop_down_relevance_menu);
        try {
            for (WebElement element : list) {
                if (element.getText().equalsIgnoreCase(value)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {

        }
    }

    public static void findYourCheapestMilkInListAndClickOnIt() {
        // list with prices
        List<WebElement> prices = driver.findElements(ElementsRepo.prices);
        //List with names
        List<WebElement> names = driver.findElements(ElementsRepo.names);
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
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    // In the Map I search lowest price
    private static Double findSmallest(Map<String, Double> map) {
        double min = Collections.min(map.values());
        return min;
    }

    public static void addSelectedProductToCart(By elementToAdd, By closeButton){
        ToolsManager.clickOnElement(elementToAdd);
        ToolsManager.clickOnElementJSExecutor(closeButton);
    }
}
