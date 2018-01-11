package theModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Shop {

    @FindBy(xpath = ".//*[@id='tsla-header-main']/div/div/nav/div[1]/ol/li[6]/ol/li[1]/a")
    WebElement shopLogo;
    @FindBy(xpath = "html/body/header/div[2]/section/nav/div/div[1]/span[2]/a")
    WebElement apparel;
    @FindBy(xpath = "html/body/header/div[2]/section/nav/div/div[1]/div[2]/div/div[6]/ul/li[4]/a")
    WebElement other;
    @FindBy(xpath = "html/body/main/div/div/div/div[5]/div/ul/li[1]/div[2]/a[1]")
    WebElement modelS;
    @FindBy(xpath = ".//*[@id='product-color']/ul/li[2]/label")
    WebElement selectRed;
    @FindBy(id = "buy")
    WebElement checkout;

    public void shopping(){
        shopLogo.click();
        apparel.click();
        other.click();
        modelS.click();
        selectRed.click();
        checkout.click();

    }


}
