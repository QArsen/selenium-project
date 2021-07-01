package Pages.StratPage;

import Base.BaseClass;

public class StartPage extends BaseClass {



    public static boolean verifyPageTitle(){
        String title =  driver.getTitle().trim();
        return title.contains(prop.getProperty("start_page_title"));
    }
}
