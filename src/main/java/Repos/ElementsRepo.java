package Repos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;


public class ElementsRepo {

    //Login Page elements
    public static By login_link = By.id("loginDropdownContainer");
    public static By user_Name = By.id("j_username");
    public static By user_Password = By.id("j_password");
    public static By login_button = By.xpath("//div[@class='bottomSide']/button");

    public static By user_Logo = By.xpath("//a[@class='info']");
    public static By page_Logo = By.xpath("//span[@class='prefix  cartEmptyJs ']");

    // Milk searching  elements
    public static By searching_field = By.id("js-site-search-input");
    public static By all_results_link = By.xpath("//div[@class='allProductsTitleContainer']/button");
    public static By searching_icon = By.xpath("//i[@class='icon icon-search']");
    public static By list_button = By.xpath("//div[@class='chooseFilter']//li[@class='listView']/button");
    public static By prices = By.xpath("//div[@class='line']//span[@class='price']//span[@class='number']");
    public static By names = By.xpath("//div[@class='middleContainer']//div[@class='text']//strong");
    public static By drop_down_relevance_menu = By.xpath("//div[@class='dropdown-menu open']/ul/li/a/span");

    //Add To Cart elements
    public static By add_to_cart_button = By.xpath("//div[@class='productDetails']//button[contains(@class,'btn js-add-to-cart')]");
    public static By close_add_to_cart_button = By.xpath("//div[contains(@class,'modal fade productModal')]//button[@class='btnClose']");

    //Cart Page elements
    public static By delivery_price = By.xpath("//span[@class='infoSubText']");
    public static By milk_price = By.xpath("//div[@class='miglog-prod-body']//p[@class='miglog-text2 miglog-prod-totalPrize ']");
    public static By total_price = By.xpath("//div[@class='price']//span[@class='currency']");

    // remove product from cart
    public static By remove_product = By.xpath("//div[@class='miglog-cart-summary-prod-wrp miglog-cart-prod-wrp']//a[@role='button']");

}
