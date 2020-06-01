package Pages.SearchMilkPage;

import Base.BaseClass;
import Base.Elements;


public class SearchMilkPage extends BaseClass {



    public void searchMilkInSearchField(String product){
        Elements.searching_field.sendKeys(product);
    }

    public void clickOnToAllResultsLink()  {
        waitForElementIsPresent(Elements.all_results_link).click();
    }
}
