package Pages.StratPage;

import Base.BaseClass;
import Base.Elements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StartPage extends BaseClass {



    public boolean verifyPageTitle(){
        String title =  driver.getTitle().trim();
        return title.contains(prop.getProperty("start_page_title"));
    }
}
