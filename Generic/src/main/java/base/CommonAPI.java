package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;

    public String browserstack_username;
    public String browserstack_accesskey;
    public String saucelabs_username;
    public String saucelabs_accesskey;

    @BeforeMethod
    @Parameters({"browser_name", "operating_system", "URL"})
    public void setUp(String browserName, String os, String url) {
        getLocalDriver(browserName, os);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\naxta\\IdeaProjects\\day1\\Generic\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\naxta\\IdeaProjects\\day1\\Generic\\driver\\chromedriver");
                driver = new ChromeDriver();
            }
        }
        if (browserName.equalsIgnoreCase("gecko")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\naxta\\IdeaProjects\\day1\\Generic\\driver\\geckodriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\naxta\\IdeaProjects\\day1\\Generic\\driver\\geckodriver");
                driver = new ChromeDriver();
            }
        }

        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    //for sending values in required fields by different elements
    public void typeByxpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void typeByID(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public void typeByname(String locator, String value) {
        driver.findElement(By.name(locator)).sendKeys(value);
    }

    public void typeByClassName(String locator, String value) {
        driver.findElement(By.className(locator)).sendKeys(value);
    }


    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void clickByName(String locator) {
        driver.findElement(By.name(locator)).click();
    }

    public void clickByClassName(String locator) {
        driver.findElement(By.className(locator)).click();
    }


    public void takeEnterKeys(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }

    public void takeEnterKeysbyID(String locator) {
        driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
    }

    public void takeEnterKeysbyName(String locator) {
        driver.findElement(By.name(locator)).sendKeys(Keys.ENTER);
    }

    public void takeEnterKeysbycssSelector(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }

    //to get the current page url
    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    //to navigate to the previous page
    public void navigateBack() {
        driver.navigate().back();
    }

    //to move to the next page
    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }


    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    //iFrame Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }

    public void clearInput(String locator){
        driver.findElement(By.xpath(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }

}