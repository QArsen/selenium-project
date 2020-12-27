package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;


public class Elements {


    //Login Page elements
    @FindBy(id = "loginDropdownContainer")
    public static WebElement login_link;

    @FindAll({
            @FindBy(how = How.ID, using = "j_username"),
            @FindBy(how = How.ID, using = "j_password")
    })
    public static List<WebElement> credentials;


    @FindBy(xpath = "//div[@class='bottomSide']/button")
    public static WebElement login_button;

    @FindBy(how = How.XPATH, using  = "//a[@class='info']")
    public static WebElement user_name;

    @FindBy(how = How.XPATH, using  = "//span[@class='prefix  cartEmptyJs ']")
    public static WebElement page_logo;


    // Milk searching  elements
    @FindBy(id = "js-site-search-input")
    public static WebElement searching_field;

    @FindBy (how = How.XPATH, using = "//div[@class='allProductsTitleContainer']/button")
    public static WebElement all_results_link;


    @FindBy(xpath = "//i[@class='icon icon-search']")
    public static WebElement searching_icon;

    @FindBy(xpath = "//div[@class='chooseFilter']//li[@class='listView']/button")
    public static WebElement list_button;

    @FindBys(@FindBy(xpath = "//div[@class='line']//span[@class='price']//span[@class='number']"))
    public static List<WebElement> prices;

    @FindBys(@FindBy(xpath = "//div[@class='middleContainer']//div[@class='text']//strong"))
    public static List<WebElement> names;


    //All products Page elements
    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    public static WebElement icon_counter;


    // Find cheapest milk elements
    @FindBy (xpath = "//div[@class='btn-group bootstrap-select']/button")
    public static WebElement relevance_filter_button;

    @FindBys(@FindBy(xpath = "//div[@class='dropdown-menu open']/ul/li/a/span"))
    public static List<WebElement> drop_down_relevance_menu;

    @FindBys(@FindBy(xpath = "//div[@class='price col-xs-12 col-lg-3']/div/span/span[@class='number']"))
    public static List<WebElement> price;


    //Add To Cart elements
    @FindBy(xpath = "//div[@class='productDetails']//button[@class='btn js-add-to-cart js-enable-btn miglog-btn-add']")
    public static WebElement add_to_cart_button;

    @FindBy(xpath = "//div[@class='modal fade productModal centerModal bodyModalAppend in']//div[@class='modal-dialog']//button[@class='btnClose']")
    public static WebElement close_add_to_cart_button;


    //Cart Page elements
    @FindBy(xpath  = "//span[@class='infoSubText']")
    @CacheLookup
    public static WebElement delivery_price;

    @FindBy(how = How.XPATH, using  = "//div[@class='miglog-prod-body']//p[@class='miglog-text2 miglog-prod-totalPrize']//span[1]")
    @CacheLookup
    public static WebElement milk_price;

    @FindBy(xpath  = "//div[@class='price']//span[@class='currency']")
    @CacheLookup
    public static WebElement total_price;

    @FindBy(xpath  = "//div[@class='miglog-cart-summary-prod-wrp miglog-cart-prod-wrp']//a[@role='button']")
    public static WebElement remove_product;
}
