package testCases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import theModel.Shop;

public class testShop extends CommonAPI {
    @Test
    public void shppping() {
        Shop sp = PageFactory.initElements(driver, Shop.class);
        sp.shopping();



    }


}
