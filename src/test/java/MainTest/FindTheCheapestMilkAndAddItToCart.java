package MainTest;

import Base.BaseClass;
import Base.ElementsRepo;
import Base.ToolsManager;
import Pages.CartPage.CustomerCartPage;
import Pages.LoginPage.LoginPage;
import Pages.MilkProductsCustomListPage.StoreMilkDepartment;
import Pages.StratPage.StartPage;
import Repos.ObjectsRepo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTheCheapestMilkAndAddItToCart extends BaseClass {

    public FindTheCheapestMilkAndAddItToCart(){
        super();
    }

    @Test
    public void findTheCheapestMilkAndAddItToCart()  {

        //region Pre Test

        //region Page Title validation
        Assert.assertTrue(StartPage.verifyPageTitle(), prop.getProperty("start_page_title"));
        //endregion Page Title validation

        //region Login and user validation
        LoginPage.loginAsValidUser(prop.getProperty("username"),prop.getProperty("password"), ElementsRepo.login_button);
        Assert.assertTrue(LoginPage.verifyElementContentAfterLogin(ElementsRepo.user_Logo, ObjectsRepo.userName));
        Assert.assertTrue(LoginPage.verifyElementContentAfterLogin(ElementsRepo.page_Logo, ObjectsRepo.defaultPageLogo));
        //endregion Login and user validation

        //endregion Pre Test

        //region Test
        //region Product Searching
        ToolsManager.sendKeys(ElementsRepo.searching_field, prop.getProperty("product"));
        ToolsManager.clickOnElement(ElementsRepo.all_results_link);
        //endregion Product Searching

        //region Finding the cheapest product
        StoreMilkDepartment.selectFilterFromCheapToExpensive(ObjectsRepo.priseRegulator);
        ToolsManager.clickOnElement(ElementsRepo.searching_icon);
        ToolsManager.clickOnElement(ElementsRepo.list_button);
        StoreMilkDepartment.findYourCheapestMilkInListAndClickOnIt();
        StoreMilkDepartment.addSelectedProductToCart(ElementsRepo.add_to_cart_button,ElementsRepo.close_add_to_cart_button);
        //endregion Finding the cheapest product

        //region Check your delivery and  product prices
        Assert.assertEquals(Double.sum(CustomerCartPage.getPriceFromCart(ElementsRepo.delivery_price),
                CustomerCartPage.getPriceFromCart(ElementsRepo.milk_price)), CustomerCartPage.getTotalPriceFromCart(ElementsRepo.total_price),
                 "Check your cart, it is the wrong price");
        CustomerCartPage.printTestResults();
        CustomerCartPage.removeProductFromCart(ElementsRepo.remove_product);
        //endregion Check your delivery and  product prices
        //endregion Test
    }
}
